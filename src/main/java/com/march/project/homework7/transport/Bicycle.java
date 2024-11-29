package com.march.project.homework7.transport;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.area.Swamp;
import com.march.project.homework7.interrupts.NullPointerExceptionOfAria;

public class Bicycle extends Transport {
    private final float powerOfCyclist;     // расход сил велосипедиста на 1км

    public Bicycle(String name) {
        super(name);
        this.powerOfCyclist = 2.0F;
    }

    @Override
    public void run(Area area, int distance) throws NullPointerExceptionOfAria {
        if (area == null) {
            throw new NullPointerExceptionOfAria("Вы не выбрали куда ехать!");
        }
        if (isNotCanGo(area)){
            return;
        }
        float power = Math.abs(distance) * powerOfCyclist;
        if (power > petrol) {
            System.out.println("Не достаточно сил у велосипедиста!");
            return;
        }
        System.out.println("Поехали!");
        System.out.println("======");
        System.out.println("Приехали!");
    }

    @Override
    public boolean isNotCanGo(Area area) {
        if (area instanceof Swamp) {
            System.out.println("Велосипед не может двигаться по " + area);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "велосипед: " + name;
    }
}
