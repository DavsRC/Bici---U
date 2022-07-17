package operations;

import models.bici.gateway.BiciGateway;
import models.user.User;

import java.util.Scanner;

import static java.util.Objects.isNull;
import static operations.UserOperations.userList;


public class BiciOperations implements BiciGateway {


    private static final String MOUNTAIN = "mountain";
    private static final String ROAD = "road";

    @Override
    public void borrowBici() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the user id: ");
        String id = scanner.nextLine();
        User user = findUser(id);
        checkUser(user);
        String biciType = getBiciType();
    }

    public String getBiciType(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        System.out.println("Choose a bicycle mountain or road?");
        do{
            System.out.println("Please select");
            System.out.println("1. Mountain ");
            System.out.println("2. Road");
            option = validateUserInput(scanner, option);
        }while (option != 1 && option != 2);
        return validateBiciType(option);
    }

    private int validateUserInput(Scanner scanner, int option) {
        if (scanner.hasNextInt()) {
            option = scanner.nextInt();
        } else {
            System.out.println("Please, select a correct number");
            scanner.next();
        }
        return option;
    }

    private String validateBiciType(int option) {
        return option == 1 ? MOUNTAIN : ROAD;
    }

    private User findUser(String id) {
        return userList.stream().filter(user1 -> id.equals(user1.getId())).findFirst().orElse(null);
    }

    public void checkUser(User user){
        if (isNull(user)) {
            userNotFound();
        } else {
            userFound(user);
        }
    }

    private void userNotFound(){
        System.out.println("The user hasn't been found");
    }

    private void userFound(User user){
        System.out.println(".......................");
        System.out.println("The user has been found");
        System.out.println(" ");
        System.out.println("ID: " + user.getId());
        System.out.println("ID: " + user.getName());
        System.out.println("ID: " + user.getAge());
    }

}
