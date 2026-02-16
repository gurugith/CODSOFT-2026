import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("🎮 WELCOME TO THE NUMBER GUESSING GAME 🎮");

        while (playAgain) {
            totalRounds++;
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + totalRounds);
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } 
                else if (userGuess > numberToGuess) {
                    System.out.println("Too High!");
                } 
                else {
                    System.out.println("Too Low!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've used all attempts.");
                System.out.println("The correct number was: " + numberToGuess);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        // Final Score
        System.out.println("\n📊 GAME OVER");
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Rounds Lost: " + (totalRounds - roundsWon));
        System.out.println("Thanks for playing!");

        sc.close();
    }
}
