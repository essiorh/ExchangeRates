package developer.essiorh.exchangerates.presentation.rates;

import developer.essiorh.exchangerates.presentation.common.IBasePresenter;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public interface IRatesPresenter extends IBasePresenter<RatesView, RatesRouter> {
    void loadLatestRates();
}
