package com.sabeel.demo_sebeel.entity;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class ManagementData {

    private LocalDate actualAttendanceDate;

    private String  specifiedTime;

    private String instituteFees;

    private String studentGroupId;

    private String receiptNumber;

    private LocalDate submissionDate;

    private String receiver;

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

