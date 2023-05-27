import java.util.Scanner;

public class Main {

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

    }
}