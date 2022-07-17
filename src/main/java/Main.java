import operations.ReadBicyclesFile;
import ui.Menu;

import static operations.ReadBicyclesFile.biciList;


public class Main {
    public static void main(String[] args) {


        Menu menu = new Menu();
        menu.showMenu();

        System.out.println(biciList);


    }
}
