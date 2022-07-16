package Menu;

import Models.User;
import Operations.UserOperations;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    int option;
    User user = new User();
    UserOperations userOperations = new UserOperations();
    List<User> userList = new ArrayList<>();

    public void showMenu(){
        while(!exit){
            System.out.println(" ___________..........___________" +
                    "\n" + "Bici - U " +
                    "\n" + "1. Register user " +
                    "\n" + "2. Show patients" +
                    "\n" + "3. Appointments" +
                    "\n" + "4. Billing" +
                    "\n" + "5. Medicine Stock" +
                    "\n" + "6. Exit" +
                    "");
            try{
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        user = userOperations.addUser();
                        userList.add(user);
                        break;
                    case 2:
                        System.out.println("2");
                        break;
                    case 3:
                        System.out.println("3");
                        break;
                    case 4:
                        System.out.println("4");
                        break;
                    case 5:
                        System.out.println("5");
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Please select a correct answer");
                }
            }catch (InputMismatchException exception){
                System.out.println("\nYou must enter a number");
                scanner.next();
            }
        }
    }
}

