package ru.netology.data;


import com.github.javafaker.Faker;

import lombok.Value;

import java.util.Locale;

public class dataHelper {
    private static final Faker faker = new Faker(new Locale("en"));

    private dataHelper() {

    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {

        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }


    public static dataHelper.VerificationCode getVerificationCode() {

       return new dataHelper.VerificationCode(faker.numerify("######"));
   }
}
