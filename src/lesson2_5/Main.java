package lesson2_5;

public class Main {
    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "ABC"}
        };

        try {
            System.out.println("Sum correctArray: " + sumArrayElements(correctArray));
            System.out.println("Sum wrongSizeArray: " + sumArrayElements(wrongSizeArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Sum wrongDataArray: " + sumArrayElements(wrongDataArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Error: " + e.getMessage());
        }

        generateArrayIndexOutOfBoundsException();
    }

    public static int sumArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера массива
        if (array.length != 4) {
            throw new MyArraySizeException("Array was 4x4, but line: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new MyArraySizeException(
                        "Line " + i + " have long " + (array[i] == null ? "null" : array[i].length) + ". Expected 4."
                );
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Error [" + i + "][" + j + "]: '" + array[i][j] + "'"
                    );
                }
            }
        }
        return sum;
    }

    public static void generateArrayIndexOutOfBoundsException() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]); // Выход за границы массива
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(message);
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(String message) {
        super(message);
    }
}