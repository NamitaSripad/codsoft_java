import java.util.*;
import javax.swing.JOptionPane;

public class NumberGame {

    public static void main(String[] args) {
        showWelcomeDialog();
        guessTheNumber();
    }

    static void showWelcomeDialog() {
        Object[] options = {"Continue"};
        JOptionPane.showOptionDialog(null, "Welcome to the Number Guessing Game!", "Welcome",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    static void guessTheNumber() {
        // Step 1: Generate a random number within the specified range
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

        // Additional details
        int attemptsLimit = 10;
        int roundsPlayed = 0;
        int totalAttempts = 0;

        while (true) {
            // Step 2: Prompt the user to enter their guess
            String userInput = JOptionPane.showInputDialog(null, "Guess the number between " + lowerBound + " and " + upperBound + ":",
                    "Guessing Game", JOptionPane.PLAIN_MESSAGE);

            // Handle cancel button
            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "You canceled the game. Goodbye!", "Game Canceled", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);
            }

            int userGuess;

            try {
                userGuess = Integer.parseInt(userInput);
            } catch (NumberFormatException e) {
                // Handle non-integer input
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            // Step 3: Compare the user's guess and provide feedback
            if (userGuess == secretNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the correct number " + secretNumber + "!",
                        "Congratulations!!! You guessed it right!", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else if (userGuess < secretNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.", "Try Again", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Try again.", "Try Again", JOptionPane.WARNING_MESSAGE);
            }

            // Update attempts and check if the user has reached the limit
            totalAttempts++;
            if (totalAttempts == attemptsLimit) {
                JOptionPane.showMessageDialog(null, "Sorry :( you've reached the maximum number of attempts. The correct number was " + secretNumber + ".",
                        "Game Over", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }

        // Additional details
        roundsPlayed++;
        JOptionPane.showMessageDialog(null, "Round " + roundsPlayed + " completed in " + totalAttempts + " attempts.", "Round Complete!", JOptionPane.INFORMATION_MESSAGE);

        // Step 6: Ask the user if they want to play again
        int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);

        if (playAgain == JOptionPane.YES_OPTION) {
            guessTheNumber();
        } else {
            JOptionPane.showMessageDialog(null, "Great Game!! Your total score is " + roundsPlayed + " rounds won.",
                    "Game Over:(", JOptionPane.PLAIN_MESSAGE);
        }
    }
}