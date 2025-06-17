package com.sabeel.demo_sebeel.service;

import com.sabeel.demo_sebeel.dto.UserRegistrationDTO;
import com.sabeel.demo_sebeel.entity.AcceptanceData;
import com.sabeel.demo_sebeel.entity.ManagementData;
import com.sabeel.demo_sebeel.entity.User;
import com.sabeel.demo_sebeel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRegistrationDTO dto) {
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
}

