package net.f.p1.callbackEX;

/**
 * Created by fortune on 4/15/15.
 */
public interface FetcherCallback {

    void onData(Data data);

    void onError(Throwable t);
}
