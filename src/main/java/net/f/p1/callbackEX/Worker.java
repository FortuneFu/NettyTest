package net.f.p1.callbackEX;

/**
 * Created by fortune on 4/15/15.
 */
public class Worker {

    public  void doWork(){
        Fetcher fetcher = new MyFetcher(new Data(1,0));
        fetcher.fetchData(new FetcherCallback() {
            public void onData(Data data) {
                System.out.println("Received data:"+data);
            }

            public void onError(Throwable t) {
                System.out.println("An error:" + t.getMessage());
            }
        });

    }

}
