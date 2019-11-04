package ru.mail.test.widgets;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InBoxPage{

    public MessageForm openMessageForm() {
        $("span[class=compose-button__wrapper]").waitUntil(Condition.visible,20000).click();
        return new MessageForm();
    }

    public RedirectPage quit() {
        $("#PH_logoutLink").waitUntil(Condition.visible,20000).click();
        return new RedirectPage();
    }

    public IncomingMessage findTheMessage(String theme, int i) {
        $("div[class=dataset__items] > a").waitUntil(visible,20000);
        $$("div[class=dataset__items] > a span[class*=llc__subject_unread]").filterBy(text(theme)).first(i).last().click();
        return new IncomingMessage();
    }

    public OutcomingMessages openOutcomingMessagesForm() {
        $("nav a[href*=sent").click();
        return new OutcomingMessages();

    }
}
