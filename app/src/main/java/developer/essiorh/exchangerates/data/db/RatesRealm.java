package developer.essiorh.exchangerates.data.db;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RatesRealm extends RealmObject {
    private String date;
    private String base;
    private RealmList<Rate> ratesList;

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

    public RealmList<Rate> getRatesList() {
        return ratesList;
    }

    public void setRatesList(RealmList<Rate> ratesList) {
        this.ratesList = ratesList;
    }
}
