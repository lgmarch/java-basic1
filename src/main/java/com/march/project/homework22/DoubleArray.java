package com.march.project.homework22;

public class DoubleArray {
    public static double[] createArray(int sizeOfArray) {
        return new double[sizeOfArray];
    }

    public static void fillingArrayPart(double[] array, int from, int to) {
        for (int i = from; i <= to; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        System.out.println("Поток заполнил ячейки с " + from + " по " + to);
    }

    public static void fillArrayPartWithThreads(double[] array, int numberOfParts) {
        if (array.length <= numberOfParts) {
            System.out.println("Массив слишком мал для деления разбиения.");
            return;
        }

        int partSize = array.length / numberOfParts;
        int remainder = array.length % numberOfParts;

        int start = 0;
        Thread[] threads = new Thread[numberOfParts];

        for (int i = 0; i < numberOfParts; i++) {
            int end = start + partSize - 1;

            // Распределяем остаток по первым частям
            if (remainder > 0) {
                end++;
                remainder--;
            }

            final int from = start;
            final int to = end;

            threads[i] = new Thread(() -> fillingArrayPart(array, from, to));
            threads[i].start();

            start = end + 1;
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printArray(double[] arr) {
        System.out.println("Заполненный массив:");
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
