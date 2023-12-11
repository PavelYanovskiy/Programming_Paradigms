package HomeTask_4;

// Контекст
// Корреляция - статистическая мера, используемая для оценки
// связи между двумя случайными величинами.
// ● Ваша задача
// Написать скрипт для расчета корреляции Пирсона между
// двумя случайными величинами (двумя массивами). Можете
// использовать любую парадигму, но рекомендую использовать
// функциональную, т.к. в этом примере она значительно
// упростит вам жизнь.


import java.util.Arrays;

public class Task_4 {
    public static void main(String[] args) {
        // Пример для двух массивов случайных величин
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {1, 1.5, 2, 2.5, 3};

        double correlation = calculatePearsonCorrelation(x, y);
        System.out.println("Коэффициент корреляции Пирсона: " + correlation);
    }

    public static double calculatePearsonCorrelation(double[] x, double[] y) {
        // Проверка на совпадение длин массивов
        if (x.length != y.length) {
            throw new IllegalArgumentException("Длины массивов не совпадают");
        }

        // Расчет средних значений
        double meanX = Arrays.stream(x).average().orElse(0);
        double meanY = Arrays.stream(y).average().orElse(0);

        // Расчет коэффициента корреляции Пирсона
        double sumXY = 0;
        double sumX2 = 0;
        double sumY2 = 0;

        for (int i = 0; i < x.length; i++) {
            sumXY += (x[i] - meanX) * (y[i] - meanY);
            sumX2 += Math.pow((x[i] - meanX), 2);
            sumY2 += Math.pow((y[i] - meanY), 2);
        }

        return sumXY / Math.sqrt(sumX2 * sumY2);
    }
}

