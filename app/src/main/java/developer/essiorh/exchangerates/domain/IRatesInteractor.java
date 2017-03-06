package developer.essiorh.exchangerates.domain;

import java.util.List;

import developer.essiorh.exchangerates.domain.common.IBaseInteractor;
import developer.essiorh.exchangerates.presentation.rates.RatesContainer;
import rx.Subscriber;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public interface IRatesInteractor extends IBaseInteractor {
    void getLatestRates(Subscriber<List<RatesContainer>> subscriber);
}
