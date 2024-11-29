package com.march.project.homework7.transport;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.area.Plain;

public class Car extends Transport {
    private float petrol;                   // всего бензина
    private final float gasConsumption;     // потребеление бензина на 1км

    public Car(String name) {
        super(name);
        this.gasConsumption = 0.1F;
    }

    @Override
    boolean isCanGo(Area area) {
        if (!(area instanceof Plain)) {
            System.out.println("Машина не может двигаться по " + area);
            return true;
        }
        return false;
    }

    @Override
    public boolean run(Area area, int distance) {
        if (area == null) {
            System.out.println("Вы не выбрали куда ехать!");
            return false;
        }
        if (isCanGo(area)){
            return false;
        }

        float spentGas = Math.abs(distance) * gasConsumption; // расчет расхода бензина на поездку
        if (spentGas > petrol) {
            System.out.println("Не достаточно бензина!");
            return false;
        }
        petrol -= spentGas;
        System.out.println("======");
        System.out.println("Приехали!");
        return true;
    }

    public float getPetrol() {
        return petrol;
    }

    @Override
    public void refuelTransport(float petrol) {
        this.petrol = petrol;
        System.out.println("Заправка Car: " + name + ", бензином в объеме: " + petrol);
    }

    @Override
    public String toString() {
        return "Car: " + name +
                ", petrol: " + petrol;
    }
}
