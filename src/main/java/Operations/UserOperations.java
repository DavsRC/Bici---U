package Operations;

import Models.Student;
import Models.User;

import java.util.*;

public class UserOperations implements IUserOperations {

    private static final String STUDENT = "Student";
    private static final String PROFESSOR = "Professor";
    private final List<User> userList = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        try {
            boolean size = userList.size() != 0;

            return (size) ? userList : null;

        } catch (Exception exception) {
            System.out.println("An error was occurred, caused by: " + exception.getMessage());
        }
        return null;
    }

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
        try {
            do {
                System.out.println("Please select");
                System.out.println("1. Student");
                System.out.println("2. Professor");
                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                } else {
                    System.out.println("Please, select a correct number");
                    scanner.next();
                }
            } while (option != 1 && option != 2);
        } catch (InputMismatchException exception) {
            System.out.println("please introduce a number");
            scanner.next();
        }
        return validateId(option);
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
        return number;
    }

    private String buildingId(Scanner scanner) {
        String id;
        id = scanner.nextLine();
        return id;
    }

}
