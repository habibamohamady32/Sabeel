package com.sabeel.demo_sebeel.entity;
import com.sabeel.demo_sebeel.Enum.UserStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "national_id", unique = true, nullable = false)
    private String nationalId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "place_of_work")
    private String placeOfWork;

    @Column(name = "job")
    private String job;

    @Column(name = "address")
    private String address;

    @Column(name = "level_of_study")
    private String levelOfStudy;

    @Enumerated(EnumType.ORDINAL) // 0 1 2
    @Column(name = "status", nullable = false)
    private UserStatus status;

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Embedded
    private AcceptanceData acceptance;

    @Embedded
    private ManagementData management;

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

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
