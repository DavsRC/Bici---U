package operations;

import models.bici.gateway.BiciGateway;
import models.user.User;

import java.util.Scanner;

import static java.util.Objects.isNull;
import static operations.UserOperations.userList;


public class BiciOperations implements BiciGateway {

    Scanner scanner = new Scanner(System.in);


    @Override
    public void borrowBici() {
        System.out.println("Please enter the user id: ");
        String id = scanner.nextLine();
        User user = findUser(id);
        checkUser(user);
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
