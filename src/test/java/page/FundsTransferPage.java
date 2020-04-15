package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class FundsTransferPage {
    private SelenideElement Action_dep = $("[data-test-id=action-deposit]");
    private SelenideElement Amount_field = $("[data-test-id=amount] input");
    private SelenideElement Form_field = $("[data-test-id=from] input");
    private SelenideElement Action_button = $("[data-test-id=action-transfer]");


    public DashboardPage validCard (DataHelper.Card card) {
        Action_dep.click();
        Amount_field.setValue("15000000");
        Form_field.setValue(card.getCardNumber());
        Action_button.click();
        return new DashboardPage();
    }


}


