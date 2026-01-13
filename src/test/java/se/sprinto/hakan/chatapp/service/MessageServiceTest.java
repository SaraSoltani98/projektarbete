package se.sprinto.hakan.chatapp.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import se.sprinto.hakan.chatapp.model.Message;
import se.sprinto.hakan.chatapp.repository.MessageRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    MessageRepository repo;

    @InjectMocks
    MessageService service;

    @Test
    void save_callsRepo() {
        // ARRANGE
        Message message = new Message();
        message.setText("Hello there?");

        // ACT
        service.save(message);

        // ASSERT
        Mockito.verify(repo).save(message);
    }

    @Test
    void getMessages_containsHelloThere() {
        // ARRANGE
        Long userId = 1L;

        Message message = new Message();
        message.setText("Hello there?");

        Mockito.when(repo.findByUserId(userId))
                .thenReturn(List.of(message));

        // ACT
        List<Message> result = service.getMessages(userId);

        // ASSERT
        Mockito.verify(repo).findByUserId(userId);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Hello there?", result.get(0).getText());
    }

    @Test
    void getMessages_returnsNull_whenRepoReturnsNull() {
        // ARRANGE
        Long userId = 199L;
        Mockito.when(repo.findByUserId(userId))
                .thenReturn((List<Message>) null);

        // ACT
        List<Message> result = service.getMessages(userId);

        // ASSERT
        Mockito.verify(repo).findByUserId(userId);
        assertNull(result, "Om repo returnerar null ska service returnera null");
    }
}
