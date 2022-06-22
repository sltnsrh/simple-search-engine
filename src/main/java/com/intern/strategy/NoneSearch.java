package com.intern.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NoneSearch implements Searchable {

    @Override
    public Set<String> executeSearch(Map<String, HashSet<Integer>> indexMap, List<String> listOfPeople,
                                     String searchQuery) {
        String[] searchWords = searchQuery.split("\\s+");
        HashSet<Integer> searchedIndexes = new HashSet<>();
        for (String word: searchWords) {
            if (indexMap.containsKey(word)) {
                searchedIndexes.addAll(indexMap.get(word));
            }
        }
        Set<String> searchResult = new HashSet<>(listOfPeople);
        Set<String> excludedList = new HashSet<>();
        if (!searchedIndexes.isEmpty()) {
            searchedIndexes.forEach(index -> excludedList.add(listOfPeople.get(index)));
            searchResult.removeAll(excludedList);
            return searchResult;
        }
        return searchResult;
    }
}
