package org.Roclh;


import org.Roclh.third.Action;
import org.Roclh.third.Human;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ThirdTest {

    private Human human1;
    private Human human2;


    @BeforeEach
    public void init() {
        human1 = new Human("Форд");
        human2 = new Human("Артур");
    }

    @Test
    @DisplayName("Check a hit on ear")
    public void checkHitAtTheEar() {
        Action<Human, Human, String> hitOnTheEar = new Action<>(human1, human2, "легонько хлопнуть " + human1.getName() + " ладонью по уху");
        hitOnTheEar.setAction((hitter, gettingintheface) -> {
            hitter.applyCondition("Бьёт по лицу", hitter.getName() + " молниеносным движением бьёт ладонью по уху");
            gettingintheface.applyCondition("Почувствовал рыбку", gettingintheface.getName() + " с отвращением почувствовал, как рыбка проскользнула в его ухо");
            gettingintheface.getRightEar().putInTheEar("Рыбка");
            return gettingintheface.getCondition("Почувствовал рыбку");
        }).perform();
        assertAll(
                () -> assertTrue(human1.getConditions().containsKey("Бьёт по лицу")),
                () -> assertTrue(human2.getConditions().containsKey("Почувствовал рыбку")),
                () -> assertEquals(hitOnTheEar.getResult(), human2.getCondition("Почувствовал рыбку")),
                () -> assertEquals("Форд молниеносным движением бьёт ладонью по уху", human1.getCondition("Бьёт по лицу")),
                () -> assertEquals("Артур с отвращением почувствовал, как рыбка проскользнула в его ухо", human2.getCondition("Почувствовал рыбку")),
                () -> assertEquals("Рыбка", human2.getRightEar().getInTheEar())
        );
    }

    @Test
    @DisplayName("Check getting fish out")
    public void checkGettingFishOut() {
        human2.getRightEar().putInTheEar("Рыбка");
        Action<Human, Human, String> getFishOut = new Action<>(human2, human2, human2.getName() + " в ужасе попытался выковырять рыбку");
        getFishOut.setAction(((applier, target) -> {
            applier.applyCondition("Пытается вытащить рыбку", applier.getName() + " пытается вытащить рыбку");
            applier.applyCondition("В ужасе", applier.getName() + " в ужасе");
            target.getRightEar().putInTheEar(null);
            return target.getName() + " вдруг застыл в удивлении";
        })).perform();

        assertAll(
                () -> assertTrue(human2.getConditions().containsKey("В ужасе")),
                () -> assertTrue(human2.getConditions().containsKey("Пытается вытащить рыбку")),
                () -> assertEquals(getFishOut.getResult(), human2.getName() + " вдруг застыл в удивлении"),
                () -> assertNull(human2.getRightEar().getInTheEar()),
                () -> assertEquals(human2.getCondition("В ужасе"), human2.getName() + " в ужасе"),
                () -> assertEquals(human2.getCondition("Пытается вытащить рыбку"), human2.getName() + " пытается вытащить рыбку")
        );
    }

    @ParameterizedTest
    @DisplayName("Check audio feeling")
    @ValueSource(strings = {
            "Чувство, которое ты испытываешь, когда смотришь на два разных силуэта и вдруг начинаешь видеть вместо них белую вазу",
            "Чувство когда смотрите на разноцветные точки на бумаге, из которых вдруг выплывает цифра шесть, означающая, что окулист выпишет вам счет за новые очки"
    })
    public void checkAudioFeeling(String visualFeeling) {
        human1.getRightEar().putInTheEar("Рыбка");
        Action<Human, Human, String> feelTheFish = new Action<>(human1, human1, human1.getName() + " испытал звуковое ощущение");
        feelTheFish.setAction(((applier, target) -> {
            if (target.getRightEar().getInTheEar().equals("Рыбка")) {
                target.applyCondition("Испытать слуховое ощущение", visualFeeling);
            }
            return target.getName() + " испытал слуховое ощущение";
        })).perform();
        assertAll(
                () -> assertTrue(human1.getConditions().containsKey("Испытать слуховое ощущение")),
                () -> assertEquals(human1.getCondition("Испытать слуховое ощущение"), visualFeeling)
        );
    }


}
