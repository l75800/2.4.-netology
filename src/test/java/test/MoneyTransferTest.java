package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import page.DashboardPage;
import page.LoginPageV2;


import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    private DashboardPage dashboardPage;

    void openPage () {
        open("http://localhost:9999");
        val loginPage = new LoginPageV2();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        dashboardPage = verificationPage.validVerify(verificationCode);
    }

    @Test
    void shouldTransferMoneyBetweenOwnCards() {
        val recipientTransferCardBalance = dashboardPage.getBalance();
        val senderCardBalanceBeforeTransfer = dashboardPage.getBalance();
        val fundsTransferPage = dashboardPage.replenishCardAccount();
        val cards = DataHelper.getCardInfo();
        String amount = String.valueOf(senderCardBalanceBeforeTransfer / 2);
        dashboardPage = fundsTransferPage.validTransferFunds();
    }
}

