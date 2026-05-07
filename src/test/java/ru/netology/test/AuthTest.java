package ru.netology.test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.SQLHelper;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.open;

import static ru.netology.data.SQLHelper.cleanDatabase;

public class AuthTest {


    private DashboardPage dashboardPage;

    @AfterAll
    static void teardown() {
        cleanDatabase();
    }

    @Test
    void shouldSuccessFullLogin() throws SQLException {
        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verificationPageVisiblity();
        var verificationCode = SQLHelper.getVerifacationCode();
        verificationPage.validVerify(String.valueOf(verificationCode));
    }


}
