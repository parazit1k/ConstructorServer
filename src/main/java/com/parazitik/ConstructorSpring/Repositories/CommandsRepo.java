package com.parazitik.ConstructorSpring.Repositories;

import com.parazitik.ConstructorSpring.Entities.CommandEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommandsRepo extends CrudRepository<CommandEntity, Long> {
    CommandEntity findCommandEntitiesByNameAndBotIdUsername(String name, String idUsername);
    Iterable<CommandEntity> findAllByBot_IdUsername(String idUsername);
}
