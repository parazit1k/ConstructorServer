package com.parazitik.ConstructorSpring.Repositories;

import com.parazitik.ConstructorSpring.Entities.TextEntity;
import org.springframework.data.repository.CrudRepository;

public interface TextRepo extends CrudRepository<TextEntity, Long> {

    TextEntity findTextEntitiesByNameAndBotIdUsername(String name, String BotId);
    Iterable<TextEntity> findAllByBot_IdUsername(String BotId);

}
