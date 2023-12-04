package HomeTask_1;

import java.util.Arrays;


// Задача №1
// Дан список целых чисел numbers. Необходимо написать в императивном стиле процедуру для
//сортировки числа в списке в порядке убывания. Можно использовать любой алгоритм сортировки

public class Task_1 {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 10, 7, 54, 43, 12, 4, 15, 73};
        System.out.println(Arrays.toString(sortArrayImperative(numbers)));
    }

    public static int[] sortArrayImperative(int[] arr) {
        boolean isSorted = false;
        int temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] < arr[i + 1]) {
                    isSorted = false;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
    }
}
