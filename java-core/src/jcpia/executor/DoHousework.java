package jcpia.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DoHousework {

    private final ExecutorService executor;

    public DoHousework(ExecutorService executorService) {
        this.executor = executorService;
    }

    void doWork(List<HouseWork> list) {
        CompletionService<String> cs = new ExecutorCompletionService<>(executor);
        for (final HouseWork hw : list) {
            cs.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(hw.getCostMinutes() * 100);
                    System.out.println(hw.getName() + " spend " + hw.getCostMinutes() + " minutes");
                    return "done";
                }
            });
        }

        for (int i = 0; i < list.size(); i++) {
            try {
                Future<String> f = cs.take();
                String result = f.get();
                System.out.println("result: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

    private static class HouseWork {
        private String name;
        private int costMinutes;

        public HouseWork(String name, int costMinutes) {
            this.name = name;
            this.costMinutes = costMinutes;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCostMinutes() {
            return costMinutes;
        }

        public void setCostMinutes(int costMinutes) {
            this.costMinutes = costMinutes;
        }
    }

    public static void main(String[] args) {
        HouseWork cookDinner = new HouseWork("Cook Dinner", 60);
        HouseWork washDishes = new HouseWork("Wash Dishes", 30);
        List<HouseWork> list = new ArrayList<>();
        list.add(cookDinner);
        list.add(washDishes);

        DoHousework doHousework = new DoHousework(Executors.newFixedThreadPool(2));
        doHousework.doWork(list);
    }


}
