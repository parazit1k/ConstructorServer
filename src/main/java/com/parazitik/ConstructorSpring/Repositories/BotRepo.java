package com.parazitik.ConstructorSpring.Repositories;

import com.parazitik.ConstructorSpring.Entities.BotEntity;
import org.springframework.data.repository.CrudRepository;

public interface BotRepo extends CrudRepository<BotEntity, String> {
    BotEntity findBotEntitiesByIdUsername(String username);
}
