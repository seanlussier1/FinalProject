package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter

public class Address {
    int streetNo;
    String street;
    String city;
    String province;
    String postalCode;
    String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode;
            this.country = country;
        } else {
            this.streetNo = Integer.parseInt(null);
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    /**
     * checks if a postal code is valid or not.
     * if the length is 6, then it must follow the format: CDCDCD.
     * ex: A1A1A1
     * if the length is 7, then it must follow the format: CDC DCD.
     * ex: A1A 1A1
     * where C is a character, while D is a digit. Case-insensitive;
     * @param postalCode the input postal code
     * @return true if the postal code is valid and false if the postal code is invalid
     */
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
