package views;

import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("---------- MENU ----------");
        System.out.println("1 -> Métodos de ordenamiento");
        System.out.println("2 -> Criterios de búsqueda");
        System.out.println("3 -> Salir");

        System.out.print("Elije una opción: ");

        try {
            int option = scanner.nextInt();
            return option;
        } catch (java.util.InputMismatchException e) {
            scanner.next();
            return -1; 
        }
    }

    public Person inputPerson() {
        Person person = new Person(inputName(), inputAge());
        return person;
    }

    public int selectSortMethod() {
        System.out.println("---------- METODOS DE ORDENAMIENTO ----------");
        System.out.println("1 -> Ordenar por nombre con BubbleSort"); 
        System.out.println("2 -> Ordenar por nombre con SelectionSort Descendente");
        System.out.println("3 -> Ordenar por edad con InsertionSort");
        System.out.println("4 -> Ordenar por nombre con InsertionSort");
        System.out.println("5 -> Salir");
        
        System.out.print("Elije una opción: ");

        try {
            int option = scanner.nextInt();
            return option;
        } catch (java.util.InputMismatchException e) {
            scanner.next();
            return -1;
        }
    }

    public int selectSearchCriterion() {
        System.out.println("1 -> Buscar por edad con Binary");
        System.out.println("2 -> Buscar por nombre con Binary");
        System.out.println("3 -> Salir");

        System.out.print("Elije una opción: ");
        
        try {
            int option = scanner.nextInt();
            return option;
        } catch (java.util.InputMismatchException e) {
            scanner.next();
            return -1;
        }
    }

    public void displayPersons(Person[] persons) {
        System.out.println("---------- LISTA DE PERSONAS ----------");
        if (persons == null || persons.length == 0) {
            System.out.println("La lista está vacía.");
        } else {
            for (Person person : persons) {
                System.out.println(person);
            }
        }
    }

    public void displaySearchresult(Person person) {
        System.out.println("---------- RESULTADO DE BUSQUEDA ----------");
        if (person != null) {
            System.out.println("Persona encontrada: " + person);
        } else {
            System.out.println("No se encontró a la persona con ese criterio.");
        }
    }

    public int inputAge() {
        System.out.print("Ingrese la edad: ");
        int age = scanner.nextInt();
        return age;
    }

    public String inputName() {
        System.out.print("Ingrese el nombre: ");
        String name = scanner.next(); 
        return name;
    }
}
