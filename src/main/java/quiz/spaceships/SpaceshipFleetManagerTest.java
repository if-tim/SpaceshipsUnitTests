package quiz.spaceships;

import itis.quiz.spaceships.CommandCenter;
import itis.quiz.spaceships.Spaceship;

import java.util.ArrayList;

public class SpaceshipFleetManagerTest {

  itis.quiz.spaceships.CommandCenter center;
  ArrayList<itis.quiz.spaceships.Spaceship> testList;

  public SpaceshipFleetManagerTest(CommandCenter center) {
    this.center = center;
    testList = new ArrayList<>();
  }
  
  public boolean getMostPowerfulShipReturnsTarget() {
    testList.clear();
    testList.add(new Spaceship("1", 22, 0, 0));
    testList.add(new Spaceship("2", 10, 0, 0));
    testList.add(new Spaceship("3", 44, 0, 0));
    testList.add(new Spaceship("4", 33, 0, 0));


    Spaceship result = center.getMostPowerfulShip(testList);
    if (result.getFirePower() == 0) {
      return false;
    }

    int maxPower = testList.get(0).getFirePower();
    for (int i = 1; i < testList.size(); i++) {
      int shipPower = testList.get(i).getFirePower();
      if (maxPower < shipPower) {
        maxPower = testList.get(i).getFirePower();
      }
    }
    testList.clear();

    return maxPower == result.getFirePower();
  }

  public boolean getMostPowerfulShipReturnsFirstTarget() {
    testList.clear();
    testList.add(new Spaceship("1", 22, 0, 0));
    testList.add(new Spaceship("2", 44, 0, 0));
    testList.add(new Spaceship("3", 44, 0, 0));
    testList.add(new Spaceship("4", 33, 0, 0));

    Spaceship result = center.getMostPowerfulShip(testList);

    if (result.getFirePower() == 0) {
      return false;
    }

    int maxPower = testList.get(0).getFirePower();
    for (int i = 1; i < testList.size(); i++) {
      int shipPower = testList.get(i).getFirePower();
      if (maxPower < shipPower) {
        maxPower = testList.get(i).getFirePower();
      }
    }

    int firstTargetIndex = -1;
    for (int i = 0; i < testList.size(); i++) {
      itis.quiz.spaceships.Spaceship spaceship = testList.get(i);
      if (spaceship.getFirePower() == maxPower && firstTargetIndex == -1) {
        firstTargetIndex = i;
      }
    }
    if (maxPower == 0) {
      return false;
    }
    itis.quiz.spaceships.Spaceship testResult = testList.get(firstTargetIndex);
    testList.clear();
    return  testResult == result;
  }

  public boolean getMostPowerfulShipReturnsNull() {
    testList.clear();
    testList.add(null);
    testList.add(null);
    testList.add(new Spaceship("3", 0, 0,0));
    testList.add(null);

    itis.quiz.spaceships.Spaceship result = center.getMostPowerfulShip(testList);

    testList.clear();

    return result == null;
  }

  public boolean getShipByNameReturnsTarget() {
    testList.clear();
    testList.add(new Spaceship("1",2,3,4));
    testList.add(new Spaceship("2",2,3,4));
    testList.add(new Spaceship("3",2,3,4));
    testList.add(new Spaceship("4",2,3,4));
    String spaceshipName = "3";

    itis.quiz.spaceships.Spaceship result = center.getShipByName(testList,spaceshipName);
    itis.quiz.spaceships.Spaceship testResult = null;

    for (itis.quiz.spaceships.Spaceship spaceship :
      testList) {
      if (spaceship.getName().equals(spaceshipName)) {
        testResult = spaceship;
      }
    }
    testList.clear();

    return testResult == result;
  }

  public boolean getShipByNameReturnsNull() {
    testList.clear();
    testList.add(new Spaceship("1",1,2,3));
    testList.add(new Spaceship("2",1,2,3));
    testList.add(new Spaceship("3",1,2,3));
    testList.add(new Spaceship("4",1,2,3));
    String spaceshipName = "5";

    itis.quiz.spaceships.Spaceship result = center.getShipByName(testList, spaceshipName);

    return result == null;
  }

  public boolean getAllShipsWithEnoughCargoSpaceReturnsTarget() {
    testList.clear();
    testList.add(new Spaceship("1", 0, 50, 10));
    testList.add(new Spaceship("2", 0, 30, 10));
    testList.add(new Spaceship("3", 0, 11, 10));
    testList.add(new Spaceship("4", 0, 50, 10));
    Integer cargoSize = 49;

    ArrayList<itis.quiz.spaceships.Spaceship> result = center.getAllShipsWithEnoughCargoSpace(testList, cargoSize);
    boolean testResult = true;



    for (int i = 0; i < result.size(); i++) {
      if (result.get(i) == null) {
        return false;
      }
      if (result.get(i).getCargoSpace() < cargoSize) {
        testResult = false;
      }
    }
    testList.clear();

    return testResult;
  }

  public boolean getAllShipsWithEnoughCargoSpaceReturnsNull() {
    testList.clear();
    testList.add(new Spaceship("1", 0, 50, 10));
    testList.add(new Spaceship("1", 0, 50, 10));
    testList.add(new Spaceship("1", 0, 50, 10));
    testList.add(new Spaceship("1", 0, 50, 10));
    Integer cargoSize = 51;

    ArrayList<itis.quiz.spaceships.Spaceship> result = center.getAllShipsWithEnoughCargoSpace(testList, cargoSize);
    boolean testResult = true;

    for (int i = 0; i < result.size(); i++) {
      if (result.get(i) != null) {
        testResult = false;
      }
    }
    testList.clear();

    return testResult;
  }

  public boolean getAllCivilianShipsReturnsTarget() {
    testList.clear();
    testList.add(new Spaceship("1", 22, 0,0));
    testList.add(new Spaceship("2", 0, 0,0));
    testList.add(new Spaceship("3", 0, 0,0));
    testList.add(new Spaceship("4", 55, 0,0));

    ArrayList<itis.quiz.spaceships.Spaceship> result = center.getAllCivilianShips(testList);

    for (itis.quiz.spaceships.Spaceship spaceship:
    result){
      if (spaceship.getFirePower() > 0) {
        return false;
      }
    }

    return true;
  }

  public boolean getAllCivilianShipsReturnsNull() {
    testList.clear();
    testList.add(new Spaceship("1", 2, 0, 0));
    testList.add(new Spaceship("2", 2, 0, 0));
    testList.add(new Spaceship("3", 2, 0, 0));
    testList.add(new Spaceship("4", 2, 0, 0));

    ArrayList<itis.quiz.spaceships.Spaceship> result = center.getAllCivilianShips(testList);

    for (itis.quiz.spaceships.Spaceship spaceship :
      result) {
      if (spaceship != null) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {

    CommandCenter center = new CommandCenter();
    SpaceshipFleetManagerTest test = new SpaceshipFleetManagerTest(center);
    double testScore = 0;

    if (test.getMostPowerfulShipReturnsTarget()) testScore += 0.5;
    if (test.getMostPowerfulShipReturnsFirstTarget()) testScore += 0.5;
    if (test.getAllCivilianShipsReturnsNull()) testScore += 0.5;
    if (test.getShipByNameReturnsTarget() && test.getShipByNameReturnsNull()) testScore += 0.5;
    if (test.getAllShipsWithEnoughCargoSpaceReturnsTarget()) testScore += 0.5;
    if (test.getAllShipsWithEnoughCargoSpaceReturnsNull()) testScore += 0.5;
    if (test.getAllShipsWithEnoughCargoSpaceReturnsTarget()) testScore += 0.5;
    if (test.getAllShipsWithEnoughCargoSpaceReturnsNull()) testScore += 0.5;
    System.out.println(testScore);
  }
}
