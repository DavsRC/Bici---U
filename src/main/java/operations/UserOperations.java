package operations;

import models.user.User;
import models.user.gateway.UserGateway;
import models.user.student.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;
import static ui.Menu.showMenu;

public class UserOperations implements UserGateway {

    private static final String STUDENT = "Student";
    private static final String PROFESSOR = "Professor";
    public static final List<User> userList = new ArrayList<>();

    @Override
    public User addUser() {
        Scanner scanner = new Scanner(System.in);
        String userType = validateUser();
        return (userType.equals(STUDENT)) ? getStudent(scanner) : getProfessor(scanner);
    }

    private String validateUser() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        System.out.println("What is the type of user that you will create?");
        do {
            System.out.println("Please select");
            System.out.println("1. Student");
            System.out.println("2. Professor");
            option = validateUserInput(scanner, option);
        } while (option != 1 && option != 2);
        return validateId(option);
    }

    private User getStudent(Scanner scanner) {
        String id;
        String name;
        String surName;
        int age;
        System.out.println("What is the id of the student");
        id = buildingId(scanner);
        getUserId(id);
        System.out.println("What is the name of the student");
        name = buildingName(scanner);
        System.out.println("What is the surname of the student");
        surName = buildingSurName(scanner);
        System.out.println("What is the age of the student");
        age = buildingAge(scanner);
        getUserAge(age);
        User user = Student.builder()
                .id("S-" + id)
                .dni(id)
                .name(name)
                .surName(surName)
                .age(age)
                .hasDebts(false)
                .build();
        registerCompleted(user);
        return user;
    }

    private void getUserAge(int age) {
        if(validateUserAge(age)){
            System.out.println("The age is valid");
        }else {
            System.out.println("You are not an adult. Come back when you are 18 ;)");
            showMenu();
        }
    }

    private void getUserId(String id) {
        if(validateUserId(id)){
            userDoesNotExist();
        }else {
            userExists();
        }
    }

    private void userDoesNotExist() {
        System.out.println("The user doesn't exist yet");
    }

    private void userExists() {
        System.out.println("The user already exists");
        showMenu();
    }

    private User getProfessor(Scanner scanner) {
        String id;
        String name;
        String surName;
        int age;
        System.out.println("What is the id of the professor");
        id = buildingId(scanner);
        getUserId(id);
        System.out.println("What is the name of the professor");
        name = buildingName(scanner);
        System.out.println("What is the surname of the professor");
        surName = buildingSurName(scanner);
        System.out.println("What is the age of the professor");
        age = buildingAge(scanner);
        getUserAge(age);
        User user = Student.builder()
                .id("P-" + id)
                .dni(id)
                .name(name)
                .surName(surName)
                .age(age)
                .hasDebts(false)
                .build();
        registerCompleted(user);
        return user;
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

    private String validateId(int option) {
        return option == 1 ? STUDENT : PROFESSOR;
    }

    private String buildingId(Scanner scanner) {
        String id;
        id = scanner.nextLine();
        return id;
    }


    private boolean validateUserId(String id){
        User user = userList.stream().filter(user1 -> id.equals(user1.getDni())).findFirst().orElse(null);
        return isNull(user);
    }

    private boolean validateUserAge(int age){
        return !(age < 18);
    }

    private String buildingName(Scanner scanner) {
        String name;
        name = scanner.nextLine();
        return name;
    }

    private String buildingSurName(Scanner scanner) {
        String surName;
        surName = scanner.nextLine();
        return surName;
    }

    private int buildingAge(Scanner scanner) {
        int number;
        do {
            System.out.println("Please enter a positive number!");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }

    private void registerCompleted(User user) {
        System.out.println("¡Register completed!");
        System.out.println(" ");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName() + " " + user.getSurName());
        System.out.println("Age: " + user.getAge());
    }
}