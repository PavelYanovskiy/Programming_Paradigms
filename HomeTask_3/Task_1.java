package HomeTask_3;

import java.util.Scanner;

public class Task_1 {
    // Создание объекта Scanner для ввода с клавиатуры
    private static final Scanner scanner = new Scanner(System.in); 
    // Инициализация игрового поля 3x3
    private static final char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    // Инициализация текущего игрока (X начинает первый)
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        // Флаг, указывающий, продолжается ли игра
        boolean gameContinues = true;
        // Вывод игрового поля на экран
        printBoard();

        // Цикл обеспечивает продолжение игры до тех пор, пока не будет достигнут результат
        while (gameContinues) {
            // Приглашение к вводу координат хода
            System.out.println("Игрок " + currentPlayer + ", введите номер строки (1-3) и столбца (1-3): ");
            // Получение номера строки от игрока с последующей коррекцией (для согласования с индексом массива)
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            // Проверка на возможность совершения хода в выбранную ячейку
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                // Установка хода игрока на выбранную ячейку
                board[row][col] = currentPlayer;
                // Повторный вывод игрового поля с учетом совершенного хода
                printBoard();

                // Проверка на победу после хода
                if (checkWinner(row, col)) {
                    // Установка флага, что игра завершена
                    System.out.println("Игрок " + currentPlayer + " победил!");
                    gameContinues = false;
                    // Проверка на ничью после хода
                } else if (isBoardFull()) {
                    // Установка флага, что игра завершена
                    System.out.println("Ничья!");
                    gameContinues = false;
                }
// Смена игрока после завершения хода
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                // Предупреждение при попытке хода в недопустимую ячейку
                System.out.println("Некорректный ход. Попробуйте еще раз.");
            }
        }
    }
    // Метод для вывода текущего состояния игрового поля
    private static void printBoard() {
        // Перебор строк игрового поля
        for (char[] row : board) {
            // Перебор ячеек в строке
            for (char cell : row) {
                // Вывод символа из ячейки с разделителем
                System.out.print("| " + cell + " ");
            }
            // Переход на новую строку после полной печати строки символов
            System.out.println("|");
        }
    }
    // Метод для проверки победного хода
    private static boolean checkWinner(int row, int col) {
        // Проверка победы по строкам и столбцам и по диагоналям
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) ||
               (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) ||
               (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }
    // Метод для проверки заполненности игрового поля
    private static boolean isBoardFull() {
        // Перебор строк игрового поля
        for (char[] row : board) {
            // Перебор ячеек в строке
            for (char cell : row) {
                // Если найдена пустая ячейка
                if (cell == ' ') {
                    // Игровое поле не полностью заполнено
                    return false;
                }
            }
        }
        // Если все ячейки игрового поля заполнены
        return true;
    }
}

