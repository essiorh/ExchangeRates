package developer.essiorh.exchangerates.data.rest;

import rx.Observable;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public interface IRatesRestApi {
    Observable<RatesResponse> getRatesByDate(String date, String base);
}
