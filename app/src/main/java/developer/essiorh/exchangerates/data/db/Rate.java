package developer.essiorh.exchangerates.data.db;

import io.realm.RealmObject;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class Rate extends RealmObject {

    private String currency;
    private float value;

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
