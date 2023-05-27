import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 3;
    private static final int DOTS_TO_WIN= 3;
    private static final char DOT_EMPTY = '-';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static char[][] map;
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        writeMap();
        while (true){
            humanTurn();
            printMap();
            if(isWin())
            {
                System.out.println("Ура Вы выграли");
                break;
            }
            if(isFull){
                System.out.println("Ничия");
                break;
            }

            uiTurn();
            printMap();
            if(isWin())
            {
                System.out.println("Выграл исскуственный интелект");
                break;
            }
            if(isFull){
                System.out.println("Ничия");
                break;
            }
        }
            System.out.println("Игра окончена");
    }
}