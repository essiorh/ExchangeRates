package developer.essiorh.exchangerates.presentation.common;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public interface IBasePresenter<View, Router> {
    void onStart();

    void onStop();

    View getView();

    void setView(View view);

    Router getRouter();

    void setRouter(Router router);
}