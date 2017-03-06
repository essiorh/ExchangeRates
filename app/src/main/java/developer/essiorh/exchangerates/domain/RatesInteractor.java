package developer.essiorh.exchangerates.domain;

import java.util.List;

import javax.inject.Inject;

import developer.essiorh.exchangerates.domain.common.BaseInteractor;
import developer.essiorh.exchangerates.domain.repository.IRatesRepository;
import developer.essiorh.exchangerates.presentation.rates.RatesContainer;
import rx.Subscriber;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RatesInteractor extends BaseInteractor implements IRatesInteractor {

    private final IRatesRepository repository;

    @Inject
    public RatesInteractor(IRatesRepository repository) {
        this.repository = repository;
    }

    @Override
    public void getLatestRates(Subscriber<List<RatesContainer>> subscriber) {
        addSubscription(subscriber);
        repository.getRates(subscriber);
    }
}
