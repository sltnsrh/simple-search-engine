package com.intern.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Searchable {
    Set<String> executeSearch(Map<String, HashSet<Integer>> indexMap,
                      List<String> listOfPeople, String searchQuery);
}
