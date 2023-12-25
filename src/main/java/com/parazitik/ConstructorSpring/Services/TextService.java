package com.parazitik.ConstructorSpring.Services;

import com.parazitik.ConstructorSpring.Entities.BotEntity;
import com.parazitik.ConstructorSpring.Entities.CommandEntity;
import com.parazitik.ConstructorSpring.Entities.TextEntity;
import com.parazitik.ConstructorSpring.Repositories.BotRepo;
import com.parazitik.ConstructorSpring.Repositories.TextRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TextService {

    @Autowired
    private TextRepo textRepo;

    @Autowired
    private BotRepo botRepo;

    public ResponseEntity<TextEntity> addTextService(String botId, TextEntity text) {
        BotEntity bot = botRepo.findBotEntitiesByIdUsername(botId);
        TextEntity test = textRepo.findTextEntitiesByNameAndBotIdUsername(text.getName(), bot.getIdUsername());

        if (test != null){
            return ResponseEntity.notFound().build();
        }

        System.out.println(">> ADD TEXT");
        text.setBot(bot);

        textRepo.save(text);

        return ResponseEntity.ok(text);
    }

    public ResponseEntity<TextEntity> getTextService(String botId, String name) {
        TextEntity text = textRepo.findTextEntitiesByNameAndBotIdUsername(name, botId);

        if (text == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(text);
    }

    public ResponseEntity<String> updateCurrentTextService(String botId, String textName, String keyboard){
        TextEntity text = textRepo.findTextEntitiesByNameAndBotIdUsername(textName, botId);

        text.setKeyboard(keyboard);

        textRepo.save(text);

        return ResponseEntity.ok(">> keyboard added");
    }

    public ResponseEntity<List<String>> getAllTextService(String BotId){
        List<String> text = new ArrayList<>();
        Iterable<TextEntity> entities = textRepo.findAllByBot_IdUsername(BotId);
        for (TextEntity entity : entities) {
            text.add(entity.getName());
        }
        return ResponseEntity.ok(text);

    }

    public ResponseEntity<String> updateTextService(String botId, TextEntity text, String textName){
        TextEntity newText = textRepo.findTextEntitiesByNameAndBotIdUsername(textName, botId);

        System.out.println(textName);

        if(text.getName() != null){
            newText.setName(text.getName());
        }else{
            newText.setImage(text.getImage());
            newText.setCaption(text.getCaption());
            newText.setText(text.getText());
            newText.setType(text.getType());
        }

        textRepo.save(newText);

        return ResponseEntity.ok("ok");
    }

    public ResponseEntity<TextEntity> deleteCurrentTextService(String textName, String botId){
        TextEntity text = textRepo.findTextEntitiesByNameAndBotIdUsername(textName, botId);

        if (text == null){
            return ResponseEntity.notFound().build();
        }

        textRepo.delete(text);

        return ResponseEntity.ok().build();
    }
}
