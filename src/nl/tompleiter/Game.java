package nl.tompleiter;

import java.util.Random;

public class Game {
    private Player player;


    public Game(Player player) {
        this.player = player;
    }

// Check uitkomst kraak de kluis;
    public boolean checkSafeCracked(int sumOfDigits, int productOfDigits, int firstGuess,
                                    int secondGuess, int thirdGuess, int fourthGuess) {
// Zorgen dat de volgorder van de opgegeven nummers niet uit maakt.
        int sumOfGuessedDigits = firstGuess + secondGuess + thirdGuess + fourthGuess;
        int productOfGuessedDigits = firstGuess * secondGuess * thirdGuess * fourthGuess;

        if (sumOfDigits == sumOfGuessedDigits && productOfDigits == productOfGuessedDigits) {
            return true;
        }
        return false;
    }

// Check uitkomst juiste deur;
    public boolean checkRightDoor(int randomDoorChooser, int doorGuess) {
        if (doorGuess == randomDoorChooser) {
            return true;
        }
        return false;
    }

// Check uitkomst invullen van veld;
    public boolean checkCompleteGrid(String[] board) {
// Verwerken ENGLISH, AGE, GENERAL en ALRIGHT in grid;
        if (board[0].equals("A") && board[1].equals("G") && board[2].equals("E")
                && board[3].equals("L") && board[4].equals("E") && board[5].equals("N")
                && board[6].equals("R") && board[7].equals("N") && board[8].equals("G")
                && board[9].equals("I") && board[10].equals("E") && board[11].equals("L")
                && board[12].equals("G") && board[13].equals("R") && board[14].equals("I")
                && board[15].equals("H") && board[16].equals("A") && board[17].equals("S")
                && board[18].equals("T") && board[19].equals("L") && board[20].equals("H")) {
            return true;
        }
        return false;
    }
}
