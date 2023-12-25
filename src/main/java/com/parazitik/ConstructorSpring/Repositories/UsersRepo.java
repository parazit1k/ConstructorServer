package com.parazitik.ConstructorSpring.Repositories;

import com.parazitik.ConstructorSpring.Entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepo extends CrudRepository<UsersEntity, Long> {
    UsersEntity findUsersEntitiesByFromUserId(Long fromUserId);
    UsersEntity findUsersEntitiesByFromUserIdAndBot_IdUsername(Long fromUserId, String idUsername);
    Iterable<UsersEntity> findAllUsersEntitiesByBot_IdUsername(String idUsername);

    UsersEntity getUsersEntitiesByBot_IdUsernameAndAdminTrue(String botId);
}
