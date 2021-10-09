package jetBrains;
import java.util.*;

public class bullsCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please, enter the secret code's length: ");
        int length = sc.nextInt();
//        while (length >= 10 || length < 4) {
//            System.out.println("Error! Pick a number again: ");
//            length = sc.nextInt();
//        }
        // sc.close();
        sc.nextLine();
        System.out.println("Okay, let's start a game!");
        String secret = generateNum(length);
        String input = "0000";

         while (!secret.equals(input)) {
             int i = 1;
             System.out.println("Turn " + i + ":");
             input = sc.next();
             grader(secret, input);
             i++;
         }
        sc.close();
        
        System.out.println("Congratulations! You guessed the secret code.");

    }

    public static String generateNum(int volume) {

        StringBuilder sb = new StringBuilder();

        if (volume >= 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        } else {
            List<Integer> randomList = new ArrayList<>(List.of(0, 2, 3, 4, 5, 6, 7, 8, 9));
            Collections.shuffle(randomList);

            while (randomList.get(0) == 0) {
                Collections.shuffle(randomList);
            }
            for (int i = 0; i < volume; i++) {
                sb.append(randomList.get(i));
            }
        }
        return sb.toString();
    }

    public static void grader(String secret, String guess) {
        int bull = 0;
        int cow = 0;
        boolean nothing = true;

//        for (int i = 0; i < secret.length(); i++) {
//            if (secret.indexOf(guess.charAt(i)) != -1 && guess.charAt(i) == secret.charAt(i)) {
//                bull++;
//            } else if (secret.indexOf(guess.charAt(i)) != -1) {
//                cow++;
//            }
//        }
        for (int i = 0; i < secret.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                bull++;
            } else if (secret.contains(String.valueOf(guess.charAt(i))) && guess.charAt(i) != secret.charAt(i)) {
                cow++;
            }
        }
//        for(int i = 0; i < secret.length(); i++){
//            if(secret.charAt(i) == guess.charAt(i))
//                bull += 1;
//            else{
//                if(secret.indexOf(guess.charAt(i)) == -1){
//                    nothing = true;
//                }else {
//                    cow += 1;
//                }
//            }
//        }

        if (cow > 0 && bull > 0) {
            System.out.println("Grade: " + bull + " bull(s) and " + cow + " cow(s).");
        } else if (bull == 0 && cow == 0) {
            System.out.println("Grade: None.");
        } else if (cow == 0) {
            System.out.println("Grade: " + bull + " bull(s).");
        } else if (bull == 0) {
            System.out.println("Grade: " + cow + " cow(s).");
        }
    }

//        System.out.println("The secret code is prepared: ****.");
//        System.out.print('\n');
//        System.out.println("Turn 1. Answer:");
//        System.out.println("1234");
//        System.out.println("Grade: None.");
//        System.out.print('\n');
//        System.out.println("Turn 2. Answer:");
//        System.out.println("9876");
//        System.out.println("Grade: 4 bulls.");
//        System.out.println("Congrats! The secret code is 9876.");


}
