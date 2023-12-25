package com.parazitik.ConstructorSpring.Controllers;

import com.parazitik.ConstructorSpring.Entities.MessageEntity;
import com.parazitik.ConstructorSpring.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/{botId}")
    private void addMessage(@RequestParam Long userId , @RequestBody MessageEntity message, @PathVariable String botId){
        messageService.addMessage(userId, message, botId);
    }

}
