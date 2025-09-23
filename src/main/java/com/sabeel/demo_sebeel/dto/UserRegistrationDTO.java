package com.sabeel.demo_sebeel.dto;

import com.sabeel.demo_sebeel.Enum.UserStatus;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserRegistrationDTO {

    @NotBlank(message = "Student name is required")
    private String studentName;

    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age must be at least 1")
    private Integer age;

    @NotBlank(message = "National ID is required")
    @Pattern(regexp = "\\d{14}", message = "National ID must be 14 digits")
    private String nationalId;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^01[0-9]{9}$", message = "Phone number must be a valid Egyptian mobile number")
    private String phoneNumber;

    @Size(max = 100, message = "Place of work must be at most 100 characters")
    private String placeOfWork;

    @Size(max = 100, message = "Job title must be at most 100 characters")
    private String job;

    @Size(max = 255, message = "Address must be at most 255 characters")
    private String address;

    @Size(max = 100, message = "Level of study must be at most 100 characters")
    @NotBlank(message = "Level of study is required")
    private String levelOfStudy;

    private UserStatus status;

    // === AcceptanceData ===

    @NotBlank(message = "Previous Saving Amount is required")
    private String lastSavingAmount;

    @Size(max = 50, message = "Level must be at most 50 characters")
    private String level;

    @Size(max = 100, message = "Teacher name must be at most 100 characters")
    @NotBlank(message = "Teacher name is required")
    private String examineTeacherName;

    // === ManagementData ===

    @Future(message = "Attendance date must be in the future")
    @NotNull(message = "Attendance Date is required")
    private LocalDate actualAttendanceDate;

    @Size(max = 50, message = "Specified time must be at most 50 characters")
    @NotBlank(message = "Specified time is required")
    private String specifiedTime;

    @Pattern(regexp = "^\\d+(\\.\\d{1,2})?$", message = "Institute fees must be a number")
    @NotBlank(message = "Fees is required")
    private String instituteFees;

    @NotBlank(message = "Student group ID is required")
    private String studentGroupId;

    @Size(max = 50, message = "Receipt number must be at most 50 characters")
    private String receiptNumber;

    @FutureOrPresent(message = "Submission date must be in the Future")
    @NotNull(message = "Submission date is required")
    private LocalDate submissionDate;

    @Size(max = 100, message = "Receiver name must be at most 100 characters")
    @NotBlank(message = "Receiver name is required")
    private String receiver;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevelOfStudy() {
        return levelOfStudy;
    }

    public void setLevelOfStudy(String levelOfStudy) {
        this.levelOfStudy = levelOfStudy;
    }

    public String getLastSavingAmount() {
        return lastSavingAmount;
    }

    public void setLastSavingAmount(String lastSavingAmount) {
        this.lastSavingAmount = lastSavingAmount;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getExamineTeacherName() {
        return examineTeacherName;
    }

    public void setExamineTeacherName(String examineTeacherName) {
        this.examineTeacherName = examineTeacherName;
    }

    public LocalDate getActualAttendanceDate() {
        return actualAttendanceDate;
    }

    public void setActualAttendanceDate(LocalDate actualAttendanceDate) {
        this.actualAttendanceDate = actualAttendanceDate;
    }

    public String getSpecifiedTime() {
        return specifiedTime;
    }

    public void setSpecifiedTime(String specifiedTime) {
        this.specifiedTime = specifiedTime;
    }

    public String getInstituteFees() {
        return instituteFees;
    }

    public void setInstituteFees(String instituteFees) {
        this.instituteFees = instituteFees;
    }

    public String getStudentGroupId() {
        return studentGroupId;
    }

    public void setStudentGroupId(String studentGroupId) {
        this.studentGroupId = studentGroupId;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
