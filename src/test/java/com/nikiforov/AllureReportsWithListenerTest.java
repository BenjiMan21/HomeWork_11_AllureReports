package com.nikiforov;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class AllureReportsWithListenerTest {

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("Nikiforov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Проверка названия Issue c номером 85")
    void allureReportsHomeworkWithListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-button").click();
        $("#query-builder-test").setValue("qa-guru/niffler").pressEnter();

        $(byLinkText("qa-guru/niffler")).click();
        $("#issues-tab").click();
        $("#issue_85_link").shouldHave(text("[BUG] Список всех пользователей."));
    }
}
