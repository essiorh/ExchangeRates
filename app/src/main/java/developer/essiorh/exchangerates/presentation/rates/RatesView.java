package developer.essiorh.exchangerates.presentation.rates;

import java.util.List;

import developer.essiorh.exchangerates.presentation.common.BaseView;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

interface RatesView extends BaseView {
    void updateRates(List<RatesContainer> ratesList);

    void dismissRefreshing();

    void ratesUpdatedSuccessfully();
}
