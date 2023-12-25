package com.parazitik.ConstructorSpring.Controllers;

import com.parazitik.ConstructorSpring.Entities.CommandEntity;
import com.parazitik.ConstructorSpring.Repositories.CommandsRepo;
import com.parazitik.ConstructorSpring.Services.CommandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("command")
public class CommandsController {

    @Autowired
    private CommandsService commandsService;

    @Autowired
    private CommandsRepo commandsRepo;

    @PostMapping
    private String PostCommand(@RequestBody CommandEntity commandEntity, @RequestParam String botUsername) {
        commandsService.addCommand(commandEntity, botUsername);

        return "added";
    }

    @GetMapping("/{BotId}/{CommandName}")
    private ResponseEntity<CommandEntity> getCurrentCommand(@PathVariable String BotId,
                                                            @PathVariable String CommandName) {

        return commandsService.getCurrentCommandService(CommandName, BotId);
    }

    @GetMapping("/list/{BotId}")
    private ResponseEntity<List<String>> getListOfAllCommands(@PathVariable String BotId){
        return commandsService.getAllCommandsService(BotId);
    }

    @PutMapping("/keyboard/{BotId}/{CommandName}")
    private ResponseEntity<String> updateCurrentCommand(@PathVariable String BotId,
                                                        @PathVariable String CommandName,
                                                        @RequestParam String keyboard){

        return commandsService.updateCurrentCommandService(BotId, CommandName, keyboard);
    }

    @PutMapping("/edit/{BotId}/{commandName}")
    private ResponseEntity<String> updateCommand(@PathVariable String BotId,
                                                 @PathVariable String commandName,
                                                 @RequestBody CommandEntity command){
        return commandsService.updateCommandService(BotId, command, commandName);
    }

    @DeleteMapping("/{BotId}/{CommandName}")
    private ResponseEntity<CommandEntity> deleteCurrentCommand(@PathVariable String BotId,
                                                               @PathVariable String CommandName) {
        return commandsService.deleteCurrentCommandService(CommandName, BotId);
    }
}
