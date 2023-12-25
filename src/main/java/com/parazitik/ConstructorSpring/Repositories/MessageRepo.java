package com.parazitik.ConstructorSpring.Repositories;

import com.parazitik.ConstructorSpring.Entities.MessageEntity;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<MessageEntity, Long> {

}
