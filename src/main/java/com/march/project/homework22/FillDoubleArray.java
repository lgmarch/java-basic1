package com.march.project.homework22;

public class FillDoubleArray {
    public static void main(String[] args) {
        int numberOfParts = 4;
        int sizeOfArray = 30;

        // Заполнение массива без потоков
        long start0 = System.nanoTime();
        double[] arr0 = DoubleArray.createArray(sizeOfArray);
        DoubleArray.fillingArrayPart(arr0, 0, arr0.length-1);
        long finish0 = System.nanoTime();
        long elapsed0 = finish0 - start0;

        DoubleArray.printArray(arr0);
        System.out.println("*** Прошло времени, нс: " + elapsed0);

        // Заполнение массива с помощью потоков. Количество потоков можно менять.
        long start1 = System.nanoTime();
        double[] arr1 = DoubleArray.createArray(sizeOfArray);
        DoubleArray.fillArrayPartWithThreads(arr1, numberOfParts);
        long finish1 = System.nanoTime();
        long elapsed1 = finish1 - start1;

        DoubleArray.printArray(arr1);
        System.out.println("*** Прошло времени, нс: " + elapsed1);
    }
}
