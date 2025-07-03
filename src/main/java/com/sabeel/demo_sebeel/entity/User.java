package com.sabeel.demo_sebeel.entity;
import com.sabeel.demo_sebeel.Enum.UserStatus;
import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;

    private Integer age;

    private String nationalId;

    private String phoneNumber;

    private String placeOfWork;

    private String job;

    private String address;

    private String levelOfStudy;

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    private UserStatus status;

    @Embedded
    private AcceptanceData acceptance;

    @Embedded
    private ManagementData management;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
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

    public AcceptanceData getAcceptance() {
        return acceptance;
    }

    public void setAcceptance(AcceptanceData acceptance) {
        this.acceptance = acceptance;
    }

    public ManagementData getManagement() {
        return management;
    }

    public void setManagement(ManagementData management) {
        this.management = management;
    }
}
