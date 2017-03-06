package developer.essiorh.exchangerates.presentation.common;

import android.support.annotation.StringRes;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public interface BaseView {
    void showError(@StringRes int message);

    void showError(String message);
}
