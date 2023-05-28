import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 4;
    private static final int DOTS_TO_WIN = 4;
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
            if (isWin(DOT_X)) {
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
            if (isFull()) {
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
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void writeMap() {
        System.out.print(" ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введитее координаты x,y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        return (x >= 0 && x < SIZE) && (y >= 0 && y < SIZE) && (map[y][x] == DOT_EMPTY);
    }

    private static boolean isWin(char sym) {
       if(checkWinHorizontal(sym) || (checkWinVertical(sym)) ||(checkWinDiog(sym))) {return true;}
        return false;
    }

    private static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void uiTurn() {
        int x = 0, y=0 ;

       int k=0;
        int[] cord= new int[2];
        do {


            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                   if(map[i][j] == DOT_X){
                      cord = checkNine(i,j);
                       y=cord[0];
                       x=cord[1];
                   }
                }
            }
            k++;
            if(k>100){
               x =random.nextInt(SIZE);
               y =random.nextInt(SIZE);
            }
        } while (!isCellValid(x, y));
        map[y][x] = DOT_O;
    }

    private static int[] checkNine(int i, int j) {
        int[] in = new int[2];
        in[0]=-1;
        in[1]=-1;
        if(j+2>=0 && j+2<SIZE){
        if (map[i][j+1]==DOT_X){ in[0]=i; in[1]=j+2;}
        }
        if(j-2>=0 && j-2<SIZE) {
            if (map[i][j - 1] == DOT_X) {
                in[0] = i;
                in[1] = j - 2;
            }
        }
            if(i+2>=0 && i+2<SIZE) {
                if (map[i + 1][j] == DOT_X) {
                    in[0] = i + 2;
                    in[1] = j;
                }
            }
                if(i-2>=0 && i-2<SIZE) {
                    if (map[i - 1][j] == DOT_X) {
                        in[0] = i - 2;
                        in[1] = j;
                    }
                }
                    if((i+2>=0 && i+2<SIZE) && (j+2>=0 && j+2<SIZE)){
                        if (map[i + 1][j + 1] == DOT_X) {
                            in[0] = i + 2;
                            in[1] = j + 2;
                        }
                    }
        if((i-2>=0 && i-2<SIZE) && (j-2>=0 && j-2<SIZE)) {
            if (map[i - 1][j - 1] == DOT_X) {
                in[0] = i - 2;
                in[1] = j - 2;
            }
        }
        if((i+2>=0 && i+2<SIZE) && (j-2>=0 && j-2<SIZE)) {
            if (map[i + 1][j - 1] == DOT_X) {
                in[0] = i + 2;
                in[1] = j - 2;
            }
        }
        if((i-2>=0 && i-2<SIZE) && (j+2>=0 && j+2<SIZE)) {
            if (map[i - 1][j + 1] == DOT_X) {
                in[0] = i - 2;
                in[1] = j + 2;
            }
        }
        if((in[0]==-1) || (in[1]==-1)){
            in[0] =random.nextInt(SIZE);
            in[1] =random.nextInt(SIZE);
        }

        return in;

    }

    private static boolean checkWinHorizontal(char ch) {
        int k;
        for (int i = 0; i < SIZE; i++) {
            k = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == ch) {
                    k++;
                }
                if (k == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinVertical(char ch) {
        int k;
        for (int i = 0; i < SIZE; i++) {
            k = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == ch) {
                    k++;
                }
                if (k == DOTS_TO_WIN) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWinDiog(char ch) {
        for (int i = 0; i <SIZE ; i++) {
           if (provLeft(ch,i,0)) {return true;}
            if (provRight(ch,0,i)) {return true;}
        }
        return false;

    }

    private static boolean provRight(char ch, int x,int y) {
        int k=0;
        while (x<SIZE|| y<SIZE){
            if((x>=0 && x<SIZE) && (y>=0 && y<SIZE)){
                if(map[x][y]==ch){
                    k++;
                }
            } else {
                break;
            }
            x++;
            y++;

        }
        if (k==DOTS_TO_WIN) { return true;}
        return false;
    }

    private static boolean provLeft(char ch, int x,int y) {
        int k=0;
        while (x<SIZE|| y<SIZE){
            if((x>=0 && x<SIZE) && (y>=0 && y<SIZE)){
                if(map[x][y]==ch){
                    k++;
                }
            } else {
                break;
            }
            x--;
            y++;

        }
        if (k==DOTS_TO_WIN) { return true;}
        return false;
    }


}