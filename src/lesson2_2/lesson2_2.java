import java.util.Arrays;

//1 task
public class lesson2_2 {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void main(String[] args) {
        printThreeWords();
    }
}

//2 task
   public static void checkSumSign() {
       int a = 1;
       int b = 2;
       int sum = a + b;
       if (sum >= 0) {
           System.out.println("Сумма положительная");
       } else {
           System.out.println("Сумма отрицательная");
       }
   }

   public static void main(String[] args) {
       checkSumSign();
   }
}

//3 task
   public static void printColor() {
       int value = 10;

       if (value >= 0) {
           System.out.println("Red");
       } else if (value > 0 && value <= 100) {
           System.out.println("Yellow");
       } else if (value > 100) {
           System.out.println("Green");
       }
   }

   public static void main(String[] args) {
       printColor();
   }
}

//4 task
   public static void compareNumbers() {
       int a = 15;
       int b = 51;

       if (a >= b) {
           System.out.println("a >=b");
       } else {
           System.out.println("a < b");
       }
   }

   public static void main(String[] args) {
       compareNumbers();
   }
}

//5 task
   public static boolean isSumInRange(int a, int b) {
       int sum = a + b;
       return sum >= 10 && sum <= 20;
   }

   public static void main(String[] args) {
       System.out.println(isSumInRange(5, 5));
       System.out.println(isSumInRange(10, 10));
       System.out.println(isSumInRange(9, 0));
       System.out.println(isSumInRange(15, 6));
   }
}

//6 task
   public static void printNumberSign(final int number) {
       System.out.println(number >= 0 ? "Положительное число" : "Отрицательное число");
   }

   public static void main(String[] args) {
       printNumberSign(10);
       printNumberSign(-15);
       printNumberSign(0);
   }
}

//7 task
   public static boolean isNegative(int number) {
       return number < 0;
   }

   public static void main(String[] args) {
       System.out.println(isNegative(10));
       System.out.println(isNegative(-10));
       System.out.println(isNegative(0));
   }
}

//8 task
   public static void printStringMultipleTimes(String text, int count) {
       if (count <= 0) {
           System.out.println("Atanttion");
           return;
       }
       for (int i = 0; i < count; i++) {
           System.out.println(text);
       }
   }

   public static void main(String[] args) {
       printStringMultipleTimes("Good", 1);
       printStringMultipleTimes("Good mb", -2);
       printStringMultipleTimes("Good too", 0);
   }
}

//9 task
   public static boolean isLeapYear(int year) {
       return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
   }

   public static void main(String[] args) {
       System.out.println(isLeapYear(1000));
       System.out.println(isLeapYear(2000));
       System.out.println(isLeapYear(3004));
       System.out.println(isLeapYear(0));
   }
}

//10 task
    public static void main(String[] args) {
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("Массив");
        printArray(binaryArray);

        invertArray(binaryArray);

        System.out.println("Обратный массив");
        printArray(binaryArray);
    }

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
}
}

//11 task
    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        System.out.println("Массив");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
    }
}

//12 task
    public static void main(String[] args) {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Начальный массив");
        printArray(numbers);
        multiplyLessThanSix(numbers);
        System.out.println("Конечный массив");
        printArray(numbers);
    }

    public static void multiplyLessThanSix(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
    }
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

//13 task
    public static void main(String[] args) {
        int size = 5;
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
            matrix[i][size - 1 - i] = 1;
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            ;
            System.out.println();
        }
    }
}

//14 task
    public static int[] createArray(int len, int initialValue) {
        if (len < 0) {
            throw new IllegalArgumentException("len < 0");
        }
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }
    public static void main(String[] args) {
        int[] array1 = createArray(5, 10);
        System.out.println(Arrays.toString(array1));
        int[] array2 = createArray(5, -10);
        System.out.println(Arrays.toString(array2));
        int[] array3 = createArray(5, 0);
        System.out.println(Arrays.toString(array3));
    }

}
