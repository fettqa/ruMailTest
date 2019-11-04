package ru.mail.test.widgets;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class BannerForm {
    private SelenideElement banner = $("div[class=layer-sent-page] div[class]").waitUntil(Condition.visible,20000);

    public void close() {
        $("span[title=\"Закрыть\"] span[class=button2__wrapper]").click();
    }
}
