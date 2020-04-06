package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.withText;


public class FundsTransferPage {

    private SelenideElement Amount_field = $("[data-test-id=amount] input");
    private SelenideElement Form_field = $("[data-test-id=from] input");
    private SelenideElement Action_button = $("[data-test-id=action-transfer]");
    private SelenideElement Error_notification = $(".notification_status_error");


    public FundsTransferPage() {
        SelenideElement HEADING = $(withText("Пополнение карты"));
        HEADING.waitUntil(Condition.visible, 15000);
    }


    public DashboardPage validTransferFunds (List <DataHelper.Card> cards, String amount, int senderIndex) {
        Amount_field.setValue(amount);
        Form_field.setValue(cards.get(senderIndex).getCardNumber());
        Action_button.click();
        return new DashboardPage();
    }

    public void setError_notification () {
        Error_notification.shouldBe(Condition.visible);
    }
}
