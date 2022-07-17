package operations;

import models.user.student.Student;
import models.user.User;

import java.util.*;

public class UserOperations implements models.user.gateway.UserGateway {

    private static final String STUDENT = "Student";
    private static final String PROFESSOR = "Professor";
    public static  final List<User> userList = new ArrayList<>();

    @Override
    public User addUser() {
        Scanner scanner = new Scanner(System.in);
        String userType = validateUser();
        return (userType.equals(STUDENT)) ? getStudent(scanner) : getProfessor(scanner);
    }

    private User getStudent(Scanner scanner) {
        String id;
        String name;
        int age;
        System.out.println("What is the id of the student");
        id = buildingId(scanner);
        System.out.println("What is the name of the student");
        name = buildingName(scanner);
        System.out.println("What is the age of the student");
        age = buildingAge(scanner);
        User user = Student.builder()
                .id("S-" + id)
                .name(name)
                .age(age)
                .build();
        registerCompleted(user);
        return user;
    }

    private void registerCompleted(User user) {
        System.out.println("¡Register completed!");
        System.out.println(" ");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
    }

    private User getProfessor(Scanner scanner) {
        String id;
        String name;
        int age;
        System.out.println("What is the id of the professor");
        id = buildingId(scanner);
        System.out.println("What is the name of the professor");
        name = buildingName(scanner);
        System.out.println("What is the age of the professor");
        age = buildingAge(scanner);
        User user = Student.builder()
                .id("P-" + id)
                .name(name)
                .age(age)
                .build();
        registerCompleted(user);
        return user;
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

    private String buildingName(Scanner scanner) {
        String name;
        System.out.println("Introduce the name");
        name = scanner.nextLine();
        return name;
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
        return validateAge(number, scanner);
    }

    int validateAge(int age, Scanner scanner){
        return age<18 ? validateMinorAge(scanner) : age;
    }

    private int validateMinorAge(Scanner scanner) {
        int age;
        do {
            System.out.println("You are not an adult!");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number!");
                scanner.next();
            }
            age = scanner.nextInt();
        } while (age < 18);
        return age;
    }

    private String buildingId(Scanner scanner) {
        String id;
        id = scanner.nextLine();
        return id;
    }

}
