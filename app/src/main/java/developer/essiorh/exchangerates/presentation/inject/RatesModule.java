package developer.essiorh.exchangerates.presentation.inject;

import org.mapstruct.factory.Mappers;

import dagger.Module;
import dagger.Provides;
import developer.essiorh.exchangerates.data.db.IRatesLocalStorage;
import developer.essiorh.exchangerates.data.db.RatesLocalStorage;
import developer.essiorh.exchangerates.data.mapper.RatesMapper;
import developer.essiorh.exchangerates.data.rest.IRatesRestApi;
import developer.essiorh.exchangerates.data.rest.RatesRestApi;
import developer.essiorh.exchangerates.domain.IRatesInteractor;
import developer.essiorh.exchangerates.domain.RatesInteractor;
import developer.essiorh.exchangerates.domain.repository.IRatesRepository;
import developer.essiorh.exchangerates.domain.repository.RatesRepository;
import developer.essiorh.exchangerates.presentation.rates.IRatesPresenter;
import developer.essiorh.exchangerates.presentation.rates.RatesPresenter;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

@Module
class RatesModule {
    @Provides
    IRatesPresenter iMainPresenter(IRatesInteractor interactor) {
        return new RatesPresenter(interactor);
    }

    @Provides
    IRatesInteractor interactor(IRatesRepository repository) {
        return new RatesInteractor(repository);
    }

    @Provides
    IRatesRepository iRatesRepository(IRatesRestApi restApi, IRatesLocalStorage localStorage,
                                      RatesMapper mapper) {
        return new RatesRepository(restApi, localStorage, mapper);
    }

    @Provides
    IRatesLocalStorage iRatesLocalStorage() {
        return new RatesLocalStorage();
    }

    @Provides
    IRatesRestApi iRatesRestApi() {
        return new RatesRestApi();
    }

    @Provides
    RatesMapper ratesMapper() {
        return Mappers.getMapper(RatesMapper.class);
    }
}
