package com.intern.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class DataFormerUtil {
    private DataFormerUtil(){
    }

    public static List<String> createListFromFile(String fileForSearch) {
        List<String> listOfPersons = new ArrayList<>();
        File file = new File(fileForSearch);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                listOfPersons.add(scanner.nextLine());
            }
            return listOfPersons;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Something went wrong with your file: "
                    + file.getAbsolutePath(), e);
        }
    }

    public static Map<String, HashSet<Integer>> createIndexMap(List<String> listOfPeople) {
        Map<String, HashSet<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < listOfPeople.size(); i++) {
            String[] wordsFromLine = listOfPeople.get(i).toLowerCase().split("\\s+");
            for (String word: wordsFromLine) {
                if (!indexMap.containsKey(word)) {
                    indexMap.put(word, new HashSet<>(Arrays.asList(i)));
                } else {
                    indexMap.get(word).add(i);
                }
            }
        }
        return indexMap;
    }
}
