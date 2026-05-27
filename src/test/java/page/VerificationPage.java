package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import data.SQLHelper;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verificationField = $("[data-test-id=code] input");
    private SelenideElement verificationButton = $("[data-test-id=action-verify]");

    public DashboardPage validVerification (String authCode) {
        Verification(authCode);
        return new DashboardPage();
    }

    public void Verification(String authCode) {
        verificationField.shouldBe(Condition.visible).setValue(authCode);
        verificationButton.click();
    }
}