package com.march.project.homework7.transport;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.area.Plain;
import com.march.project.homework7.interrupts.NullPointerExceptionOfAria;

public class Car extends Transport {
    private final float gasConsumption;     // расход бензина на 1км

    public Car(String name) {
        super(name);
        this.gasConsumption = 0.1F;
    }

    @Override
    public void run(Area area, int distance) throws NullPointerExceptionOfAria {
        if (area == null) {
            throw new NullPointerExceptionOfAria("Вы не выбрали куда ехать!");
        }
        if (isNotCanGo(area)){
            return;
        }

        float spentGas = Math.abs(distance) * gasConsumption; // расчет расхода бензина на поездку
        if (spentGas > petrol) {
            System.out.println("Не достаточно бензина!");
            return;
        }
        System.out.println("Поехали!");
        petrol -= spentGas;
        System.out.println("======");
        System.out.println("Приехали!");
    }

    @Override
    public boolean isNotCanGo(Area area) {
        if (!(area instanceof Plain)) {
            System.out.println("Машина не может двигаться по " + area);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "машина: " + name +
                ", бензина: " + petrol;
    }
}
