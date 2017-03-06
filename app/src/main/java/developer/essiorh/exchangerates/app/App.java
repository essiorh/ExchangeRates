package developer.essiorh.exchangerates.app;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public class App extends Application {

    private static final String TAG = App.class.getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
    }

    private void initRealm() {
        Log.d(TAG, "initRealm() starts");
        Realm.init(this);
        RealmConfiguration defaultConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(defaultConfiguration);
        Realm realm = null;
        try {
            realm = Realm.getDefaultInstance();
        } catch (IllegalArgumentException exception) {
            Log.e(TAG, "Can't migrate mRealm, deleting mRealm base to not crush", exception);
            Realm.deleteRealm(defaultConfiguration);
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }
}
