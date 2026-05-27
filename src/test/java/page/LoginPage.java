package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import data.SQLHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");

    public VerificationPage validLogin(DataHelper.UserInfo info) {
        login(info);
        return new VerificationPage();
    }

    public void login(DataHelper.UserInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
    }
}