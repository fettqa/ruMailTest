package ru.mail.test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.Test;
import ru.mail.test.widgets.*;


public class UsageTest {
    private String firstLogin = "firstacclog@mail.ru";
    private String firstPassword = "1stAccPass";
    private String secondLogin = "secondacclog@mail.ru";
    private String secondPassword = "2ndAccPass";
    private String theme = "Тестовое задание Selenide";
    private String firstMessage = "Тело письма Selenide";
    private String secondMessage = "Выполнено";
    private String attachName = "mdm система.txt";
    private LoginPage loginPage = new LoginPage();
    private CloudForm cloudForm;
    int countOfMessages = 6;

    @Before
    public void Property() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_78.0.3904.70.exe");
        Configuration.startMaximized = true;
        Selenide.open("https://mail.ru");
    }

    @Test
    public void FirstMailAuthorization() {
        loginPage.
                email(firstLogin).
                password(firstPassword);
        InBoxPage inBoxPage = loginPage.assertLogin();
        while(countOfMessages > 0){
            MessageForm messageForm = inBoxPage.openMessageForm();
            messageForm.
                    destination(secondLogin).
                    theme(theme).
                    message(firstMessage);
            cloudForm = messageForm.attach();
            cloudForm.addAttach(attachName);
            BannerForm banner = messageForm.messageSending();
            banner.close();
            countOfMessages--;
        }
        OutcomingMessages outComingMessages = inBoxPage.openOutcomingMessagesForm();
        outComingMessages.assertMessagesSending(countOfMessages, theme);
        RedirectPage redirectPage = inBoxPage.quit();
        redirectPage.close();
        loginPage.
                email(secondLogin).
                password(secondPassword);
        IncomingMessage incomingMessage = inBoxPage.findTheMessage(theme,3);
        MessageForm messageForm = incomingMessage.
                assertTheme(theme).
                assertBody(firstMessage).
                assertAttach(attachName).
                sendAnswer();
        messageForm.message(secondMessage);
        BannerForm banner = messageForm.messageSending();
        banner.close();
        inBoxPage.quit();
        redirectPage.close();
        loginPage.
                email(firstLogin).
                password(firstPassword);
        inBoxPage.findTheMessage(theme,1);
        incomingMessage.assertBody(secondMessage);
    }
}
