package com.march.project.homework8;

import com.march.project.homework8.errors.AppArrayDataException;
import com.march.project.homework8.errors.AppArraySizeException;

public class WorkingWithArray {
    public static void main(String[] args) {
        String[][] matrix = { {"1", "1", "1", "1"}, {"1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"} };

        try {
            int result = checkingArrayForDimension(matrix);
            System.out.println(result);
        } catch (AppArraySizeException ex) {
            System.out.println(ex.getMessage());
        } catch (AppArrayDataException ex) {
            System.out.printf("%s at row %d, column %d%n", ex.getMessage(), ex.getLine(), ex.getColumn());
        }
    }

    public static int checkingArrayForDimension(String[][] arr) throws AppArraySizeException, AppArrayDataException {
        int sum = 0;

        if (arr.length != 4) {
            throw new AppArraySizeException("The array must have a size of 4x4");
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4) {
                    throw new AppArraySizeException("The array must have a size of 4x4");
                }
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException ex) {
                    throw new AppArrayDataException("Невозможно преобразовать строку в число: ", i, j);
                }
            }
        }
        return sum;
    }
}
