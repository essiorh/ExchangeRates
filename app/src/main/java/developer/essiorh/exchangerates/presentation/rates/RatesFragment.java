package developer.essiorh.exchangerates.presentation.rates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import developer.essiorh.exchangerates.R;
import developer.essiorh.exchangerates.presentation.common.BaseFragment;
import developer.essiorh.exchangerates.presentation.common.Layout;
import developer.essiorh.exchangerates.presentation.common.SimpleDividerItemDecoration;
import developer.essiorh.exchangerates.presentation.inject.RatesActivityComponent;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

@Layout(id = R.layout.fragment_main)
public class RatesFragment extends BaseFragment implements RatesView,
        SwipeRefreshLayout.OnRefreshListener {

    @Inject
    IRatesPresenter presenter;

    @Bind(R.id.swipeToRefresh)
    SwipeRefreshLayout swipeToRefresh;
    @Bind(R.id.rvList)
    RecyclerView rvList;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setToolbarTitle(getString(R.string.rates_fragment_title));
        rvList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvList.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        swipeToRefresh.setOnRefreshListener(this);
        refreshData();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
        dismissRefreshing();

    }

    @Override
    public void onRefresh() {
        presenter.loadLatestRates();
    }

    @Override
    public void updateRates(List<RatesContainer> ratesList) {
        RatesAdapter ratesAdapter;
        if (rvList.getAdapter() == null) {
            ratesAdapter = new RatesAdapter(ratesList);
            rvList.setAdapter(ratesAdapter);
            return;
        }
        ratesAdapter = (RatesAdapter) rvList.getAdapter();
        ratesAdapter.updateData(ratesList);
    }

    @Override
    public void showError(@StringRes int message) {
        super.showError(message);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {
        super.showError(message);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void dismissRefreshing() {
        if (swipeToRefresh == null) {
            return;
        }
        swipeToRefresh.setRefreshing(false);
    }

    @Override
    public void ratesUpdatedSuccessfully() {
        Toast.makeText(getContext(), R.string.update_data_message, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    protected IRatesPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject() {
        getActivityComponent().inject(this);
    }

    private RatesActivityComponent getActivityComponent() {
        return ((RatesActivityComponentProvider) getActivity()).getComponent();
    }

    private void refreshData() {
        if (swipeToRefresh == null) {
            return;
        }
        swipeToRefresh.post(() -> {
            if (swipeToRefresh == null) {
                return;
            }
            swipeToRefresh.setRefreshing(true);
            onRefresh();
        });
    }
}
