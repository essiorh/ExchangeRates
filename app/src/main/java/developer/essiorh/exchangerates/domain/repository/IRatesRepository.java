package developer.essiorh.exchangerates.domain.repository;

import java.util.List;

import developer.essiorh.exchangerates.presentation.rates.RatesContainer;
import rx.Subscriber;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public interface IRatesRepository {
    void getRates(Subscriber<List<RatesContainer>> subscriber);
}
