import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN = 3;
    private static final char DOT_EMPTY = '-';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static char[][] map;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        writeMap();
        while (true) {
            humanTurn();
            writeMap();
            if (isWin()) {
                System.out.println("Ура Вы выграли");
                break;
            }
            if (isFull) {
                System.out.println("Ничия");
                break;
            }

            uiTurn();
            writeMap();
            if (isWin()) {
                System.out.println("Выграл исскуственный интелект");
                break;
            }
            if (isFull) {
                System.out.println("Ничия");
                break;
            }
        }
        System.out.println("Игра окончена");
    }


    private static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j]=DOT_EMPTY;
            }
        }
    }

    private static void writeMap() {
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" "+(i+1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i+1+" ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

}