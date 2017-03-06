package developer.essiorh.exchangerates.data.rest;

import developer.essiorh.exchangerates.data.rest.common.ServiceFactory;
import rx.Observable;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RatesRestApi implements IRatesRestApi {
    @Override
    public Observable<RatesResponse> getRatesByDate(String date, String base) {
        RatesService ratesService = ServiceFactory.createRetrofitService(RatesService.class,
                RestConst.SERVICE_ENDPOINT);
        return ratesService.getRatesByDate(RestConst.SERVICE_ENDPOINT + date, base);
    }
}
