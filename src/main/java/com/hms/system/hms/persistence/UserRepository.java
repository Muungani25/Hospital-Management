package com.hms.system.hms.persistence;


import com.hms.system.hms.domain.ERole;
import com.hms.system.hms.domain.Role;
import com.hms.system.hms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {



    //    List<User> findAllByIsDoctor(Boolean status);
   Optional<User>  findUserByEmail(String email);
}
