package com.march.project.homework7.area;

public abstract class Area {
    private final String areaName;

    public Area(String areaName) {
        this.areaName = areaName;
    }

    @Override
    public String toString() {
        return "Area " + areaName;
    }
}
