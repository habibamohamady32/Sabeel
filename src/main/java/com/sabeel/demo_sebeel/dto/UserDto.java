package com.sabeel.demo_sebeel.dto;

import com.sabeel.demo_sebeel.Enum.UserStatus;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserDto {
    private long id;
    private String studentName;
    private Integer age;
    private String nationalId;
    private String phoneNumber;
    private String placeOfWork;
    private String job;
    private String address;
    private String levelOfStudy;
    private String lastSavingAmount;
    private String level;
    private String examineTeacherName;
    private LocalDate actualAttendanceDate;
    private String specifiedTime;
    private String instituteFees;
    private String studentGroupId;
    private String receiptNumber;
    private LocalDate submissionDate;
    private String receiver;
    private UserStatus status;
}
