package Operations;

import Models.User;

import java.util.List;

public interface IUserOperations {

    public List<User> getUsers();
    public User addUser();
}
