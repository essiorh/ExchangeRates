package developer.essiorh.exchangerates.presentation.rates;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import developer.essiorh.exchangerates.R;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.RatesViewHolder> {

    private List<RatesContainer> ratesList;

    RatesAdapter(List<RatesContainer> ratesList) {
        this.ratesList = ratesList;
    }

    @Override
    public RatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RatesViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.rates_list_item, parent, false));
    }

    @Override
    public int getItemCount() {
        if (ratesList == null) {
            return 0;
        }
        return ratesList.size();
    }

    @Override
    public void onBindViewHolder(RatesViewHolder holder, int position) {
        RatesContainer rates = getItem(position);
        if (rates != null) {
            holder.tvDate.setText(rates.getDate());
            holder.tvBase.setText(rates.getBase());
            holder.tvRates.setText(rates.getRatesPreview());
        }
    }

    void updateData(List<RatesContainer> newRatesList) {
        ratesList = newRatesList;
        notifyDataSetChanged();
    }

    @Nullable
    private RatesContainer getItem(int position) {
        if (ratesList == null || ratesList.size() == 0) {
            return null;
        }
        return ratesList.get(position);
    }

    class RatesViewHolder extends RecyclerView.ViewHolder {

        TextView tvDate;
        TextView tvBase;
        TextView tvRates;

        RatesViewHolder(View itemView) {
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvBase = (TextView) itemView.findViewById(R.id.tvBase);
            tvRates = (TextView) itemView.findViewById(R.id.tvRates);
        }
    }
}
