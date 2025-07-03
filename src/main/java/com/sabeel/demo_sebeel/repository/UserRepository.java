package com.sabeel.demo_sebeel.repository;

import com.sabeel.demo_sebeel.Enum.UserStatus;
import com.sabeel.demo_sebeel.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);

    User getUserByNationalId(String nationalId);

    User getUserByStudentName(String studentName);

    User getUserByPhoneNumber(String phoneNumber);

    List<User> getUserByStatus(UserStatus status);
}
