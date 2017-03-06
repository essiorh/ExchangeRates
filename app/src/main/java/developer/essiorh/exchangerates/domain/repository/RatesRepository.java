package developer.essiorh.exchangerates.domain.repository;

import java.util.List;

import javax.inject.Inject;

import developer.essiorh.exchangerates.data.db.IRatesLocalStorage;
import developer.essiorh.exchangerates.data.db.RatesRealm;
import developer.essiorh.exchangerates.data.mapper.RatesMapper;
import developer.essiorh.exchangerates.data.rest.IRatesRestApi;
import developer.essiorh.exchangerates.data.rest.RatesResponse;
import developer.essiorh.exchangerates.data.rest.RestConst;
import developer.essiorh.exchangerates.presentation.rates.RatesContainer;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RatesRepository implements IRatesRepository {

    private final IRatesRestApi restApi;
    private final IRatesLocalStorage localStorage;
    private final RatesMapper mapper;

    @Inject
    public RatesRepository(IRatesRestApi restApi, IRatesLocalStorage localStorage,
                           RatesMapper mapper) {
        this.restApi = restApi;
        this.localStorage = localStorage;
        this.mapper = mapper;
    }

    @Override
    public void getRates(Subscriber<List<RatesContainer>> subscriber) {
        List<RatesRealm> localRates = localStorage.getRates();
        subscriber.onNext(mapper.ratesRealmsToRatesContainers(localRates));
        Observable<RatesResponse> observable = Observable.empty();
        List<String> latestDates = DateHelper.getListOfLatestDates();
        for (String date : latestDates) {
            Observable<RatesResponse> ratesFromRest =
                    restApi.getRatesByDate(date, RestConst.RequestFields.RUB);
            observable = Observable.concat(observable, ratesFromRest);
        }
        observable
                .toList()
                .map(ratesResponses -> {
                    List<RatesRealm> preparedToSaveRates =
                            mapper.ratesResponsesToRatesRealms(ratesResponses);
                    localStorage.saveRates(preparedToSaveRates);
                    return mapper.ratesResponsesToRatesContainers(ratesResponses);
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
