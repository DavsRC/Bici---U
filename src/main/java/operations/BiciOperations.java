package operations;

import models.bici.Bici;
import models.bici.gateway.BiciGateway;
import models.ticket.Status;
import models.ticket.Ticket;
import models.ticket.gateway.TicketGateway;
import models.user.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static java.util.Objects.isNull;
import static operations.ReadBicyclesFile.biciList;
import static operations.UserOperations.userList;


public class BiciOperations implements BiciGateway {


    private static final String MOUNTAIN = "Mountain";
    private static final String ROAD = "Road";

    @Override
    public void borrowBici() {
        getUser();
    }

    private void getUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the user id: ");
        String id = scanner.nextLine();
        User user = findUser(id);
        checkUser(user);
    }

    private void getBici() {
        String biciType = getBiciType();
        Bici bici = findBici(biciType);
        checkBici(bici);
    }

    private User findUser(String id) {
        return userList.stream().filter(user1 -> id.equals(user1.getId())).findFirst().orElse(null);
    }

    private void checkUser(User user){
        if (isNull(user)) {
            userNotFound();
        } else {
            userFound(user);
            getBici();
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

    private String getBiciType(){
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

    private Bici findBici(String type) {
        return biciList.stream().filter(bici -> isAvailable(type, bici)).findFirst().orElse(null);
    }

    private boolean isAvailable(String type, Bici bici) {
        return bici.getType().equals(type) && bici.isAvailable();
    }

    private void checkBici(Bici bici){
        if (isNull(bici)) {
            biciNotFound();
        } else {
            biciFound(bici);
            bici.setAvailable(false);
        }
    }

    private void biciNotFound(){
        System.out.println("The is no bicycles available.");
    }

    private void biciFound(Bici bici){
        System.out.println(".......................");
        System.out.println("The Bicycle has been chosen! ");
        System.out.println(" ");
        System.out.println("ID: " + bici.getId());
        System.out.println("Type: " + bici.getType());
        System.out.println("Color: " + bici.getColor());
    }
}
