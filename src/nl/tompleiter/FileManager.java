package nl.tompleiter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private static String name;
    private static float gameTime;

    public FileManager(String name, float gameTime) {
        this.name = name;
        this.gameTime = gameTime;
    }
//TODO maak de te schrijven data variabel

    public static boolean saveScores(String fileName) {
        try {
            File scoreFile = new File(fileName);
            FileWriter printScores = new FileWriter(scoreFile, true);
            BufferedWriter printer = new BufferedWriter(printScores);
            printer.newLine();
            printer.write("- Speler " + name + " de code binnen " + gameTime + " seconden ontsnapt");
            printer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Er is iets misgegaan:" + e.getMessage());
            return false;
        }
    }

    public static void saveMessage(String[] args) {
        boolean scoresSaved = saveScores("txt\\scores.txt");

        if (scoresSaved) {
            System.out.println("Scores zijn opgeslagen");
        }
        if (!scoresSaved) {
            System.out.println("Scores konden niet worden opgeslagen");
        }
    }

    public static void readScores() {
        File scoreFile = new File("txt\\scores.txt");
        try {
            Scanner scoreScanner = new Scanner(scoreFile);
            while (scoreScanner.hasNextLine()) {
                String scoreLine = scoreScanner.nextLine();
                System.out.println("De vorige keer heeft: " + scoreLine);
            }
            scoreScanner.close();
        } catch (IOException e) {
            System.out.println("Er is iets misgegaan:" + e.getMessage());
        }
    }
}

