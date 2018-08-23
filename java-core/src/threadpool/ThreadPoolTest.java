package threadpool;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter base directory: (e.g. /usr/local/jdk8.0/src): ");
        String directory = in.nextLine();
        System.out.println("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();

        ExecutorService pool = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        MatcherCounter counter = new MatcherCounter(new File(directory), keyword, pool);
        Future<Integer> result = pool.submit(counter);

        try {
            System.out.println(result.get() + " matching files.");
            long end = System.currentTimeMillis();
            System.out.println("cost time=" + (end - start));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pool.shutdown();

        int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
        System.out.println("Largest pool size=" + largestPoolSize);
    }

}

/**
 * This task counts the files in a directory and its subdirectories that contain a given keyword
 */
class MatcherCounter implements Callable<Integer> {

    private File direcotry;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatcherCounter(File directory, String keyword, ExecutorService pool) {
        this.direcotry = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() throws Exception {
        count = 0;
        try {

            File[] files = direcotry.listFiles();
            List<Future<Integer>> results = new ArrayList<>();
            for (File file : files) {
                if (file.isDirectory()) {
                    MatcherCounter counter = new MatcherCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                } else {
                    if (search(file)) count++;
                }
            }

            for (Future<Integer> result : results) {
                try {
                    count += result.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return count;
    }

    private boolean search(File file) {

        try (Scanner in = new Scanner(file)) {
            boolean found = false;
            while (!found && in.hasNextLine()) {
                String line = in.nextLine();
                if (line.contains(keyword)) found = true;
            }
            return found;
        } catch (FileNotFoundException e) {
            return false;
        }

    }
}
