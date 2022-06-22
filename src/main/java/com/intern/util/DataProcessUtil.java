package com.intern.util;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DataProcessUtil {
    private DataProcessUtil() {
    }

    public static void startSearch(Map<String, HashSet<Integer>> indexMap, List<String> listOfPeople) {
        System.out.println("Select a matching strategy (ALL, ANY, NONE):");
        String matchingStrategy = Input.menuInput.nextLine().toUpperCase().trim();
        while (!Strategy.searchStrategyStore.containsKey(matchingStrategy)) {
            System.out.println("Please, select a correct matching strategy:");
            matchingStrategy = Input.menuInput.nextLine().toUpperCase().trim();
        }
        System.out.println("Enter a name or email to search all suitable people:");
        String searchRequest = Input.menuInput.nextLine().toLowerCase().trim();
        Set<String> searchResult = Strategy.searchStrategyStore.get(matchingStrategy)
                .executeSearch(indexMap, listOfPeople, searchRequest);
        outResult(searchResult);
    }

    public static void printAllPeople(List<String> listOfPeople) {
        System.out.println("=== List of people ===");
        listOfPeople.forEach(System.out::println);
    }

    private static void outResult(Set<String> searchResult) {
        if (!searchResult.isEmpty()) {
            System.out.println("Found people:");
            searchResult.forEach(System.out::println);
        } else {
            System.out.println("No matching people found.");
        }
    }
}
