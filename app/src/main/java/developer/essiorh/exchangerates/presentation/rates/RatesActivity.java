package developer.essiorh.exchangerates.presentation.rates;

import android.os.Bundle;

import developer.essiorh.exchangerates.R;
import developer.essiorh.exchangerates.presentation.common.BaseActivity;
import developer.essiorh.exchangerates.presentation.common.Layout;
import developer.essiorh.exchangerates.presentation.inject.DaggerRatesActivityComponent;
import developer.essiorh.exchangerates.presentation.inject.RatesActivityComponent;

@Layout(id = R.layout.activity_main)
public class RatesActivity extends BaseActivity implements RatesActivityComponentProvider {

    private RatesActivityComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = DaggerRatesActivityComponent
                .builder()
                .build();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContainer, new RatesFragment())
                .commit();
    }

    @Override
    public RatesActivityComponent getComponent() {
        return component;
    }
}
