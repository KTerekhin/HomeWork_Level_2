import java.util.Arrays;

public class Main {
    static final int arraySize = 10000000;
    static final int arrayHalf = arraySize / 2;

    public static void main(String[] args) {
        runProgram();
    }

    static void runProgram() {
        solveArray1();
        solveArray2();
    }

    static void solveArray1() {
        System.out.println("Начало работы метода 1");
        float[] array1 = new float[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array1[i] = 1;
        }

        long start = System.currentTimeMillis();

        for (int i = 0; i < arraySize; i++) {
            array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long end = System.currentTimeMillis();
        System.out.println(String.format("Время работы метода 1: %s", (end - start)));
    }

    static void solveArray2() {
        System.out.println("Начало работы метода 2");
        float[] array2 = new float[arraySize];
        float[] array2half1 = new float[arrayHalf];
        float[] array2half2 = new float[arrayHalf];
        for (int i = 0; i < arraySize; i++) {
            array2[i] = 1;
        }

        System.out.println("Разбивка массива на 2...");
        long start = System.currentTimeMillis();
        System.arraycopy(array2, 0, array2half1, 0, arrayHalf);
        System.arraycopy(array2, arrayHalf, array2half2, 0, arrayHalf);
        long endSplit = System.currentTimeMillis();
        System.out.println(String.format("Время разбивки массива: %s", (endSplit - start)));

        System.out.println("Подсчет новых значений в массивах...");
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                solveSplitArray(array2half1, 1);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                solveSplitArray(array2half2, 2);
            }
        });

        thread1.run();
        thread2.run();

        System.out.println("Объединение массивов...");
        long startMerge = System.currentTimeMillis();
        System.arraycopy(array2half1, 0, array2, 0, arrayHalf);
        System.arraycopy(array2half2, 0, array2, arrayHalf, arrayHalf);
        long endMerge = System.currentTimeMillis();
        System.out.println(String.format("Время объединения массивов: %s", (endMerge - startMerge)));
    }

    public static void solveSplitArray(float[] arr, int number) {
        long startSolve = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endSolve = System.currentTimeMillis();
        System.out.println(String.format("Время подсчета потока %s: %s", number, endSolve - startSolve));
    }
}
