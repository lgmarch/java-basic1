package com.march.project.homework7.transport;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.area.Swamp;
import com.march.project.homework7.interrupts.NullPointerExceptionOfAria;

public class Horse extends Transport {
    private final float hayConsumption;     // потребление сена на 1 км

    public Horse(String name) {
        super(name);
        this.hayConsumption = 0.9F;
    }

    @Override
    public void run(Area area, int distance) throws NullPointerExceptionOfAria {
        if (area == null) {
            throw new NullPointerExceptionOfAria("Вы не выбрали куда ехать!");
        }
        if (isNotCanGo(area)){
            return;
        }

        float spentPower = Math.abs(distance) * hayConsumption; // расчет расхода сил на поездку
        if (spentPower > petrol) {
            System.out.println("У лошади не достаточно сил для поездки!");
            return;
        }
        System.out.println("Поехали!");
        petrol -= spentPower;
        System.out.println("... ... ... ...");
        System.out.println("Приехали!");
    }

    @Override
    public boolean isNotCanGo(Area area) {
        if (area instanceof Swamp) {
            System.out.println("Лошадь не может двигаться по " + area);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "лошадь: " + name +
                ", сил у лошади: " + petrol;
    }
}
