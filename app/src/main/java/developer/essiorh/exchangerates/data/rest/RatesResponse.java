package developer.essiorh.exchangerates.data.rest;

import com.google.gson.annotations.SerializedName;

import static developer.essiorh.exchangerates.data.rest.RestConst.ResponseFields.BASE;
import static developer.essiorh.exchangerates.data.rest.RestConst.ResponseFields.DATE;
import static developer.essiorh.exchangerates.data.rest.RestConst.ResponseFields.RATES;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RatesResponse {

    @SerializedName(DATE)
    private String date;
    @SerializedName(BASE)
    private String base;
    @SerializedName(RATES)
    private Map<String, float> rates;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, float> getRates() {
        return rates;
    }

    public void setRates(Map<String, float> rates) {
        this.rates = rates;
    }
}
