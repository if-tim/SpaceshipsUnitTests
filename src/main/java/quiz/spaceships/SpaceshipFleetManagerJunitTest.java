package quiz.spaceships;

import itis.quiz.spaceships.CommandCenter;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class SpaceshipFleetManagerJunitTest {
  static itis.quiz.spaceships.CommandCenter commandCenter;
  static ArrayList<itis.quiz.spaceships.Spaceship> testList;

  @BeforeAll
  public static void createCommandCenter() {
    SpaceshipFleetManagerJunitTest.commandCenter = new CommandCenter();
    SpaceshipFleetManagerJunitTest.testList = new ArrayList<>();
  }

  @AfterEach
  public void clearTestList() {
    testList.clear();
  }

  @Test
  @DisplayName("Method has to return most powerful spaceship")
  public void getMostPowerfulShip_target() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 22, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 10, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 44, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 33, 0, 0));

    itis.quiz.spaceships.Spaceship result = commandCenter.getMostPowerfulShip(testList);

    Assertions.assertEquals(44, result.getFirePower());
  }

  @Test
  @DisplayName("Method has to return the first spaceship  if there are >= 2 most powerful")
  public void getMostPowerfulShip_firstTarget() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 22, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 44, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 44, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 33, 0, 0));

    itis.quiz.spaceships.Spaceship result = commandCenter.getMostPowerfulShip(testList);

    Assertions.assertEquals("2", result.getName());
  }

  @Test
  @DisplayName("Method has to return null if there is not any armored spaceship")
  public void getMostPowerfulShip_null() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 0, 0, 0));

    itis.quiz.spaceships.Spaceship result = commandCenter.getMostPowerfulShip(testList);

    Assertions.assertNull(result);
  }

  @Test
  @DisplayName("Method has to return ship with a certain name")
  public void getShipByName_target() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 0, 0, 0));

    itis.quiz.spaceships.Spaceship result = commandCenter.getShipByName(testList, "1");

    Assertions.assertEquals("1", result.getName());
  }

  @Test
  @DisplayName("Method has to return null if there is not ship with such name")
  public void getShipByName_null() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 0, 0, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 0, 0, 0));

    itis.quiz.spaceships.Spaceship result = commandCenter.getShipByName(testList, "5");

    Assertions.assertNull(result);
  }

  @Test
  @DisplayName("Method has to return list of ships with >= targeted cargo space")
  public void getAllShipsWithEnoughCargoSpace_target() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 0, 33, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 0, 5, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 0, 10, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 0, 11, 0));

    Integer cargoSize = 7;

    ArrayList<itis.quiz.spaceships.Spaceship> result = commandCenter.getAllShipsWithEnoughCargoSpace(testList, cargoSize);

    for (itis.quiz.spaceships.Spaceship spaceship :
      result) {
      Assertions.assertTrue(spaceship.getCargoSpace() >= cargoSize);
    }
  }

  @Test
  @DisplayName("Method has to return list of nulls if there are not targeted spaceships")
  public void getAllShipsWithEnoughCargoSpace_null() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 0, 3, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 0, 5, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 0, 1, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 0, 1, 0));

    Integer cargoSize = 7;

    ArrayList<itis.quiz.spaceships.Spaceship> result = commandCenter.getAllShipsWithEnoughCargoSpace(testList, cargoSize);

    for (itis.quiz.spaceships.Spaceship spaceship :
      result) {
      Assertions.assertNull(spaceship);
    }
  }

  @Test
  @DisplayName("Method has to return list of civilian spaceships")
  public void getAllCivilianShips_targeted() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 0, 3, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 1, 5, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 1, 1, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 0, 1, 0));

    ArrayList<itis.quiz.spaceships.Spaceship> result = commandCenter.getAllCivilianShips(testList);

    for (itis.quiz.spaceships.Spaceship spaceship :
      result) {
      Assertions.assertTrue(spaceship.getFirePower() == 0);
    }
  }

  @Test
  @DisplayName("Method has to return list of nulls if there are not civilian spaceships in the list")
  public void getAllCivilianShips_null() {
    testList.add(new itis.quiz.spaceships.Spaceship("1", 5, 3, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("2", 1, 5, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("3", 1, 1, 0));
    testList.add(new itis.quiz.spaceships.Spaceship("4", 2, 1, 0));

    ArrayList<itis.quiz.spaceships.Spaceship> result = commandCenter.getAllCivilianShips(testList);

    for (itis.quiz.spaceships.Spaceship spaceship :
      result) {
      Assertions.assertNull(spaceship);
    }
  }
}

