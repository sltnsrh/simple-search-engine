package com.intern.menu;

import static com.intern.util.DataProcessUtil.printAllPeople;
import static com.intern.util.DataProcessUtil.startSearch;
import com.intern.util.Input;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Menu {
    private final Map<String, HashSet<Integer>> indexMap;
    private final List<String> listOfPeople;

    public Menu(Map<String, HashSet<Integer>> indexMap, List<String> listOfPeople) {
        this.indexMap = indexMap;
        this.listOfPeople = listOfPeople;
    }

    public void startMenu() {
        System.out.println(System.lineSeparator()
                + "=== Menu ===" + System.lineSeparator()
                + "1. Find a person" + System.lineSeparator()
                + "2. Print all people" + System.lineSeparator()
                + "0. Exit");
        String userChoice = Input.menuInput.nextLine();
        if (userChoice.chars().allMatch(Character::isDigit) && !userChoice.isBlank()) {
            processMenu(Integer.parseInt(userChoice));
        } else {
            System.out.println("Try to use corresponding digits for menu choice.");
            startMenu();
        }
    }

    private void processMenu(int userMenuChoice) {
        switch (userMenuChoice) {
            case 1:
                startSearch(indexMap, listOfPeople);
                break;
            case 2:
                printAllPeople(listOfPeople);
                break;
            case 0:
                System.out.println("Bye!");
                return;
            default:
                System.out.println("Incorrect option! Try again.");
                break;
        }
        startMenu();
    }
}
