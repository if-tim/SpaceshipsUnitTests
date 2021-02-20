package itis.quiz.spaceships;

import java.util.ArrayList;

/* Это интерфейс для работы с флотом космических кораблей, который необходимо реализовать в вашем командном центре.
   Он содержит несколько методов для поллучения корабля или списка кораблей, по определенным критериям.
   Подробное описание метода приведено над ним.
   !МЕНЯТЬ СИГНАТУРЫ И ТИПЫ ВОЗВРАЩАЕМЫХ ЗНАЧЕНИЙ НЕЛЬЗЯ!
 */
public interface SpaceshipFleetManager {

    //Возвращает самый хорошо вооруженный корабль (с самой большой огневой мощью, отличной от нуля).
    // Если таких кораблей несколько, возвращает первый по списку.
    // Если подходящего корабля нет, возвращает null.
    itis.quiz.spaceships.Spaceship getMostPowerfulShip(ArrayList<itis.quiz.spaceships.Spaceship> ships);

    //Возвращает корабль с заданным именем (предполагается что имена кораблей уникальны).
    // Если подходящего корабля нет, возвращает null.
    itis.quiz.spaceships.Spaceship getShipByName(ArrayList<itis.quiz.spaceships.Spaceship> ships, String name);

    //Возвращает только корабли с достаточно большим грузовым трюмом для перевозки груза заданного размера.
    //Если подходящих кораблей нет, возвращает пустой список.
    ArrayList<itis.quiz.spaceships.Spaceship> getAllShipsWithEnoughCargoSpace(ArrayList<itis.quiz.spaceships.Spaceship> ships, Integer cargoSize);

    //Возвращает только "мирные" корабли (не оснащенные вооружением, без огневой мощи).
    //Если подходящих кораблей нет, возвращает пустой список.
    ArrayList<itis.quiz.spaceships.Spaceship> getAllCivilianShips(ArrayList<itis.quiz.spaceships.Spaceship> ships);

}
