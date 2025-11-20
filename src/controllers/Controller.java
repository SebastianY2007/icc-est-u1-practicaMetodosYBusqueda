package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private Person[] persons;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    public Controller(View view, Person[] persons, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.persons = persons;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
    }

    public void start() {
        inputPersons(); 
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1 -> sortPersons();
                case 2 -> searchPerson();
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (option != 3);
    }

    public void inputPersons() {
        System.out.println("--- Ingrese " + persons.length + " personas ---");
        for(int i = 0; i < persons.length; i++) {
            persons[i] = view.inputPerson();
        }
    }

    public void addPersons() {
    }

    public void sortPersons() {
        int option = view.selectSortMethod();
        switch (option) {
            case 1 -> sortingMethods.sortByNameWithBubble(persons);
            case 2 -> sortingMethods.sortByNameBySelectionDes(persons);
            case 3 -> sortingMethods.sortByAgeWithInsertion(persons);
            case 4 -> sortingMethods.sortByNameWithInsertion(persons);
        }
        
        if (option >= 1 && option <= 4) {
            System.out.println("Ordenado exitosamente.");
            view.displayPersons(persons);
        }
    }

    public void searchPerson() {
        int option = view.selectSearchCriterion();
        Person found = null;

        if (option == 1) {
            if (!searchMethods.isSortedByAge(persons)) {
                System.out.println("Error: La lista no está ordenada por edad. Ordénela primero.");
                return;
            }
            int age = view.inputAge();
            found = searchMethods.binarySearchByAge(persons, age);

        } else if (option == 2) { 
            if (!searchMethods.isSortedByName(persons)) {
                System.out.println("Error: La lista no está ordenada por nombre. Ordénela primero.");
                return;
            }
            String name = view.inputName();
            found = searchMethods.binarySearchByName(persons, name);
        }

        if (option != 3) {
            view.displaySearchresult(found);
        }
    }
}