package com.march.project.homework22;

public class FillDoubleArray {
    public static void main(String[] args) {
        int numberOfParts = 4;

        long start0 = System.nanoTime();

        double[] arr0 = DoubleArray.createArray(numberOfParts);
        DoubleArray.fillingArrayPart(arr0, 0, arr0.length);

        long finish0 = System.nanoTime();
        long elapsed0 = finish0 - start0;
        System.out.println("Прошло времени, нс: " + elapsed0);

        long start1 = System.nanoTime();

        double[] arr1 = DoubleArray.createArray(20);
        DoubleArray.fillArrayPartWithThreads(arr1, numberOfParts);
        DoubleArray.printArray(arr1);

        long finish1 = System.nanoTime();
        long elapsed1 = finish1 - start1;
        System.out.println("Прошло времени, нс: " + elapsed1);
    }
}
