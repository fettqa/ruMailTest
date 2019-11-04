package ru.mail.test.widgets;
import static com.codeborne.selenide.Selenide.$;
public class RedirectPage {

    public void close() {
        $("a[class=pm-logo__link]").click();
    }
}
