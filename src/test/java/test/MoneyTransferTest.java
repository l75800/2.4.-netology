package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import page.FundsTransferPage;
import page.LoginPageV2;


import static com.codeborne.selenide.Selenide.open;

public class MoneyTransferTest {

    @Test
    void transferPageCard () {
        open("http://localhost:9999");
        val loginPage = new LoginPageV2();
        val transferPage = new FundsTransferPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val card = DataHelper.getFirstCard();
        val cardTwo = DataHelper.getSecondCard();
        val cardReplenishmen = transferPage.validCard(card);
        val cardReplenishmenTwo = transferPage.validCard(cardTwo);
    }
}


