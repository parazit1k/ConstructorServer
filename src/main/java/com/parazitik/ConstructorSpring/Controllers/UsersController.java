package com.parazitik.ConstructorSpring.Controllers;

import com.parazitik.ConstructorSpring.Entities.UsersEntity;
import com.parazitik.ConstructorSpring.Services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    private void addUser(@RequestBody UsersEntity user,
                         @RequestParam String BotUsername) {
        usersService.addUser(user, BotUsername);
    }

    @GetMapping("/allusers/{botUsername}")
    private List<Long> getAllUsers(@PathVariable String botUsername) {

        return usersService.getStateService(botUsername);
    }

    @GetMapping("/admin/{botUsername}")
    private boolean isAdmin(@RequestParam Long UserId, @PathVariable String botUsername) {

        return usersService.isAdminService(UserId, botUsername);
    }

    @GetMapping("/admins/{BotId}")
    private Long getAllAdmins(@PathVariable String BotId){
        return usersService.getAllAdminsState(BotId);
    }

    @PutMapping("/setstate/{botUsername}")
    private void setState(@PathVariable String botUsername, @RequestParam Long UserId, @RequestParam int state) {
        usersService.setState(botUsername, UserId, state);
    }
}
