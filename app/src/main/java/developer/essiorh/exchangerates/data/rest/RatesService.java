package developer.essiorh.exchangerates.data.rest;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

interface RatesService {
    @GET
    Observable<RatesResponse> getRatesByDate(@Url String request,
                                             @Query(RestConst.ResponseFields.BASE) String base);
}
