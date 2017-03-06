package developer.essiorh.exchangerates.presentation.common;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    private static final String TAG = BaseFragment.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class)) return null;
        Annotation annotation = cls.getAnnotation(Layout.class);
        Layout layout = (Layout) annotation;
        View view = inflater.inflate(layout.id(), null);
        ButterKnife.bind(this, view);
        Log.d(this.getClass().getSimpleName(), "onCreateView: ");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(this.getClass().getSimpleName(), "onActivityCreated: ");
        inject();
        //noinspection unchecked
        getPresenter().setView(this);
    }

    @Override
    public void onDestroyView() {
        Log.d(this.getClass().getSimpleName(), "onDestroyView: ");
        ButterKnife.unbind(this);
        getPresenter().onStop();
        super.onDestroyView();
    }

    @Override
    public void showError(@StringRes int message) {
        Log.d(TAG, "showError: message = " + getString(message));
    }

    @Override
    public void showError(String message) {
        Log.d(TAG, "showError: message = " + message);
    }

    protected void setToolbarTitle(CharSequence pageTitle) {
        ActionBar supportActionBar = ((AppCompatActivity) getContext()).getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(pageTitle);
        } else {
            Log.e(TAG, "setToolbarTitle: actionbar is null");
        }
    }

    @NonNull
    protected abstract IBasePresenter getPresenter();

    protected abstract void inject();
}
