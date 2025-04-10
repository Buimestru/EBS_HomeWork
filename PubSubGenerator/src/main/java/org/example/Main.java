package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        // Test pentru 1 thread
        System.setProperty("numThreads", "1");
        long start = System.currentTimeMillis();
        List<String> publications = PublicationGenerator.generatePublications(Config.TOTAL_PUBLICATIONS);
        PublicationGenerator.writeToFile(publications, "publications_1_thread.txt");

        List<String> subscriptions = SubscriptionGenerator.generateAllSubscriptions();
        SubscriptionGenerator.writeToFile(subscriptions, "subscriptions_1_thread.txt");
        long end = System.currentTimeMillis();
        System.out.printf("1 Thread: Generated %d publications and %d subscriptions in %d ms%n",
                Config.TOTAL_PUBLICATIONS, Config.TOTAL_SUBSCRIPTIONS, (end - start));

        // Test pentru 4 threads
        System.setProperty("numThreads", "4");
        start = System.currentTimeMillis();
        publications = PublicationGenerator.generatePublications(Config.TOTAL_PUBLICATIONS);
        PublicationGenerator.writeToFile(publications, "publications_4_threads.txt");

        subscriptions = SubscriptionGenerator.generateAllSubscriptions();
        SubscriptionGenerator.writeToFile(subscriptions, "subscriptions_4_threads.txt");
        end = System.currentTimeMillis();
        System.out.printf("4 Threads: Generated %d publications and %d subscriptions in %d ms%n",
                Config.TOTAL_PUBLICATIONS, Config.TOTAL_SUBSCRIPTIONS, (end - start));

        //Specificatiile procesorului
        /*String processorInfo = System.getenv("PROCESSOR_IDENTIFIER");
        if (processorInfo != null) {
            System.out.println("Processor: " + processorInfo);
        } else {
            System.out.println("Processor information not available.");
        }*/


        //Verificarea frecventelor
        //SubscriptionGenerator.printFieldFrequencies(subscriptions);
    }
}
