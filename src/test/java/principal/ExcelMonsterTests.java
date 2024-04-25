package principal;

import annotations.Regression;
import annotations.Smoke;
import entities.Monster;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.BaseTest;
import utilities.ExcelReader;
import utilities.Logs;

import java.util.List;

public class ExcelMonsterTests extends BaseTest {

    private List<Monster> monsterList;

    @BeforeEach
    void setUp() {
        monsterList = ExcelReader.getMonstersList();
    }

    @Test
    @Regression
    @Smoke
    @Description("Verifying that the first element has the name TOLOSA")
    @Severity(SeverityLevel.BLOCKER)
    void firstTest() {
        Logs.info("Verifying that the first element has the name TOLOSA");
        Assertions.assertEquals(monsterList.get(0).getName(), "TOLOSA");
    }

    @Test
    @Smoke
    @Description("Verifying that the list size is 14")
    @Severity(SeverityLevel.MINOR)
    void secondTest() {
        Logs.info("Verifying that the list size is 14");
        Assertions.assertEquals(monsterList.size(), 14);
    }

    @Test
    @Smoke
    @Description("Verifying that the level of the third monster is 22")
    @Severity(SeverityLevel.BLOCKER)
    void thirdTest() {
        Logs.info("Verifying that the level of the third monster is 22");
        Assertions.assertEquals(monsterList.get(2).getLevel(), 22);
    }

    @Test
    @Regression
    @Description("Verifying the last monster of the list...")
    @Severity(SeverityLevel.CRITICAL)
    void fourthTest() {
        Logs.info("Verifying the last monster of the list...");
        final var lastMonster = monsterList.get(monsterList.size() - 1);

        Assertions.assertAll(
                () -> Assertions.assertEquals(lastMonster.getName(), "LUCENA"),
                () -> Assertions.assertEquals(lastMonster.getAge(), 3),
                () -> Assertions.assertEquals(lastMonster.getWeight(), 8.57),
                () -> Assertions.assertEquals(lastMonster.getGender(), "MACHO"),
                () -> Assertions.assertEquals(lastMonster.getType(), "PLANTA"),
                () -> Assertions.assertEquals(lastMonster.getLevel(), 36)
        );
    }
}
