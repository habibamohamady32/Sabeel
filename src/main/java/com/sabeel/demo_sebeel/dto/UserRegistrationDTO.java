package com.sabeel.demo_sebeel.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class UserRegistrationDTO {

    @NotBlank
    private String studentName;

    @NotNull
    @Min(1)
    private Integer age;

    @Pattern(regexp = "\\d{14}")
    private String nationalId;

    @NotBlank
    private String phoneNumber;

    private String placeOfWork;

    private String job;

    private String address;

    private String levelOfStudy;

    // === AcceptanceData ===

    private String lastSavingAmount;

    private String level;

    private String examineTeacherName;

    // === ManagementData ===

    private LocalDate actualAttendanceDate;

    private String specifiedTime;

    private String instituteFees;
    private String studentGroupId;

    private String receiptNumber;

    private LocalDate submissionDate;

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
