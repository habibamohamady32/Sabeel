package com.sabeel.demo_sebeel.dto;

import com.sabeel.demo_sebeel.Enum.UserStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Schema(description = "Data Transfer Object for User details")
public class UserDto {

    @Schema(description = "User ID", example = "1")
    private long id;

    @Schema(description = "Full name of the student", example = "Ahmed Ali")
    private String studentName;

    @Schema(description = "Age of the student", example = "21")
    @Min(value = 1, message = "Age must be at least 1")
    private Integer age;

    @Schema(description = "National ID number", example = "29805123456789")
    @Pattern(regexp = "\\d{14}", message = "National ID must be 14 digits")
    private String nationalId;

    @Schema(description = "Phone number", example = "01012345678")
    @Pattern(regexp = "^01[0-9]{9}$", message = "Phone number must be a valid Egyptian mobile number")
    private String phoneNumber;

    @Schema(description = "Place of work", example = "ABC Company")
    @Size(max = 100, message = "Place of work must be at most 100 characters")
    private String placeOfWork;

    @Schema(description = "Job title", example = "Accountant")
    @Size(max = 100, message = "Job title must be at most 100 characters")

    private String job;

    @Schema(description = "Home address", example = "Cairo, Nasr City")
    @Size(max = 255, message = "Address must be at most 255 characters")
    private String address;

    @Schema(description = "Level of study", example = "Level 1")
    @Size(max = 100, message = "Level of study must be at most 100 characters")
    private String levelOfStudy;

    @Schema(description = "Last saving amount", example = "500 EGP")
    private String lastSavingAmount;

    @Schema(description = "Memorization level", example = "10 Parts")
    @Size(max = 50, message = "Level must be at most 50 characters")
    private String level;

    @Schema(description = "Name of the examining teacher", example = "Sheikh Mahmoud")
    @Size(max = 100, message = "Teacher name must be at most 100 characters")
    private String examineTeacherName;

    @Schema(description = "Actual date of attendance", example = "2024-06-01")
    @Future(message = "Attendance date must be in the future")
    private LocalDate actualAttendanceDate;

    @Schema(description = "Specified time for attendance", example = "10:00 AM")
    @Size(max = 50, message = "Specified time must be at most 50 characters")
    private String specifiedTime;

    @Schema(description = "Institute fees", example = "250 EGP")
    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "Institute fees must be a number")
    private String instituteFees;

    @Schema(description = "Student group identifier", example = "Group A")
    @NotBlank(message = "Student group ID is required")
    private String studentGroupId;

    @Schema(description = "Receipt number", example = "RCPT20240601")
    @Size(max = 50, message = "Receipt number must be at most 50 characters")
    private String receiptNumber;

    @Schema(description = "Date the form was submitted", example = "2024-06-03")
    @Future(message = "Submission date must be in the Future")
    private LocalDate submissionDate;

    @Schema(description = "Name of the receiver", example = "Mohamed Youssef")
    @Size(max = 100, message = "Receiver name must be at most 100 characters")
    private String receiver;

    @Schema(description = "User status", example = "ACTIVE")
    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
