package page;


import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageV1 {
    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        $("[data-test-id=login] input").setValue(info.getLogin());
        $("[data-test-id=password] input").setValue(info.getPassword());
        $("[data-test-id=action-login]").click();
        $("[name=code]").setValue("12345");
        $("[data-test-id=action-verify]").click();
        $("[data-test-id=action-deposit]").click();
        $("[type=text]").setValue("200");
        $("[type=tel]").setValue("5559 0000 0000 0002");
        $("[data-test-id=action-transfer]").click();
        return new VerificationPage();
    }

}