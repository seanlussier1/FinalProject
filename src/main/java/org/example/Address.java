package org.example;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode

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
        if (postalCode == null || postalCode.isEmpty()) {
            return false;
        }
        String codeLowerCase = postalCode.toLowerCase();
        if (codeLowerCase.length() == 6) {
            for (int i = 0; i < codeLowerCase.length(); i++) {
                char c = codeLowerCase.charAt(i);
                if (i % 2 == 0) {
                    if (c < 'a' || c > 'z') {
                        return false;
                    }
                }
                if (i % 2 == 1) {
                    if (c < '0' || c > '9') {
                        return false;
                    }
                }
            }
            return true;
        }
        if (codeLowerCase.length() == 7) {
            for (int i = 0; i < codeLowerCase.length(); i++) {
                char c = codeLowerCase.charAt(i);
                switch (i) {
                    case 0, 2, 5 -> {
                        if (c < 'a' || c > 'z') {
                            return false;
                        }
                    }
                    case 1, 4, 6 -> {
                        if (c < '0' || c > '9') {
                            return false;
                        }
                    }
                    case 3 -> {
                        if (c != ' ') {
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

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
