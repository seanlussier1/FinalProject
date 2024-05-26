package org.example;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode

public class Department {
    private String departmentId; // 2 Digits has to start with a character D
    private String departmentName;
    static int nextId = 1; // indicates the next ID that will be used

    public Department(String departmentId, String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentId = "D" + String.format("%02d", nextId++);
            this.departmentName = departmentName;

        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    /**
     * checks if a department name is valid or not, a department name should only contain letters or space
     * ex: "hel lo" = true
     * ex: "123hello" = false
     * @param departmentName the input department name
     * @return true if the name is valid and false if the name is not valid
     */
    static boolean validateDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }
        String lowerCaseDep = departmentName.toLowerCase();
        for (int i = 0; i < lowerCaseDep.length(); i++) {
            char c = lowerCaseDep.charAt(i);
            if (c < 'a' || c > 'z') {
                if (c == ' ') {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Department.nextId = nextId;
    }
}
