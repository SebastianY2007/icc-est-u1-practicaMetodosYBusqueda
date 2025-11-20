import controllers.Controller;
import controllers.SearchMethods;
import controllers.SortingMethods;
import models.Person;
import views.View;

public class App {
    public static void main(String[] args) throws Exception {
        View view = new View();
        SortingMethods sortingMethods = new SortingMethods();
        SearchMethods searchMethods = new SearchMethods();

        Person[] persons = new Person[5];

        Controller controller = new Controller(view, persons, sortingMethods, searchMethods);

        controller.start();
    }
}
