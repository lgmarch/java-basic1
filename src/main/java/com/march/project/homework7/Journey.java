package com.march.project.homework7;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.area.Forest;
import com.march.project.homework7.area.Plain;
import com.march.project.homework7.area.Swamp;
import com.march.project.homework7.people.Human;
import com.march.project.homework7.transport.AllTerrainVehicle;
import com.march.project.homework7.transport.Car;
import com.march.project.homework7.transport.Horse;

public class Journey {
    public static void main(String[] args) {
        Human human = new Human("Boris");
        System.out.println(human);

        Area forest = new Forest("forest");
        Area plain = new Plain("plain");
        Area swamp = new Swamp("swamp");

        // поездка на машине
        Car car = new Car("BMV");
        human.getOnTransport(car);                  // получили машину
        human.getCurrentTransport().refuelTransport(100); // заправили машину
        System.out.println(car);
        human.run(plain, 100);      // собрались поехать по равнине
        System.out.println(human);
        human.exitTransport();              // вышли из машины
        System.out.println(human);

        // поездка на вездеходе
        AllTerrainVehicle vehicle = new AllTerrainVehicle("Sputnik");
        human.getOnTransport(vehicle);
        human.getCurrentTransport().refuelTransport(100);
        System.out.println(human);
        human.run(swamp, 150);      // едем по болоту
        System.out.println(human);
        human.run(forest, 50);
        System.out.println(human);
        human.exitTransport();

        // пересаживаемся на лошадь
        Horse horse = new Horse("Star");
        human.getOnTransport(horse);
        System.out.println(human);
        human.getCurrentTransport().refuelTransport(50);      // скормили сено лошади
        System.out.println(human);
        human.run(plain, 20);
    }
}
