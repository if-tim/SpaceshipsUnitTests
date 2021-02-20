package itis.quiz.spaceships;

public class Spaceship {
    private final String name;

    //огневая мощь
    private int firePower;

    //размер грузового трюма
    private int cargoSpace;

    //прочность
    private int durability;

    public Spaceship(String name, int firePower, int cargoSpace, int durability) {
        this.name = name;
        this.firePower = firePower;
        this.cargoSpace = cargoSpace;
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public int getFirePower() {
        return firePower;
    }

    public int getCargoSpace() {
        return cargoSpace;
    }

    public int getDurability() {
        return durability;
    }
}
