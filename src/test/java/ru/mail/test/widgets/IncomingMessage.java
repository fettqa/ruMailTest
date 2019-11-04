package ru.mail.test.widgets;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class IncomingMessage {
    private SelenideElement incomingMessages = $("div[class=layout__content]");

    public IncomingMessage assertTheme(String theme) {
        incomingMessages.$("div[class=letter-body__body-content]").$(withText(theme));
        return this;
    }

    public IncomingMessage assertBody(String message) {
        incomingMessages.$("div[class$=js-readmsg-msg]").$(withText(message));
        return this;
    }

    public IncomingMessage assertAttach(String attachName) {
        incomingMessages.$("span[class=b-filename__name").shouldHave(Condition.text(attachName));
        return this;
    }

    public MessageForm sendAnswer() {
        incomingMessages.$("span[class*=button2_reply]").click();
        return new MessageForm();
    }
}
