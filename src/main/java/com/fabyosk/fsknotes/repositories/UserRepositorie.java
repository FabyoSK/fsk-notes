package com.fabyosk.fsknotes.repositories;

import com.fabyosk.fsknotes.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositorie extends CrudRepository<User, Long> {
}
