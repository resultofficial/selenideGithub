import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHub {

    @BeforeAll
    static void beforeAll() {
        browserSize = "1920x1080";// Увеличиваем размер окна для видимости элементов
        baseUrl = "https://github.com/";//обсалютный путь
        pageLoadStrategy = "eager";
        holdBrowserOpen = true;//оставлять браузер открытый после теста
        timeout = 5000; // default 4000

    }

    @Test
    void selenideGithub(){
        //Откройте страницу Selenide в Github
        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("Selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".wiki-rightbar").$(byText("Show 3 more pages…")).click();
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        // $("").shouldHave(text("")).shouldBe(visible);
        //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        //$$(".pl-smi").shouldHave(texts("SoftAssertsExtension")).shouldBe(visible);
        $$(".pl-smi").find(Condition.text("SoftAssertsExtension"))
                .shouldBe(Condition.visible);
    }

    }


