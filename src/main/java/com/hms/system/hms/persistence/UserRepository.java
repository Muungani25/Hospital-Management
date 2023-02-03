package com.hms.system.hms.persistence;


import com.hms.system.hms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
