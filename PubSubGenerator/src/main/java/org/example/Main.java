package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        List<String> publications = PublicationGenerator.generatePublications(Config.TOTAL_PUBLICATIONS);
        PublicationGenerator.writeToFile(publications, "publications.txt");

        List<String> subscriptions = SubscriptionGenerator.generateAllSubscriptions();
        SubscriptionGenerator.writeToFile(subscriptions, "subscriptions.txt");
        long end = System.currentTimeMillis();

        System.out.printf("Generated %d publications and %d subscriptions in %d ms on %d threads %n",
                Config.TOTAL_PUBLICATIONS, Config.TOTAL_SUBSCRIPTIONS, (end - start), Config.NUM_THREADS);

        SubscriptionGenerator.printFieldFrequencies(subscriptions);
    }
}
