package com.example.customlistwithnavigation.models;

public class Phone {

    String home, mobile, office;

    public Phone(String home, String mobile, String office) {
        this.home = home;
        this.mobile = mobile;
        this.office = office;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getOffice() {
        return office;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "home='" + home + '\'' +
                ", mobile='" + mobile + '\'' +
                ", office='" + office + '\'' +
                '}';
    }
}


/*

    "phone": {
                    "mobile": "+371 28476758",
                    "home": "+371 28525325",
                    "office": "+371 22988894"
                }
 */