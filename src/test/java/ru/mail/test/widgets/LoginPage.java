package ru.mail.test.widgets;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement auth = $("#auth");
    private String email;
    public LoginPage email(String email) {
        auth.$(By.id("mailbox:login")).shouldBe(Condition.visible).setValue(email);
        auth.$(By.id("mailbox:submit")).click();
        this.email = email;
        return this;
    }
    public LoginPage password(String password){
        auth.$(By.id("mailbox:password")).shouldBe(Condition.visible).setValue(password);
        auth.$(By.id("mailbox:submit")).click();
        return this;
    }
    public InBoxPage assertLogin() {
        $(By.id("PH_user-email")).waitUntil(Condition.visible, 20000).shouldHave(Condition.text(email));
        return new InBoxPage();
    }
}
