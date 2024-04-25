package principal;

import annotations.Regression;
import annotations.Smoke;
import entities.UserJson;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;
import utilities.JsonReader;
import utilities.Logs;

public class JsonUserTests extends BaseTest {

    private UserJson user;

    @BeforeEach
    void setUp() {
        user = JsonReader.getUserJson("src/main/resources/data/user.json");
    }

    @Test
    @Smoke
    @Description("Verifying that the ID is greater than 0...")
    @Severity(SeverityLevel.BLOCKER)
    void firstTest() {
        Logs.info("Verifying that the ID is greater than 0...");
        Assertions.assertTrue(user.getId() > 0);
    }

    @Test
    @Regression
    @Description("Verifying that the longitude is 71.7478...")
    @Severity(SeverityLevel.MINOR)
    void secondTest() {
        Logs.info("Verifying that the longitude is 71.7478...");
        Assertions.assertEquals(user.getAddress().getGeo().getLng(), 71.7478);
    }

    @Test
    @Smoke
    @Description("Verifying that the BS size is greater than 10...")
    @Severity(SeverityLevel.TRIVIAL)
    void thirdTest() {
        Logs.info("Verifying that the BS size is greater than 10...");
        Assertions.assertTrue(user.getCompany().getBs().length() > 10);
    }

    @Test
    @Regression
    @Description("Verifying the user information...")
    @Severity(SeverityLevel.MINOR)
    void fourthTest() {
        Logs.info("Verifying the user information...");
        Assertions.assertAll(
                () -> Assertions.assertEquals(user.getName(), "Mrs. Dennis Schulist"),
                () -> Assertions.assertEquals(user.getId(), 6),
                () -> Assertions.assertEquals(user.getUsername(), "Leopoldo_Corkery"),
                () -> Assertions.assertEquals(user.getWebsite(), "ola.org")
        );
    }
}
