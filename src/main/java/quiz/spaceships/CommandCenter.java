package itis.quiz.spaceships;


import java.util.ArrayList;

// Вы проектируете интеллектуальную систему управления ангаром командного центра.
// Реализуйте интерфейс SpaceshipFleetManager для управления флотом кораблей.
// Используйте СУЩЕСТВУЮЩИЙ интерфейс и класс космического корабля (SpaceshipFleetManager и Spaceship).
public class CommandCenter implements SpaceshipFleetManager {
    @Override
    public itis.quiz.spaceships.Spaceship getMostPowerfulShip(ArrayList<itis.quiz.spaceships.Spaceship> ships) {
        itis.quiz.spaceships.Spaceship mostPowerful = null;
        for (int i = 0; i < ships.size(); i++) {
            itis.quiz.spaceships.Spaceship spaceship = ships.get(i);
            if (spaceship == null) {
                continue;
            }
            int spaceshipPower = spaceship.getFirePower();
            if (mostPowerful == null) {
                if (spaceshipPower > 0) {
                    mostPowerful = spaceship;
                } else {
                    continue;
                }
            } else if (spaceshipPower > 0 && spaceshipPower > mostPowerful.getFirePower()) {
                mostPowerful = spaceship;
            }
        }
        return mostPowerful != null ? mostPowerful : null;
    }

    @Override
    public itis.quiz.spaceships.Spaceship getShipByName(ArrayList<itis.quiz.spaceships.Spaceship> ships, String name) {
        for (int i = 0; i < ships.size(); i++) {
            if(ships.get(i).getName().equals(name)) {
                return ships.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<itis.quiz.spaceships.Spaceship> getAllShipsWithEnoughCargoSpace(ArrayList<itis.quiz.spaceships.Spaceship> ships, Integer cargoSize) {
        ArrayList<itis.quiz.spaceships.Spaceship> result = new ArrayList<itis.quiz.spaceships.Spaceship>();
        for (int i = 0; i < ships.size(); i++) {
            if(ships.get(i).getCargoSpace() >= cargoSize) {
                result.add(ships.get(i));
            }
        }
        return result;
    }

    @Override
    public ArrayList<itis.quiz.spaceships.Spaceship> getAllCivilianShips(ArrayList<itis.quiz.spaceships.Spaceship> ships) {
        ArrayList<itis.quiz.spaceships.Spaceship> result = new ArrayList<itis.quiz.spaceships.Spaceship>();
        for (int i = 0; i < ships.size(); i++) {
            if(ships.get(i).getFirePower() == 0) {
                result.add(ships.get(i));
            }
        }
        return result;
    }
}
