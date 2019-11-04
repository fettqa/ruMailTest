package ru.mail.test.widgets;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class MessageForm {
    private SelenideElement messageContainer = $("div[message-uid]").waitUntil(Condition.visible,20000);
    protected String theme;
    private String message;

    public MessageForm destination(String email){
        messageContainer.$("div.contactsContainer--3RMuQ input[class^=container--H9L5q]").setValue(email);
        return this;
    }

    public MessageForm theme(String theme) {
        messageContainer.$("div.container--3QXHv input[name=Subject").setValue(theme);
        this.theme = theme;
        return this;
    }

    public void message(String message) {
        messageContainer.$("div[class*=cke_editable_inline] > div:nth-of-type(1)").sendKeys(message);
        this.message = message;

    }

    public CloudForm attach() {
        messageContainer.$(".controls--adDt4 button:nth-of-type(2)").click();
        return new CloudForm();
    }

    public BannerForm messageSending() {
        messageContainer.$("span[title=\"Отправить\"] > span").click();
        return new BannerForm();
    }
}
