public class Main {

    public static void main(String[] args) {
        runApp();
    }

    static void runApp() {
        int a = 1;
        int resultSumm = 0;
        String[][] correctArray = new String[4][4];
        String[][] incorrectSizeArray = {{"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}, {"1", "2", "3", "4", "5"}};
        String[][] incorrectDataArray = {{"5", "5", "1", "1"}, {"8", "4", "8", "1"}, {"5", "5", "h1", "1"}, {"8", "4", "8", "1"}};

        for (int i = 0; i < correctArray.length; i++) {
            for (int j = 0; j < correctArray[i].length; j++) {
                correctArray[i][j] = Integer.toString(a);
                a++;
            }
        }

        System.out.println("Случай с корректным массивом");
        try {
            resultSumm = 0;
            resultSumm = sumOfArrayElements(correctArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Сумма всех элементов массива равна: " + resultSumm);
            System.out.println("====================");
        }

        System.out.println("Случай с неправильным размером массива");
        try {
            resultSumm = 0;
            resultSumm = sumOfArrayElements(incorrectSizeArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Сумма всех элементов массива равна: " + resultSumm);
            System.out.println("====================");
        }

        System.out.println("Случай с некорректными данными в массиве");
        try {
            resultSumm = 0;
            resultSumm = sumOfArrayElements(incorrectDataArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Сумма всех элементов массива равна: " + resultSumm);
            System.out.println("====================");
        }
    }

    public static int sumOfArrayElements(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int summ = 0;

        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 1; i < array.length + 1; i++) {
            for (int j = 1; j < array[i-1].length + 1; j++) {
                try {
                    summ += Integer.parseInt(array[i - 1][j - 1]);
                } catch (IllegalArgumentException e) {
                    String message = "в строке " + i + " и столбце " + j;
                    throw new MyArrayDataException(message);
                }
            }
        }
        return summ;
    }
}