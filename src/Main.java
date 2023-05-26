import java.util.Scanner;

public class Main {
   public static String answerLost = "###############";
public static void main(String[] args){

    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    int index = (int)(Math.random()* words.length);
    System.out.println(words[index]+" "+words[index].length());

    while (true) {
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
       if (quesO(words[index], answer)) {
           break;
       }

    }
    System.out.println(words[index]+" kbправильно");
}

public static boolean quesO(String a, String b){
    int end = 0;
    for (int i = 0; i < a.length(); i++) {
       if  (a.charAt(i) == b.charAt(i)) {
        answerLost=answerLost.substring(0,i)+b.charAt(i)+answerLost.substring(i+1);
        System.out.println(answerLost);
        end++;
       }
    }
    if(end==a.length()) return true; else return  false;
}
}
