package ui;

import models.user.User;
import operations.BiciOperations;
import operations.UserOperations;

import java.util.InputMismatchException;
import java.util.Scanner;

import static operations.UserOperations.userList;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;
    static int option;
    static User user = new User();
    static UserOperations userOperations = new UserOperations();
    static BiciOperations biciOperations = new BiciOperations();

    public static void showMenu(){
        while(!exit){
            System.out.println("\n" + "........................." +
                    "\n" + "Bici - U " +
                    "\n" + "1. Register user " +
                    "\n" + "2. Borrow Bicycle" +
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
                        biciOperations.borrowBici();
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

