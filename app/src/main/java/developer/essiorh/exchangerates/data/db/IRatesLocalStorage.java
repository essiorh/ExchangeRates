package developer.essiorh.exchangerates.data.db;

import java.util.List;

import developer.essiorh.exchangerates.data.db.common.IBaseLocalStorage;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public interface IRatesLocalStorage extends IBaseLocalStorage {
    void saveRates(List<RatesRealm> ratesRealmList);

    List<RatesRealm> getRates();
}
