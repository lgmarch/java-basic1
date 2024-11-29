package com.march.project.homework7.people;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.transport.Transport;

public class Human {
    private final String name;
    private int endurance;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
        this.endurance = 100;
        this.currentTransport = null;   // изначально у человека нет транспорта
    }

    // получить в транспорт
    public void getOnTransport(Transport newTransport) {
        if (newTransport == null) {
            throw new IllegalStateException("The transport has not been set yet.");
        }
        currentTransport = newTransport;
        System.out.println(name + " получил " + currentTransport);
    }

    // выйти из транспорта
    public void exitTransport() {
        System.out.println("Human: " + name + ", отдал машину: " + currentTransport);
        currentTransport = null;
    }

    public boolean run(Area area, int distance) {
        System.out.println("Поехали!");
        return currentTransport.run(area, distance);
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public Transport getCurrentTransport() {
        if (currentTransport == null) {
            throw new IllegalStateException("The transport has not been set yet.");
        }
        return currentTransport;
    }

    @Override
    public String toString() {
        return "Human: " + name + ", currentTransport: " + (currentTransport == null ? "отсутствует" : currentTransport);
    }
}
