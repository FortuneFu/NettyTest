package net.f.p1.callbackEX;

/**
 * Created by fortune on 4/15/15.
 */
public class MyFetcher implements Fetcher {

    private Data data;

    public MyFetcher(Data data) {
        this.data = data;
    }

    public void fetchData(FetcherCallback callback) {
        try {
            callback.onData(data);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
