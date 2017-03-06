package developer.essiorh.exchangerates.presentation.inject;

import javax.inject.Singleton;

import dagger.Component;
import developer.essiorh.exchangerates.presentation.rates.RatesFragment;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

@Singleton
@Component(modules = RatesModule.class)
public interface RatesActivityComponent {
    void inject(RatesFragment ratesFragment);
}
