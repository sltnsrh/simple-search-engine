package com.intern.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnySearch implements Searchable {

    @Override
    public Set<String> executeSearch(Map<String, HashSet<Integer>> indexMap, List<String> listOfPeople,
                                     String searchQuery) {
        String[] searchWords = searchQuery.split("\\s+");
        Set<Integer> searchedIndexes = new HashSet<>();
        for (String word: searchWords) {
            if (indexMap.containsKey(word)) {
                searchedIndexes.addAll(indexMap.get(word));
            }
        }
        Set<String> searchResult = new HashSet<>();
        if (!searchedIndexes.isEmpty()) {
            searchedIndexes.forEach(index -> searchResult.add(listOfPeople.get(index)));
            return searchResult;
        }
        return searchResult;
    }
}
