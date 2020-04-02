package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPageV1;



import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {

    private DashboardPage dashboardPage;
    @Test
    void shouldTransferMoneyBetweenOwnCardsV1() {
        open("http://localhost:9999");
        val loginPage = new LoginPageV1();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        dashboardPage = verificationPage.validVerify(verificationCode);
    }
}