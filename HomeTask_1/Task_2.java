package HomeTask_1;

import java.util.Arrays;

//Задача №2
//Написать точно такую же процедуру, но в декларативном стиле

public class Task_2 {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 10, 7, 54, 43, 12, 4, 15, 73};
        System.out.println(Arrays.toString(sortArrayDeclarative(numbers)));
    }

    public static int[] sortArrayDeclarative(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}


