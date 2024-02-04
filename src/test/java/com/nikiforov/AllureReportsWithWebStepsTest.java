package com.nikiforov;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AllureReportsWithWebStepsTest {
    private static final  String Repository = "qa-guru/niffler";

    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Owner("Nikiforov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Github", url = "https://github.com")
    @DisplayName("Проверка названия Issue c номером 85")
    public void allureReportsHomeworkWithWebSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.takeScreenshot();
        steps.searchForRepository(Repository);
        steps.clickOnRepositoryLink(Repository);
        steps.openIssuesTab();
        steps.checkNameOf85Issue();
    }
}
