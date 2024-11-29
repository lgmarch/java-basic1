package com.march.project.homework7.transport;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.interrupts.NullPointerExceptionOfAria;

public abstract class Transport {
    String name;
    float petrol;            // всего бензина
    Area area;

    public Transport(String name) {
        this.name = name;
        this.area = null;
    }

    public abstract boolean isNotCanGo(Area area);

    public abstract void run(Area area, int distance) throws NullPointerExceptionOfAria;

    public void refuel(float petrol){   // заправка транспорта
        this.petrol += Math.abs(petrol);
        System.out.println("Заправка: " + name + ", в объеме: " + petrol);
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
