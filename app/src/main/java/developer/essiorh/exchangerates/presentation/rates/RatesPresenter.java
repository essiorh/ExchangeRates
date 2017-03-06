package developer.essiorh.exchangerates.presentation.rates;

import java.util.List;

import javax.inject.Inject;

import developer.essiorh.exchangerates.R;
import developer.essiorh.exchangerates.domain.IRatesInteractor;
import developer.essiorh.exchangerates.presentation.common.BasePresenter;
import rx.Subscriber;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RatesPresenter extends BasePresenter<RatesView, RatesRouter>
        implements IRatesPresenter {

    private final IRatesInteractor interactor;

    // flag for banning multiple requests
    private boolean isRequestActive;

    @Inject
    public RatesPresenter(IRatesInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void loadLatestRates() {
        System.out.println("load latest rates isRequestActive = " + isRequestActive);
        if (isRequestActive) {
            getView().dismissRefreshing();
            return;
        }
        isRequestActive = true;
        interactor.getLatestRates(new Subscriber<List<RatesContainer>>() {
            @Override
            public void onCompleted() {
                System.out.println("RatesPresenter.onCompleted");
                isRequestActive = false;
                getView().dismissRefreshing();
                getView().ratesUpdatedSuccessfully();
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("RatesPresenter.onError");
                getView().showError(R.string.network_error_message);
                getView().dismissRefreshing();
                isRequestActive = false;
            }

            @Override
            public void onNext(List<RatesContainer> ratesContainers) {
                System.out.println("RatesPresenter.onNext");
                getView().updateRates(ratesContainers);
            }
        });
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        interactor.unsubscribe();
        isRequestActive = false;
    }
}
