package com.march.project.homework7.transport;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.area.Swamp;

public class Horse extends Transport {
    private float power;                    // сколько километров может пройти
    private final float hayConsumption;           // потребление сена

    public Horse(String name) {
        super(name);
        this.hayConsumption = 0.9F;
    }

    @Override
    boolean isCanGo(Area area) {
        if (area instanceof Swamp) {
            System.out.println("Лошадь не может двигаться по " + area);
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

        float spentGas = Math.abs(distance) * hayConsumption; // расчет расхода сил на поездку
        if (spentGas > power) {
            System.out.println("Не достаточно сил у лошади! Ее надо покормить!");
            return false;
        }
        power -= spentGas;
        System.out.println("... ... ... ...");
        System.out.println("Приехали!");
        return true;
    }

    @Override
    public void refuelTransport(float hay) {
        this.power = hay * hayConsumption;
    }

    @Override
    public String toString() {
        return "Horse: " + name +
                ", power: " + power;
    }
}
