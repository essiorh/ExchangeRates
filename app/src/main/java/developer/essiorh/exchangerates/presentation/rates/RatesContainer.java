package developer.essiorh.exchangerates.presentation.rates;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RatesContainer {
    private String date;
    private String base;
    private String ratesPreview;

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

    String getRatesPreview() {
        return ratesPreview;
    }

    public void setRatesPreview(String rates) {
        this.ratesPreview = rates;
    }
}
