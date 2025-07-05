package com.sabeel.demo_sebeel.service;

import com.sabeel.demo_sebeel.Enum.UserStatus;
import com.sabeel.demo_sebeel.dto.UserRequestDto;
import com.sabeel.demo_sebeel.entity.AcceptanceData;
import com.sabeel.demo_sebeel.entity.ManagementData;
import com.sabeel.demo_sebeel.entity.User;
import com.sabeel.demo_sebeel.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequestDto dto) {
        User user = new User();
        user.setStudentName(dto.getStudentName());
        user.setAge(dto.getAge());
        user.setNationalId(dto.getNationalId());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPlaceOfWork(dto.getPlaceOfWork());
        user.setJob(dto.getJob());
        user.setAddress(dto.getAddress());
        user.setLevelOfStudy(dto.getLevelOfStudy());

        AcceptanceData acceptance = new AcceptanceData();
        acceptance.setLastSavingAmount(dto.getLastSavingAmount());
        acceptance.setLevel(dto.getLevel());
        acceptance.setExamineTeacherName(dto.getExamineTeacherName());

        ManagementData management = new ManagementData();
        management.setActualAttendanceDate(dto.getActualAttendanceDate());
        management.setSpecifiedTime(dto.getSpecifiedTime());
        management.setInstituteFees(dto.getInstituteFees());
        management.setStudentGroupId(dto.getStudentGroupId());
        management.setReceiptNumber(dto.getReceiptNumber());
        management.setSubmissionDate(dto.getSubmissionDate());
        management.setReceiver(dto.getReceiver());

        user.setAcceptance(acceptance);
        user.setManagement(management);

        return userRepository.save(user);
    }

    public Optional<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return Optional.ofNullable(users);
    }

    public Optional<User> getUserById(long id) {
        User user = userRepository.getUserById(id);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByNationalId(String id) {
        User user = userRepository.getUserByNationalId(id);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByName(String name) {
        User user = userRepository.getUserByStudentName(name);
        return Optional.ofNullable(user);
    }

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        User user = userRepository.getUserByPhoneNumber(phoneNumber);
        return Optional.ofNullable(user);
    }

    public Optional<List<User>> findByStatus(UserStatus status) {
        List<User> users = userRepository.getUserByStatus(status);
        return Optional.ofNullable(users);
    }

    public User updateStatus(long id, UserStatus status) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setStatus(status);
            userRepository.save(existingUser);
            return existingUser;
        } else {
            throw new EntityNotFoundException("User does not exist");
        }
    }

    public User updateUser(long id, UserRequestDto userDto) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setStudentName(userDto.getStudentName());
            existingUser.setPhoneNumber(userDto.getPhoneNumber());
            existingUser.setStatus(userDto.getStatus());
            existingUser.setNationalId(userDto.getNationalId());
            existingUser.setAddress(userDto.getAddress());
            existingUser.setLevelOfStudy(userDto.getLevelOfStudy());
            existingUser.setAge(userDto.getAge());
            existingUser.setPlaceOfWork(userDto.getPlaceOfWork());
            existingUser.setJob(userDto.getJob());
            existingUser.getAcceptance().setLastSavingAmount(userDto.getLastSavingAmount());
            existingUser.getAcceptance().setLevel(userDto.getLevel());
            existingUser.getAcceptance().setExamineTeacherName(userDto.getExamineTeacherName());
            existingUser.getManagement().setActualAttendanceDate(userDto.getActualAttendanceDate());
            existingUser.getManagement().setSpecifiedTime(userDto.getSpecifiedTime());
            existingUser.getManagement().setInstituteFees(userDto.getInstituteFees());
            existingUser.getManagement().setStudentGroupId(userDto.getStudentGroupId());
            existingUser.getManagement().setReceiptNumber(userDto.getReceiptNumber());
            existingUser.getManagement().setSubmissionDate(userDto.getSubmissionDate());
            existingUser.getManagement().setReceiver(userDto.getReceiver());

            return userRepository.save(existingUser);
        }
        else {
            throw new EntityNotFoundException("User does not exist");
        }
    }

    public void deleteUser(long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);
    }
}

