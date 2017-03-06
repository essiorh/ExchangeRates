package developer.essiorh.exchangerates.data.db;

import java.util.ArrayList;
import java.util.List;

import developer.essiorh.exchangerates.data.db.common.BaseLocalStorage;
import io.realm.RealmResults;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class RatesLocalStorage extends BaseLocalStorage implements IRatesLocalStorage {
    @Override
    public void saveRates(List<RatesRealm> ratesRealmList) {
        try {
            open();
            realm.executeTransaction(realm1 -> {
                realm1.delete(RatesRealm.class);
                realm1.delete(Rate.class);
                for (RatesRealm ratesRealm : ratesRealmList) {
                    realm1.copyToRealm(ratesRealm.getRates());
                }
                realm1.copyToRealm(ratesRealmList);
            });
        } catch (Exception e) {
            System.out.println("storage error = " + e.getMessage());
        } finally {
            close();
        }
    }

    @Override
    public List<RatesRealm> getRates() {
        try {
            open();
            RealmResults<RatesRealm> ratesRealmResults = realm.where(RatesRealm.class).findAll();
            return realm.copyFromRealm(ratesRealmResults);
        } catch (Exception e) {
            System.out.println("storage error = " + e.getMessage());
        } finally {
            close();
        }
        return new ArrayList<>();
    }
}
