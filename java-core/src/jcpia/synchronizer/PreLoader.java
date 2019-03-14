package jcpia.synchronizer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class PreLoader {

    private final FutureTask<Preload> futureTask = new FutureTask<>(new Callable<Preload>() {
        @Override
        public Preload call() throws Exception {

            return load();
        }
    });

    private Thread thread = new Thread(futureTask);

    public void start() {
        thread.start();
    }

    public Preload get() throws ExecutionException, InterruptedException {
        return futureTask.get();
    }

    private Preload load() {
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PreLoader preLoader = new PreLoader();
        preLoader.start();
        Preload preload = preLoader.get();
        // do something
    }

}

class Preload {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
