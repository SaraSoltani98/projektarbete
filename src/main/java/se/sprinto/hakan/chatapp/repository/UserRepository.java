package se.sprinto.hakan.chatapp.repository;


import se.sprinto.hakan.chatapp.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    User findByUsernameAndPassword(String username, String password);
    List<User> findAll();
}

