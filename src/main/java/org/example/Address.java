package org.example;

public class Address {
    int streetNo;
    String street;
    String city;
    String province;
    String postalCode;
    String country;

    static boolean isPostalCodeValid(String postalCode) {
        if (postalCode.length() == 6) {
            for (int i = 0; i < postalCode.length(); i++) {
                if (i % 2 == 0) {
                    if (postalCode.charAt(i) < 'A' || postalCode.charAt(i) > 'z') {
                        return false;
                    }
                }
                if (i % 2 == 1) {
                    if (postalCode.charAt(i) < '0' || postalCode.charAt(i) > '9') {
                        return false;
                    }
                }
            }
            return true;
        }
        if (postalCode.length() == 7) {
            for (int i = 0; i < postalCode.length(); i++) {
                switch (i) {
                    case 0, 2, 5 -> {
                        if (postalCode.charAt(i) < 'A' || postalCode.charAt(i) > 'z') {
                            return false;
                        }
                    }
                    case 1, 4, 6 -> {
                        if (postalCode.charAt(i) < '0' || postalCode.charAt(i) > '9') {
                            return false;
                        }
                    }
                    case 3 -> {
                        if (postalCode.charAt(i) != ' ') {
                            return false;
                        }
                    }
                    default -> {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
