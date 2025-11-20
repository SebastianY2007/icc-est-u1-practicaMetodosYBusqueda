package controllers;

import models.Person;

public class SortingMethods {
    public void sortByNameWithBubble(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[j] == null || persons[j + 1] == null) {
                    continue; 
                }
                
                if (persons[j].getName().compareToIgnoreCase(persons[j + 1].getName()) > 0) {
                    Person aux = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = aux;
                }
            }
        }
    }

    public void sortByNameBySelectionDes(Person[] persons) {
        for (int i = 0; i < persons.length; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < persons.length; j++) {
                if (persons[j].getName().compareToIgnoreCase(persons[indiceMenor].getName()) > 0) {
                    indiceMenor = j;
                }
            }
            
            if (i != indiceMenor) {
                Person aux = persons[indiceMenor];
                persons[indiceMenor] = persons[i];
                persons[i] = aux;
            }
        }
    }

    public void sortByAgeWithInsertion(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            int j = i - 1;
            Person aux = persons[i];

            while (j >= 0 && persons[j].getAge() > aux.getAge()) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = aux;
        }
    }

    public void sortByNameWithInsertion(Person[] persons) {
        for (int i = 1; i < persons.length; i++) {
            int j = i - 1;
            Person aux = persons[i];

            while (j >= 0 && persons[j].getName().compareToIgnoreCase(aux.getName()) > 0) {
                persons[j + 1] = persons[j];
                j--;
            }
            persons[j + 1] = aux;
        }
    }
}
