package com.march.project.homework7;

import com.march.project.homework7.area.Area;
import com.march.project.homework7.area.Forest;
import com.march.project.homework7.area.Plain;
import com.march.project.homework7.area.Swamp;
import com.march.project.homework7.people.Human;
import com.march.project.homework7.transport.AllTerrainVehicle;
import com.march.project.homework7.transport.Bicycle;
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
        human.getOnTransport(car);         // сели в машину
        human.drive(plain, 100, 100);     // заправили машину, едем
        human.exitTransport();                           // вышли из машины
        System.out.println(human);
        System.out.println();

        // поездка на вездеходе
        AllTerrainVehicle vehicle = new AllTerrainVehicle("Sputnik");
        human.getOnTransport(vehicle);
        human.drive(swamp, 150, 100);     // едем по болоту
        System.out.println(human);
        human.drive(forest, 450, 0);       // едем по лесу
        System.out.println(human);
        human.exitTransport();
        System.out.println();

        // пересаживаемся на лошадь
        Horse horse = new Horse("Star");
        human.getOnTransport(horse);
        System.out.println(human);
        human.drive(plain, 20, 23);
        System.out.println(human);
        human.exitTransport();
        System.out.println();

        // велосипед
        Bicycle bicycle = new Bicycle("Урал");
        human.getOnTransport(bicycle);
        System.out.println(human);
        human.drive(plain, 2, human.getEndurance());   // передаем для расчета силы велосипедиста
        System.out.println(human);
    }
}
