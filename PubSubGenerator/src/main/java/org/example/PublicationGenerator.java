package org.example;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class PublicationGenerator {
    private static final Logger logger = Logger.getLogger(PublicationGenerator.class.getName());

    public static List<String> generatePublications(int count) {
        List<String> publications = new ArrayList<>(count);
        ExecutorService executor = Executors.newFixedThreadPool(Config.NUM_THREADS);
        List<Future<List<String>>> futures = new ArrayList<>();

        int perThread = count / Config.NUM_THREADS;

        for (int i = 0; i < Config.NUM_THREADS; i++) {
            int finalCount = (i == Config.NUM_THREADS - 1) ? count - perThread * i : perThread;
            futures.add(executor.submit(() -> {
                List<String> localList = new ArrayList<>();
                for (int j = 0; j < finalCount; j++) {
                    localList.add(Publication.generate());
                }
                return localList;
            }));
        }

        for (Future<List<String>> future : futures) {
            try {
                publications.addAll(future.get());
            } catch (Exception e) {
                logger.severe("Error in thread: " + e.getMessage());
            }
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                System.err.println("Executor did not terminate in time. Forced shutdown.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            System.err.println("Awaiting termination was interrupted. Forced shutdown.");
        }
        return publications;
    }

    public static void writeToFile(List<String> publications, String filename) throws Exception {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (String p : publications) writer.println(p);
        }
    }
}

