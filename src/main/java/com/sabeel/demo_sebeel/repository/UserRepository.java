package com.sabeel.demo_sebeel.repository;

import com.sabeel.demo_sebeel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
