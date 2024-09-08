package com.relaunchher.spring_boot_with_react.dao.model;

public enum JobLevel {
    ENTRY_LEVEL("Entry Level"),
    MID_LEVEL("Mid Level"),
    SENIOR("Senior"),
    MANAGER("Manager"),
    EXECUTIVE("Executive");

    private final String displayName;

    JobLevel(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
