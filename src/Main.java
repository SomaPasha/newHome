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
            if (is1Win(DOT_X)) {
                System.out.println("Ура Вы выграли");
                break;
            }
            if (isFull()) {
                System.out.println("Ньчия");
                break;
            }

            uiTurn();
            writeMap();
            if (isWin(DOT_O)) {
                System.out.println("Выграл исскуственный интелект");
                break;
            }
            if (isFull() ){
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

    private static void humanTurn() {
        int x,y;
        do {
            System.out.println("Введитее координаты x,y");
             x = scanner.nextInt() - 1;
             y = scanner.nextInt() - 1;
        }while(!isCellValid(x,y));
        map[y][x]= DOT_X;
    }

    private  static  boolean isCellValid(int x,int y){
        return (x>=0 && x<SIZE) && (y>=0 && y<SIZE) && (map[y][x] ==DOT_EMPTY);
    }

    private static boolean isWin(char sym) {
        if(map[0][0]== sym && map[0][1]== sym && map[0][2]== sym) return true;
        if(map[1][0]== sym && map[1][1]== sym && map[1][2]== sym) return true;
        if(map[2][0]== sym && map[2][1]== sym && map[2][2]== sym) return true;
        if(map[0][0]== sym && map[1][0]== sym && map[2][2]== sym) return true;
        if(map[0][1]== sym && map[1][1]== sym && map[2][2]== sym) return true;
        if(map[0][2]== sym && map[1][2]== sym && map[2][2]== sym) return true;
        if(map[0][0]== sym && map[1][1]== sym && map[2][2]== sym) return true;
        if(map[2][0]== sym && map[1][1]== sym && map[0][2]== sym) return true;
        return false;
    }

    private static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
             if (map[i][j]==DOT_EMPTY) {
             return false;
             }
            }
            }
        return true;
        }

    private static void uiTurn() {
        int x,y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        }while(!isCellValid(x,y));
        map[y][x]= DOT_O;
    }
}