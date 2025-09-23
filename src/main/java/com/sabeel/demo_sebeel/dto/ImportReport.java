package com.sabeel.demo_sebeel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ImportReport {
    private int successCount;
    private List<RowIssue> errors = new ArrayList<>();
    private List<RowIssue> skipped = new ArrayList<>();

    public void incrementSuccess() { successCount++; }
    public void addError(int rowIndex, String reason) {
        errors.add(new RowIssue(rowIndex, reason));
    }

    public void addSkipped(int rowIndex, String reason) {
        skipped.add(new RowIssue(rowIndex, reason));
    }

    @Data @AllArgsConstructor
    public static class RowIssue {
        private int rowIndex;
        private String reason;
    }
}
