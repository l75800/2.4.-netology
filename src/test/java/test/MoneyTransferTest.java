package test;

import data.DataHelper;
import lombok.val;
import org.junit.jupiter.api.Test;
import page.FundsTransferPage;
import page.LoginPageV2;

public class MoneyTransferTest {

    @Test
    void transferPage () {
        val loginPage = new LoginPageV2();
        val transferPage = new FundsTransferPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        val card = DataHelper.getCardInfo();
        val cardReplenishmen = transferPage.validCard(card);
    }
}


