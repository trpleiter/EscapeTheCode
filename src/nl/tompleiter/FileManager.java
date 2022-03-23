package nl.tompleiter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private String name;
    private float gameTime;

    public FileManager (String name, float gameTime) {
        this.name = name;
        this.gameTime = gameTime;
    }
//TODO maak de te schrijven data variabel

    public static boolean saveScores(String fileName) {
        try {
            File scoreFile = new File(fileName);
            FileWriter printScores = new FileWriter(scoreFile);
            BufferedWriter printer = new BufferedWriter(printScores);
            printer.write("Donders:5468");
            printer.newLine();
            printer.write("Piet=2567");
            printer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Geen toegang tot locatie");
            return false;
        }
    }

    public static void saveMessage (String[] args) {
        boolean scoresSaved = saveScores("C:\\Users\\tompl\\IdeaProjects\\EscapeTheCode\\txt\\scores.txt");

        if (scoresSaved) {
            System.out.println("Scores zijn opgeslagen");
        }
        if (!scoresSaved) {
            System.out.println("Scores konden niet worden opgeslagen");
        }
    }
}

