package page;


import com.codeborne.selenide.SelenideElement;


import java.util.List;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class DashboardPage {
    private final List<SelenideElement> Reflenish_buttons = $$("[data-test-id=action-deposit]");



    public DashboardPage() {
        SelenideElement heading = $("[data-test-id=dashboard]");
        heading.shouldBe(visible);
    }

    public FundsTransferPage replenishCardAccount(int index) {
        Reflenish_buttons.get(index).click();
        return new FundsTransferPage();
    }

    public int getBalance(String cardNumber) {
        String cardInfo = $(withText(cardNumber)).getText();
        String sumInfo = cardInfo.substring(cardInfo.indexOf("баланс:") + 7, cardInfo.lastIndexOf("р.")).trim();
        return Integer.parseInt(sumInfo);
    }


}