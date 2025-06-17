package com.sabeel.demo_sebeel.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class AcceptanceData {

    private String lastSavingAmount;

    private String level;

    private String examineTeacherName;

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
}
