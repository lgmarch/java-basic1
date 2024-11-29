package com.march.project.homework7.transport;

import com.march.project.homework7.area.Area;

public abstract class Transport {
    String name;
    private Area area;

    public Transport(String name) {
        this.name = name;
        this.area = null;
    }

    abstract boolean isCanGo(Area area);
    public abstract boolean run(Area area, int distance);
    public abstract void refuelTransport(float petrol);

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
