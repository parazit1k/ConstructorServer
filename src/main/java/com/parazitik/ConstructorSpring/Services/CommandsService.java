package com.parazitik.ConstructorSpring.Services;

import com.parazitik.ConstructorSpring.Entities.BotEntity;
import com.parazitik.ConstructorSpring.Entities.CommandEntity;
import com.parazitik.ConstructorSpring.Repositories.BotRepo;
import com.parazitik.ConstructorSpring.Repositories.CommandsRepo;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandsService {

    @Autowired
    private CommandsRepo commandsRepo;

    @Autowired
    private BotRepo botRepo;

    public void addCommand(CommandEntity commandEntity, String botUsername){
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(botUsername);
        commandEntity.setBot(bot);
        commandsRepo.save(commandEntity);
    }

    public ResponseEntity<CommandEntity> getCurrentCommandService(String name, String id){

        CommandEntity command = commandsRepo.findCommandEntitiesByNameAndBotIdUsername(name, id);

        if (command == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(command);
    }

    public ResponseEntity<CommandEntity> deleteCurrentCommandService(String name, String id){
        CommandEntity command = commandsRepo.findCommandEntitiesByNameAndBotIdUsername(name, id);

        if (command == null){
            return ResponseEntity.notFound().build();
        }

        commandsRepo.delete(command);

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<String> updateCurrentCommandService(String botId, String commandName, String keyboard){

        CommandEntity command = commandsRepo.findCommandEntitiesByNameAndBotIdUsername(commandName, botId);

        command.setKeyboard(keyboard);

        commandsRepo.save(command);

        return ResponseEntity.ok(">> keyboard updated");

    }

    public ResponseEntity<List<String>> getAllCommandsService(String idUsername){
        List<String> commands = new ArrayList<>();
        Iterable<CommandEntity> entities = commandsRepo.findAllByBot_IdUsername(idUsername);
        for (CommandEntity entity : entities) {
            commands.add(entity.getName());
        }
        return ResponseEntity.ok(commands);
    }

    public ResponseEntity<String> updateCommandService(String botId, CommandEntity commandEntity, String commandName){
        CommandEntity command = commandsRepo.findCommandEntitiesByNameAndBotIdUsername(commandName, botId);

        if(commandEntity.getName() != null){
            command.setName(commandEntity.getName());
        }else{
            command.setImage(commandEntity.getImage());
            command.setCaption(commandEntity.getCaption());
            command.setText(commandEntity.getText());
            command.setType(commandEntity.getType());
        }

        commandsRepo.save(command);

        return ResponseEntity.ok("ok");
    }
}
