package com.parazitik.ConstructorSpring.Controllers;

import com.parazitik.ConstructorSpring.Entities.CommandEntity;
import com.parazitik.ConstructorSpring.Entities.TextEntity;
import com.parazitik.ConstructorSpring.Services.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("text")
public class TextController {

    @Autowired
    private TextService textService;

    @PostMapping("/{BotId}")
    private ResponseEntity<TextEntity> addText(@PathVariable String BotId,
                                               @RequestBody TextEntity text) {

        return textService.addTextService(BotId, text);
    }

    @GetMapping("/{BotId}/{textName}")
    private ResponseEntity<TextEntity> getText(@PathVariable String BotId,
                                               @PathVariable String textName) {
        System.out.println(textName);
        return textService.getTextService(BotId, textName);
    }

    @GetMapping("/list/{BotId}")
    private ResponseEntity<List<String>> getListOfAllText(@PathVariable String BotId){
        return textService.getAllTextService(BotId);
    }

    @PutMapping("/keyboard/{BotId}/{TextName}")
    private ResponseEntity<String> updateCurrentText(@PathVariable String BotId,
                                                        @PathVariable String TextName,
                                                        @RequestParam String keyboard){

        return textService.updateCurrentTextService(BotId, TextName, keyboard);
    }

    @PutMapping("/edit/{BotId}/{textName}")
    private ResponseEntity<String> updateText(@PathVariable String BotId,
                                                 @PathVariable String textName,
                                                 @RequestBody TextEntity text){
        return textService.updateTextService(BotId, text, textName);
    }

    @DeleteMapping("/{BotId}/{TextName}")
    private ResponseEntity<TextEntity> deleteCurrentText(@PathVariable String BotId,
                                                               @PathVariable String TextName) {
        return textService.deleteCurrentTextService(TextName, BotId);
    }

}
