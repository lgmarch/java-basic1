package com.march.project.homework7.people;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.interrupts.NullPointerExceptionOfAria;
import com.march.project.homework7.interrupts.NullPointerExceptionOfTransport;
import com.march.project.homework7.transport.Transport;

public class Human {
    private final String name;
    private int endurance;      // выносливость
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
        this.endurance = 100;
        this.currentTransport = null;   // изначально у человека нет транспорта
    }

    // сесть в транспорт
    public void getOnTransport(Transport newTransport) {
        if (currentTransport != null) {
            System.out.println("Чтобы сесть в другой транспорт, вначале необходимо выйти из текущего.");
        }
        if (newTransport == null) {
            System.out.println("Поездка невозможна. Отсутствует средство передвижения.");
            return;
        }
        currentTransport = newTransport;
        System.out.println(name + " получил " + currentTransport);
    }

    private void refuelTransport(float petrol) throws NullPointerExceptionOfTransport {
        if (currentTransport == null) {
            throw new NullPointerExceptionOfTransport("Заправка невозможна. Отсутствует средство передвижения.");
        }
        currentTransport.refuel(petrol);
    }

    // поехали
    public void drive(Area area, int distance, float petrol) {
        try {
            refuelTransport(petrol);                // заправляем машину
            currentTransport.run(area, distance);   // поехали!
        } catch (NullPointerExceptionOfTransport | NullPointerExceptionOfAria ex) {
            System.out.println(ex.getMessage());
        }
    }

    // выйти из транспорта
    public void exitTransport() {
        if (currentTransport == null) {
            return;
        }
        System.out.println("Путешественник: " + name + ", отдал средство передвижения: " + currentTransport);
        currentTransport = null;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return "Путешественник: " + name + ", выносливость: " + endurance + ", транспорт: " + (currentTransport == null ? "отсутствует" : currentTransport);
    }
}
