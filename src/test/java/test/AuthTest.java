package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data.DataHelper;
import data.SQLHelper;
import page.LoginPage;

import static data.SQLHelper.cleanDatabase;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    public LoginPage loginPage;

    @AfterAll
    static void cleanTables() {
        cleanDatabase();
    }

    @BeforeEach
    void setup() {
        loginPage = open("http://localhost:9999", LoginPage.class);
    }

    @Test
    void shouldSuccessfulLogin() {
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validGoodLogin(authInfo);
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }
}