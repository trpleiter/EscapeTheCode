package nl.tompleiter;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welkom bij Escape The Code");
        System.out.println("Voordat we beginnen willen we eerst je naam en leeftijd weten");

// Aanroepen Scanner methode en Stopwatch class (zodat deze is aan te roepen vanuit alle scopes in de main class)
        Scanner input = new Scanner(System.in);
        Stopwatch stopwatch = new Stopwatch();


// Gebruiker laten invullen wie de huidige speler is
        System.out.println("Naam:");
        String currentPlayer = input.nextLine();
        System.out.println("Leeftijd:");
        int agePlayer = input.nextInt();

        Player player = new Player(currentPlayer, agePlayer);
        Game game = new Game(player);

//Welkomsbericht

        System.out.println(player.getName() + "! Nogmaals, welkom bij Escape The Code.");
        if (player.getAge() < 18) {
            System.out.println("Nog geen 18? Maakt niet uit, ook jong talent mag de code proberen te ontsnappen");
        } else {
            System.out.println(player.getAge() + " jaar oud! Wijsheid komt met de jaren, laten we zien hoe snel jij kunt ontsnappen uit onze code.");
        }
        System.out.println("De bedoeling van het spel is om zo snel mogelijk tot het einde van de code te komen, wat er allemaal voorbij gaat komen is een verrassing, maar we kunnen je alvast verklappen dat je eerst een kluis moet zien te kraken.");

// Spel en tijd starten;
        System.out.println("Wil je het spel en daarmee de tijd starten? Toets [y/n]");

// Ophalen gebruikers input om het spel te starten;
        Scanner startPlay = new Scanner(System.in);
        String chooseStartPlaying = startPlay.nextLine().toLowerCase();

// Switch statement om te bepalen hoe de code zich gedraagd na de keuze van de gebruiker om te starten met spelen;
        switch (chooseStartPlaying) {
            case "y": {
                System.out.println("De tijd loopt! Succes met het eerste onderdeel, het kraken van de kluis!");
                stopwatch.start();
                break;
            }
            case "n": {
                System.out.println("Je hebt ervoor gekozen om te stoppen met spelen");
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Je hebt geen keuze gemaakt of je wil spelen");
                System.exit(0);
                break;
            }

        }
//        //////////////////////////////////////KRAAK DE KLUIS//////////////////////////////////////////////////////////
        System.out.println("In de eerste ruimte bevinden zich gigantisch veel kluizen");
// Opzetten while loop zodat de speler wordt gereset naar het begin van het spel bij keuze van een verkeerde deur;
        boolean isRightDoorOpened = false;
        while (!isRightDoorOpened) {

// variabele toevoegen
            int firstDigitSafe;
            int secondDigitSafe;
            int thirdDigitSafe;
            int fourthDigitSafe;

// Bepalen TOT welke waarde maximaal kan worden gegaan;
            int digitSafeMaximum = 9;

// Aanroepen methode om random getallen te genereren;
            Random randomizer = new Random();

// Opzetten willekeur tussen welke waarde (1-9) maximaal kan worden gegaan;
            firstDigitSafe = randomizer.nextInt(digitSafeMaximum) + 1;
            secondDigitSafe = randomizer.nextInt(digitSafeMaximum) + 1;
            thirdDigitSafe = randomizer.nextInt(digitSafeMaximum) + 1;
            fourthDigitSafe = randomizer.nextInt(digitSafeMaximum) + 1;

// Controle willekeurig gegenereerde nummers;
            System.out.println("Het eerste getal is: " + firstDigitSafe);
            System.out.println("Het tweede getal is: " + secondDigitSafe);
            System.out.println("Het derde getal is: " + thirdDigitSafe);
            System.out.println("Het vierde getal is: " + fourthDigitSafe);

// Som en product bepalen en vastzetten in variabelen;
            int sumOfDigits = firstDigitSafe + secondDigitSafe + thirdDigitSafe + fourthDigitSafe;
            int productOfDigits = firstDigitSafe * secondDigitSafe * thirdDigitSafe * fourthDigitSafe;

            System.out.println("Je pakt een willekeurige kluis waarbij de volgende hints op het cijferslot staan:");
            System.out.println("De som van de getallen is: " + sumOfDigits);
            System.out.println("Het product van de getallen is: " + productOfDigits);

// While loop tot dat de cijfercombinatie juist is;
            boolean isSafeCracked = false;
            while (!isSafeCracked) {

// Ophalen input gebruiker;
                System.out.println("Vul vier getallen achter elkaar in");
                int firstGuess = input.nextInt();
                int secondGuess = input.nextInt();
                int thirdGuess = input.nextInt();
                int fourthGuess = input.nextInt();
                System.out.println("Je hebt de volgende getallen gekozen: " + firstGuess + ", " + secondGuess + ", " + thirdGuess + " en " + fourthGuess);

// Conditie checken die in de Game class is gemaakt;
                isSafeCracked = game.checkSafeCracked(sumOfDigits, productOfDigits, firstGuess, secondGuess, thirdGuess, fourthGuess);

// Bericht na invoer gebruiker;
                if (isSafeCracked) {
                    System.out.println("Klink! Je hebt de cijfercombinatie goed, de kluis is gekraakt! In de kluis vind je een sleutel!");
                } else {
                    System.out.println("De cijfercombinatie is niet juist, de kluis zit nog dicht!");
                }
            }
// ////////////////////////////////////////////KIES DE JUISTE DEUR//////////////////////////////////////////////////////

            System.out.println("Met de sleutel kun je een deur openen, er zijn echter drie deuren en de sleutel kan maar één keer gebruikt worden");
            System.out.println("Wanneer de gekozen deur niet juist is, moet er een nieuwe kluis worden geopend voor een nieuwe sleutel");

// Aanmaken variabelen voor het genereren van een willekeurig nummer om een juiste deur te kunnen kiezen
            int amountOfDoors = 3;
            int randomDoorChooser = randomizer.nextInt(amountOfDoors) + 1;

// Controlezin juiste deur
            System.out.println("De juiste deur is deur " + randomDoorChooser);

// Gebruiker een deur laten kiezen
            System.out.println("Voor welke deur wil jij jouw sleutel gebruiken? Typ het nummer van de deur [1, 2 of 3]");
            int doorGuess = input.nextInt();

// Logica goede deur
            isRightDoorOpened = game.checkRightDoor (randomDoorChooser, doorGuess);
            if (isRightDoorOpened) {
                System.out.println("Je hebt deur " + doorGuess + " gekozen en dat is de juiste deur! In de volgende ruimte dien je een raadsel op te lossen.");
            } else {
                System.out.println("Helaas, achter deur " + doorGuess + " bevindt zich een lege ruimte, maak snel een nieuwe kluis open!");
            }
        }


// //////////////////////////////////////RAADSEL////////////////////////////////////////////////////////////////////////

// String Array voor het vastleggen van de oplossingen
        String[] riddleSolutions = {"ENGLISH", "AGE", "GENERAL", "ALRIGHT"};
        System.out.println("Om een stukje dichterbij het einde van de code te komen dien een raadsel op te lossen, bij elke zin hoort een woord. Typ eerst een woord in waarvan jij denkt dat dat woord bij de eerste zin hoort.");
        System.out.println("1. Coderen vereist een bepaalde denkwijze en een bepaalde taal, hiermee bedoelen we misschien niet de taal waar jij als eerst aan denkt.");
        System.out.println("2. " + player.getName() + ", we blijven even bij deze taal, wat zegt het getal " + player.getAge() + " jou?");
        System.out.println("3. Over het algemeen gaat het tot nu toe best goed.");
        System.out.println("4. Na deze laatste zin zou het goed moeten zijn..");

        Scanner riddleInput = new Scanner(System.in);

// For loop met een while-loop om net zo lang door te gaan tot de vier juiste oplossing zijn gevonden;
        for (int i = 0; i < riddleSolutions.length; i++) {
            boolean riddleAnswer = false;
            while (!riddleAnswer) {
                String riddleGuess = riddleInput.nextLine().toUpperCase();
                if (riddleGuess.equals(riddleSolutions[i])) {
                    riddleAnswer = true;
                    System.out.println(riddleGuess + " is het woord dat we zochten! Op naar de volgende!");
                } else {
                    System.out.println(riddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw!");
                }
            }
        }
        System.out.println("Onthoud de antwoorden goed, er ontstaat een magisch veld op de muur in deze ruimte!");

//                ////////////////////////////////////////SUDOKU///////////////////////////////////////////////////////////
// Grid aanmaken
        String[] board = new String[21];

        for (int i = 0; i < 21; i++) {
            board[i] = Integer.toString(i);
        }
        printBoard(board);

// Aanmaken String Array om over de juiste antwoorden te kunnen loopen (ENGLISH, AGE, GENERAL en ALRIGHT)
        String[] gridSolution = {"A", "G", "E", "L", "E", "N", "R", "N", "G", "I", "E", "L", "G", "R", "I", "H", "A", "S", "T", "L", "H"};

// Aanmaken loop om elk veld te kunnen invullen en om dit vervolgens dit kunnen controleren

        for (int i = 0; i < board.length; i++) {
            boolean isGridFieldCorrect = false;
            while (!isGridFieldCorrect) {
                System.out.println("\nTyp een letter in om positie " + i + " op het veld te vervangen met die letter.");
                Scanner gridInput = new Scanner(System.in);
                String riddleChar = gridInput.nextLine().toUpperCase();
                board[i] = riddleChar;
                if (board[i].equals(gridSolution[i])) {
                    isGridFieldCorrect = true;
                    printBoard(board);
                } else {
                    board[i] = Integer.toString(i);
                    System.out.println("Dit is niet correct, probeer het nog eens!");
                }
            }
        }
// Final check of het grid correct is
//  A G E
//  L E N
//  R N G
//  I E L
//  G R I
//  H A S
//  T L H

        boolean isGridComplete = game.checkCompleteGrid(board);

        if (isGridComplete) {
            stopwatch.end();
            player.setGameTime(stopwatch.getGameTimeSeconds());
            System.out.println("\nJe bent de code binnen " + stopwatch.getGameTimeSeconds() + " seconden ontsnapt, klasse!");
        }
    }


    public static void printBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);

            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean isLastField = i == 20;

            if (!isEndOfRow) {
                System.out.print(" | ");
            }
            if (isEndOfRow && !isLastField) {
                System.out.println("\n____________");
            }
        }
    }

}


