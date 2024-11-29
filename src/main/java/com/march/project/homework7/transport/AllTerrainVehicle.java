package com.march.project.homework7.transport;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.interrupts.NullPointerExceptionOfAria;

public class AllTerrainVehicle extends Transport {
    private final float gasConsumption;   // расход бензина на 1км

    public AllTerrainVehicle(String name) {
        super(name);
        this.gasConsumption = 0.5F;
    }

    @Override
    public void run(Area area, int distance)throws NullPointerExceptionOfAria {
        if (area == null) {
            throw new NullPointerExceptionOfAria("Вы не выбрали куда ехать!");
        }

        if (isNotCanGo(area)){
            return;
        }

        float spentGas = Math.abs(distance) * gasConsumption; // расчет расхода бензина на поездку
        if (spentGas > petrol) {
            System.out.println("Не достаточно горючки!");
            return;
        }
        System.out.println("Поехали!");
        petrol -= spentGas;
        System.out.println("->->->->");
        System.out.println("Приехали!");
    }

    @Override
    public boolean isNotCanGo(Area area) {
        return false;
    }

    @Override
    public String toString() {
        return "вездеход: " + name +
                ", горючки: " + petrol;
    }
}
