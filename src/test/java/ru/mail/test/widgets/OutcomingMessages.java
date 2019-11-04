package ru.mail.test.widgets;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OutcomingMessages {
    private SelenideElement outcomingMessages = $("div[class$=letter-list_has-letters").waitUntil(Condition.visible,20000);

    public void assertMessagesSending(int countOfMessages, String theme) {
        $$("div[class=dataset__items] > a[class*=js-letter-list-item]").filterBy(text(theme)).first(countOfMessages);

    }
}
