package se.sprinto.hakan.chatapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.chatapp.model.User;
import se.sprinto.hakan.chatapp.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock UserRepository repo;
    @InjectMocks UserService service;

    @Test
    void login_ok() {
        User u = new User("BB", "123");
        Mockito.when(repo.findByUsernameAndPassword("BB", "123")).thenReturn(u);

        assertEquals(u, service.login("BB", "123"));
        Mockito.verify(repo).findByUsernameAndPassword("BB", "123");
    }

    @Test
    void login_userNotFound() {
        Mockito.when(repo.findByUsernameAndPassword("Null", "wrong")).thenReturn(null);

        assertNull(service.login("Null", "wrong"), "Användaren hittades inte");
        Mockito.verify(repo).findByUsernameAndPassword("Null", "wrong");
    }

    @Test
    void register_savesUser() {
        User u = new User("newUser", "pw");
        Mockito.when(repo.save(u)).thenReturn(u);

        assertEquals(u, service.register(u));
        Mockito.verify(repo).save(u);
    }
}
