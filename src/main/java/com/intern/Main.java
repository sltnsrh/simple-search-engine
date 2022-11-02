package com.intern;

import com.intern.menu.Menu;
import com.intern.util.DataFormerUtil;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    static final int TYPE_INDEX = 0;
    static final int NAME_INDEX = 1;
    static final String DIRECTORY_PATH = "src/main/resources/";
    static String fileNameForSearch;
    static List<String> listOfPeople;
    static Map<String, HashSet<Integer>> indexMap;

    public static void main(String[] args) {
        fileNameForSearch = DataFormerUtil.getFileName(args[TYPE_INDEX], args[NAME_INDEX]);
        listOfPeople = DataFormerUtil.createListFromFile(DIRECTORY_PATH + fileNameForSearch);
        indexMap = DataFormerUtil.createIndexMap(listOfPeople);
        Menu menu = new Menu(indexMap, listOfPeople);
        menu.startMenu();
    }
}
