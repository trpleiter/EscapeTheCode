package nl.tompleiter;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welkom bij Escape The Code");
        System.out.println("Voordat we beginnen willen we eerst je naam en leeftijd weten");

// Aanroepen Scanner methode en Stopwatch class (zodat deze is aan te roepen vanuit alle scopes in de main classe)
        Scanner input = new Scanner(System.in);
        Stopwatch stopwatch = new Stopwatch();


// Gebruiker laten invullen wie de huidige gebruiker is
        System.out.println("Naam:");
        String currentPlayer = input.nextLine();
        System.out.println("Leeftijd:");
        int agePlayer = input.nextInt();

        Player player = new Player(currentPlayer, agePlayer);

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
        boolean isRightDoorOpened = false;
        while (!isRightDoorOpened) {

// variabele toevoegen
            int firstDigitSafe;
            int secondDigitSafe;
            int thirdDigitSafe;
            int fourthDigitSafe;

// Bepalen TOT welke waarde maximaal kan worden gegaan;
            int maximum = 9;

// Aanroepen methode om random getallen te genereren;
            Random randomizer = new Random();

// Opzetten willekeur tussen welke waarde (1-9) maximaal kan worden gegaan;
            firstDigitSafe = randomizer.nextInt(maximum) + 1;
            secondDigitSafe = randomizer.nextInt(maximum) + 1;
            thirdDigitSafe = randomizer.nextInt(maximum) + 1;
            fourthDigitSafe = randomizer.nextInt(maximum) + 1;

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

            boolean isSafeCracked = false;
            while (!isSafeCracked) {

// Ophalen gebruikers input van nummers;
                System.out.println("Vul vier getallen achter elkaar in");
                int firstGuess = input.nextInt();
                int secondGuess = input.nextInt();
                int thirdGuess = input.nextInt();
                int fourthGuess = input.nextInt();

                System.out.println("Je hebt de volgende getallen gekozen: " + firstGuess + ", " + secondGuess + ", " + thirdGuess + " en " + fourthGuess);

// Conditie toevoegen om te winnen en dat de volgorde van de nummers niet uitmaakt;
                int sumOfGuessedDigits = firstGuess + secondGuess + thirdGuess + fourthGuess;
                int productOfGuessedDigits = firstGuess * secondGuess * thirdGuess * fourthGuess;

                isSafeCracked = sumOfDigits == sumOfGuessedDigits && productOfDigits == productOfGuessedDigits;

// Resultaat winst of verlies;
                if (isSafeCracked) {
                    System.out.println("Klink! Je hebt de cijfercombinatie goed, de kluis is gekraakt! In de kluis vind je een sleutel!");
                } else {
                    System.out.println("De cijfercombinatie is niet juist, de kluis zit nog dicht!");
                }
            }
// ////////////////////////////////////////KIES DE JUISTE DEUR///////////////////////////////////////////////////
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
            if (doorGuess == randomDoorChooser) {
                isRightDoorOpened = true;
                System.out.println("Je hebt deur " + doorGuess + " gekozen en dat is de juiste deur! In de volgende ruimte dien je een raadsel op te lossen");
            } else {
                System.out.println("Helaas, achter deur " + doorGuess + " bevindt zich een lege ruimte, maak snel een nieuwe kluis open!");
            }
        }


// //////////////////////////////////////RAADSEL////////////////////////////////////////////////////////////////////////
// String Array voor het vastleggen van de oplossingen
        String[] riddleSolutions = {"ENGLISH", "AGE", "GENERAL", "ALRIGHT"};
        System.out.println("Om een stukje dichterbij het einde van de code te komen dien een raadsel op te lossen, typ na elke zin het woord waarvan jij denkt dat daar wordt gezocht.");
        System.out.println("Coderen vereist een bepaalde denkwijze en een bepaalde taal, hiermee bedoelen we misschien niet de taal waar jij als eerst aan denkt.");

        Scanner riddleInput = new Scanner(System.in);

// Eerste while-loop tot juiste oplossing
        boolean firstRiddleAnswer = false;
        while (!firstRiddleAnswer) {
            String firstRiddleGuess = riddleInput.nextLine().toUpperCase();
            if (firstRiddleGuess.equals(riddleSolutions[0])) {
                firstRiddleAnswer = true;
                System.out.println(firstRiddleGuess + " is het woord dat we zochten!");
            } else {
                System.out.println(firstRiddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw");
            }
        }
// Tweede while-loop tot juiste oplossing
        System.out.println(player.getName() + ", we blijven even bij deze taal, wat zegt het getal " + player.getAge() + " jou?");
        boolean secondRiddleAnswer = false;
        while (!secondRiddleAnswer) {
            String secondRiddleGuess = riddleInput.nextLine().toUpperCase();
            if (secondRiddleGuess.equals(riddleSolutions[1])) {
                secondRiddleAnswer = true;
                System.out.println(secondRiddleGuess + " is het woord dat we zochten!");
            } else {
                System.out.println(secondRiddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw");
            }
        }
// Derde while-loop tot juiste oplossing
        System.out.println("Over het algemeen gaat het tot nu toe best goed.");
        boolean thirdRiddleAnswer = false;
        while (!thirdRiddleAnswer) {
            String thirdRiddleGuess = riddleInput.nextLine().toUpperCase();
            if (thirdRiddleGuess.equals(riddleSolutions[2])) {
                thirdRiddleAnswer = true;
                System.out.println(thirdRiddleGuess + " is het woord dat we zochten!");
            } else {
                System.out.println(thirdRiddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw");
            }
        }
// Vierde while-loop tot juiste oplossing
        System.out.println("Na deze laatste zin zou het goed moeten zijn..");
        boolean fourthRiddleAnswer = false;
        while (!fourthRiddleAnswer) {
            String fourthRiddleGuess = riddleInput.nextLine().toUpperCase();
            if (fourthRiddleGuess.equals(riddleSolutions[3])) {
                fourthRiddleAnswer = true;
                System.out.println(fourthRiddleGuess + " is het woord dat we zochten!");
            } else {
                System.out.println(fourthRiddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw");
            }
        }
        System.out.println("Onthoud de antwoorden goed, er ontstaat een magisch veld op de muur in deze ruimte");
//                ////////////////////////////////////////SUDOKU///////////////////////////////////////////////////////////
// Grid aanmaken
        String[] board = new String[21];

        for (int i = 0; i < 21; i++) {
            board[i] = Integer.toString(i);
        }
        printBoard(board);

// Aanmaken String Array om over de juiste antwoorden te kunnen loopen (ENGLISH, AGE, GENERAL en ALRIGHT)
        String[] gridSolutions = {"A", "G", "E", "L", "E", "N", "R", "N", "G", "I", "E", "L", "G", "R", "I", "H", "A", "S", "T", "L", "H"};

// Aanmaken loop om elk veld te kunnen invullen en om dit vervolgens dit kunnen controleren

        for (int i = 0; i < board.length; i++) {
            boolean isGridFieldCorrect = false;
            while (!isGridFieldCorrect) {
                System.out.println("\nTyp letter op de positie " + i + " op het veld te vervangen");
                Scanner gridInput = new Scanner(System.in);
                String selectChar = gridInput.nextLine().toUpperCase();
                board[i] = selectChar;
                if (board[i].equals(gridSolutions[i])) {
                    isGridFieldCorrect = true;
                    printBoard(board);
                } else {
                    board[i] = Integer.toString(i);
                    System.out.println("Dit is niet correct, probeer het nog eens");
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

        boolean isGridComplete = checkCompleteGrid(board);

        if (isGridComplete) {
            stopwatch.end();
            System.out.println("\nJe hebt de code binnen " + stopwatch.getGameTimeSeconds() + " seconden gekraakt, klasse!");
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

    public static boolean checkCompleteGrid(String[] board) {
// Verwerken ENGLISH, AGE, GENERAL en ALRIGHT in grid.
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


