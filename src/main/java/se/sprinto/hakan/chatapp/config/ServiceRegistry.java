package se.sprinto.hakan.chatapp.config;


import org.springframework.stereotype.Component;
import se.sprinto.hakan.chatapp.service.UserService;
import se.sprinto.hakan.chatapp.service.MessageService;

@Component
public class ServiceRegistry {

    public static UserService userService;
    public static MessageService messageService;

    public ServiceRegistry(UserService userService, MessageService messageService) {
        ServiceRegistry.userService = userService;
        ServiceRegistry.messageService = messageService;
    }
}

