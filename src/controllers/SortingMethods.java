package controllers;

import models.Person;

public class SortingMethods {
    public void sortByNameWithBubble(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[i].getName().compareToIgnoreCase(persons[j + 1].getName()) > 0) {
                    Person aux
                }
            }
        }
    }


}
