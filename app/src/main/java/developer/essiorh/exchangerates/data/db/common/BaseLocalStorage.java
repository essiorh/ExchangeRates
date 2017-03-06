package developer.essiorh.exchangerates.data.db.common;

import io.realm.Realm;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class BaseLocalStorage implements IBaseLocalStorage {
    protected Realm realm;

    @Override
    public synchronized void open() {
        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }
    }

    @Override
    public synchronized void close() {
        if (realm != null && !realm.isClosed()) {
            realm.close();
            realm = null;
        }
    }
}
