package com.nikiforov;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static io.qameta.allure.Allure.attachment;


public class AllureReportsWithLambdaTest {
    private static final  String Repository = "qa-guru/niffler";

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("Nikiforov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Проверка названия Issue c номером 85")
    void allureReportsHomeworkWithLambda () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу Github", ()-> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });

        step("Ищем репозиторий " + Repository, ()-> {
            $(".header-search-button").click();
            $("#query-builder-test").setValue(Repository).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + Repository, ()-> {
            $(byLinkText(Repository)).click();
        });

        step("Открывае таб Issues", ()-> {
            $("#issues-tab").click();
        });

        step("Поверяем название Issue с номером 85", ()-> {
            $("#issue_85_link").shouldHave(text("[BUG] Список всех пользователей."));
        });
    }
}
