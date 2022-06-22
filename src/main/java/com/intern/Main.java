package com.intern;

import static com.intern.util.DataFormerUtil.createIndexMap;
import static com.intern.util.DataFormerUtil.createListFromFile;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    static final int TYPE_INDEX = 0;
    static final int NAME_INDEX = 1;
    static String fileNameForSearch;
    static List<String> listOfPeople;
    static Map<String, HashSet<Integer>> indexMap;

    public static void main(String[] args) {
        fileNameForSearch = getFileName(args[TYPE_INDEX], args[NAME_INDEX]);
        listOfPeople = createListFromFile("src/main/resources/" + fileNameForSearch);
        indexMap = createIndexMap(listOfPeople);
        Menu menu = new Menu(indexMap, listOfPeople);
        menu.startMenu();
    }

    public static String getFileName(String typeFromArgs, String nameFromArgs) {
        if (typeFromArgs.equals("--data")) {
            fileNameForSearch = nameFromArgs;
            return fileNameForSearch;
        } else {
            throw new RuntimeException("Incorrect input arguments to recognise data file.");
        }
    }
}
