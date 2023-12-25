package com.parazitik.ConstructorSpring.Services;

import com.parazitik.ConstructorSpring.Entities.BotEntity;
import com.parazitik.ConstructorSpring.Entities.UsersEntity;
import com.parazitik.ConstructorSpring.Repositories.BotRepo;
import com.parazitik.ConstructorSpring.Repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {

    @Autowired
    private BotRepo botRepo;

    @Autowired
    private UsersRepo usersRepo;

    public void addUser(UsersEntity usersEntity, String botUsername){
        UsersEntity test = usersRepo.findUsersEntitiesByFromUserIdAndBot_IdUsername(usersEntity.getFromUserId(), botUsername);
        if (test != null){
            return;
        }
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(botUsername);

        usersEntity.setBot(bot);

        usersRepo.save(usersEntity);
    }

    public List<Long> getStateService(String botUsername){

        List<Long> result = new ArrayList<>();

        Iterable<UsersEntity> info = usersRepo.findAllUsersEntitiesByBot_IdUsername(botUsername);

        System.out.println(info);

        for(UsersEntity i: info){
            result.add(i.getFromUserId());
        }


        return result;
    }

    public boolean isAdminService(Long userId, String botUsername){
        return usersRepo.findUsersEntitiesByFromUserIdAndBot_IdUsername(userId, botUsername).isAdmin();
    }

    public void setState(String botUsername, Long userId, int state){

        UsersEntity user = usersRepo.findUsersEntitiesByFromUserIdAndBot_IdUsername(userId, botUsername);
        user.setState(state);

        usersRepo.save(user);

    }

    public Long getAllAdminsState(String botId){
        UsersEntity toSend = usersRepo.getUsersEntitiesByBot_IdUsernameAndAdminTrue(botId);

        return toSend.getFromUserId();
    }

}
