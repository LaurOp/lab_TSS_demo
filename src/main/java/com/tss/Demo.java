package com.tss;

public class Demo {
    public boolean method(String text) {
        if (text.length() < 5 || text.length() > 20) {
            return false;
        }

        for (char c : text.toCharArray()) {
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }

        boolean Lower = true;
        boolean Upper = true;
        for (char c : text.toCharArray()) {
            if (c < 'a' || c > 'z') {
                Lower = false;
            }
            if (c < 'A' || c > 'Z') {
                Upper = false;
            }
        }

        if (Lower) {
            System.out.println("Lowercase");
        }

        if (Upper) {
            System.out.println("Uppercase");
        }

        return true;
    }
}
