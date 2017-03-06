package developer.essiorh.exchangerates.domain.common;

import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by eSSiorh
 * on 06/03/17
 */

public abstract class BaseInteractor {
    private CompositeSubscription subscription;

    protected BaseInteractor() {
        subscription = new CompositeSubscription();
    }

    protected <R> void addSubscription(Subscriber<R> subscriber) {
        subscription.add(subscriber);
    }

    public void unsubscribe() {
        subscription.unsubscribe();
    }
}
