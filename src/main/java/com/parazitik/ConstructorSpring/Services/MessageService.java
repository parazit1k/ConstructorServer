package com.parazitik.ConstructorSpring.Services;

import com.parazitik.ConstructorSpring.Entities.MessageEntity;
import com.parazitik.ConstructorSpring.Entities.UsersEntity;
import com.parazitik.ConstructorSpring.Repositories.MessageRepo;
import com.parazitik.ConstructorSpring.Repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UsersRepo usersRepo;

    public void addMessage(Long userId, MessageEntity message, String botID){
        UsersEntity user = usersRepo.findUsersEntitiesByFromUserIdAndBot_IdUsername(userId, botID);
        if (user == null){
            return;
        }
        message.setUser(user);

        messageRepo.save(message);
    }

}
