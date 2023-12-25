package com.parazitik.ConstructorSpring.Services;

import com.parazitik.ConstructorSpring.Entities.BotEntity;
import com.parazitik.ConstructorSpring.Entities.UsersEntity;
import com.parazitik.ConstructorSpring.Models.BotModel;
import com.parazitik.ConstructorSpring.Repositories.BotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BotService {

    @Autowired
    private BotRepo botRepo;

    public void registration(BotEntity bot){
        BotEntity newbot = new BotEntity();
        newbot.setIdUsername(bot.getIdUsername());
        newbot.setToken(bot.getToken());
        botRepo.save(newbot);
    }

    public BotModel getBotByUsername(String username){
        return BotModel.toModel(botRepo.findBotEntitiesByIdUsername(username));
    }

    public List<String> getAllBotsService(){
        List<String> usernames = new ArrayList<>();
        Iterable<BotEntity> entities = botRepo.findAll();
        for (BotEntity entity : entities) {
            usernames.add(entity.getIdUsername());
        }
        return usernames;
    }

    public ResponseEntity<String> updateCurrentMainKeyboardService(String botId, String keyboard){
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(botId);

        bot.setMainKeyboard(keyboard);

        botRepo.save(bot);

        return ResponseEntity.ok(">> keyboard added");
    }

    public String getMainKeyboardService(String botId){
        return botRepo.findBotEntitiesByIdUsername(botId).getMainKeyboard();
    }

    public List<Boolean> getFunctionsService(String botId){
        List<Boolean> result = new ArrayList<>();

        BotEntity bot = botRepo.findBotEntitiesByIdUsername(botId);

        result.add(bot.isChatgpt());
        result.add(bot.isRuz());

        return result;


    }

    public void changeChatGPTService(String botId){
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(botId);

        bot.setChatgpt(!bot.isChatgpt());

        botRepo.save(bot);
    }

    public void changeRUZService(String botId){
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(botId);

        bot.setRuz(!bot.isRuz());

        botRepo.save(bot);
    }

    public void addChatTokenService(String botId, String token){
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(botId);

        bot.setChatgptToken(token);

        botRepo.save(bot);
    }

}
