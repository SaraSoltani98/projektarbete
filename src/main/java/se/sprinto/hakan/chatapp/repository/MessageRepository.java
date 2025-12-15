package se.sprinto.hakan.chatapp.repository;



import se.sprinto.hakan.chatapp.model.Message;
import se.sprinto.hakan.chatapp.model.User;
import java.util.List;


public interface MessageRepository {
    Message save(Message message);
    List<Message> findByUserId(Long userId);
}


