package com.parazitik.ConstructorSpring.Controllers;

import com.parazitik.ConstructorSpring.Entities.BotEntity;
import com.parazitik.ConstructorSpring.Models.BotModel;
import com.parazitik.ConstructorSpring.Repositories.BotRepo;
import com.parazitik.ConstructorSpring.Services.BotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bot")
public class BotController {

    @Autowired
    private BotService botService;

    @Autowired
    private BotRepo botRepo;

    @PostMapping
    private ResponseEntity<String> addBot(@RequestBody BotEntity bot) {
        botService.registration(bot);

        return ResponseEntity.ok("Бот добавлен!");
    }

    @DeleteMapping("/delete/{username}")
    private void deleteBot(@PathVariable String username) {
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(username);
        botRepo.delete(bot);
    }

    @GetMapping
    private BotModel getBotByUsername(@RequestParam String botUsername) {

        return botService.getBotByUsername(botUsername);
    }

    @GetMapping("/main/{BotId}")
    private String getMainKeyboard(@PathVariable String BotId) {
        return botService.getMainKeyboardService(BotId);
    }

    @GetMapping("/updates")
    private List<String> getUpdatedUsernames() {
        return botService.getAllBotsService();
    }

    @GetMapping("/funcs/{BotId}")
    private List<Boolean> getFunctions(@PathVariable String BotId) {
        return botService.getFunctionsService(BotId);
    }

    @PutMapping("/keyboard/{BotId}")
    private ResponseEntity<String> updateCurrentMainKeyboard(@PathVariable String BotId,
                                                             @RequestBody String keyboard) {

        return botService.updateCurrentMainKeyboardService(BotId, keyboard);
    }

    @PutMapping("/chatgpt/{BotId}")
    private void changeChatGPT(@PathVariable String BotId) {
        botService.changeChatGPTService(BotId);
    }

    @PutMapping("/chattoken/{BotId}/{token}")
    private void addChatToken(@PathVariable String BotId, @PathVariable String token) {
        botService.addChatTokenService(BotId, token);
    }

    @GetMapping("/chattoken/{BotId}")
    private String getChatToken(@PathVariable String BotId) {
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(BotId);

        return bot.getChatgptToken();
    }

    @PutMapping("/ruz/{BotId}")
    private void changeRuz(@PathVariable String BotId) {
        botService.changeRUZService(BotId);
    }
}
