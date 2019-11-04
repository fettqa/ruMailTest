package ru.mail.test.widgets;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CloudForm {
    private SelenideElement cloud = $(".layer-explorer-from-cloud").waitUntil(Condition.visible,20000);

    public void addAttach(String attachName) {
        cloud.$(".b-list__list").$(byTitle(attachName)).click();
        cloud.$(".layer__footer").$(withText("Прикрепить")).click();
    }
}