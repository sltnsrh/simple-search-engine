package com.intern.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllSearch implements Searchable {
    private static final int FIRST_WORD_INDEX = 0;

    @Override
    public Set<String> executeSearch(Map<String, HashSet<Integer>> indexMap,
                                     List<String> listOfPeople, String searchQuery) {
        String[] searchWords = searchQuery.split("\\s+");
        HashSet<Integer> searchedIndexes = indexMap.get(searchWords[FIRST_WORD_INDEX]);
        Set<String> resultList = new HashSet<>();
        for (int i = 1; i < searchWords.length; i++) {
            if (searchedIndexes != null && indexMap.containsKey(searchWords[i])) {
                searchedIndexes.retainAll(indexMap.get(searchWords[i]));
            } else {
                return resultList;
            }
        }
        if (searchedIndexes != null) {
            for (Integer index: searchedIndexes) {
                resultList.add(listOfPeople.get(index));
            }
            return resultList;
        }
        return resultList;
    }
}
