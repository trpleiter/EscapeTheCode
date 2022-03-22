package nl.tompleiter;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welkom bij Escape The Code");
        System.out.println("Voordat we beginnen willen we eerst je naam en leeftijd weten");

// Aanroepen Scanner Methode
        Scanner input = new Scanner(System.in);


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
//                TODO: EEN TIMER TOEVOEGEN
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
        while (isRightDoorOpened == false) {

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
            while (isSafeCracked == false) {

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
        while (firstRiddleAnswer == false) {
            String firstRiddleGuess = riddleInput.nextLine().toUpperCase();
            if (firstRiddleGuess.equals(riddleSolutions[0])) {
                firstRiddleAnswer = true;
                System.out.println(firstRiddleGuess + " is het woord dat we zochten!");
            } else {
                System.out.println(firstRiddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw");
                ;
            }
        }
// Tweede while-loop tot juiste oplossing
        System.out.println(player.getName() + ", we blijven even bij deze taal, wat zegt het getal " + player.getAge() + " jou?");
        boolean secondRiddleAnswer = false;
        while (secondRiddleAnswer == false) {
            String secondRiddleGuess = riddleInput.nextLine().toUpperCase();
            if (secondRiddleGuess.equals(riddleSolutions[1])) {
                secondRiddleAnswer = true;
                System.out.println(secondRiddleGuess + " is het woord dat we zochten!");
            } else {
                System.out.println(secondRiddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw");
                ;
            }
        }
// Derde while-loop tot juiste oplossing
        System.out.println("Over het algemeen gaat het tot nu toe best goed.");
        boolean thirdRiddleAnswer = false;
        while (thirdRiddleAnswer == false) {
            String thirdRiddleGuess = riddleInput.nextLine().toUpperCase();
            if (thirdRiddleGuess.equals(riddleSolutions[2])) {
                thirdRiddleAnswer = true;
                System.out.println(thirdRiddleGuess + " is het woord dat we zochten!");
            } else {
                System.out.println(thirdRiddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw");
                ;
            }
// Vierde while-loop tot juiste oplossing
            System.out.println("Na deze laatste zin zou het goed moeten zijn..");
            boolean fourthRiddleAnswer = false;
            while (fourthRiddleAnswer == false) {
                String fourthRiddleGuess = riddleInput.nextLine().toUpperCase();
                if (fourthRiddleGuess.equals(riddleSolutions[3])) {
                    fourthRiddleAnswer = true;
                    System.out.println(fourthRiddleGuess + " is het woord dat we zochten!");
                } else {
                    System.out.println(fourthRiddleGuess + " is niet het woord dat we zoeken, probeer het opnieuw");
                }

                System.out.println("Onthoud de antwoorden goed, er ontstaat een magisch veld op de muur in deze ruimte");

// Grid aanmaken
                String[] board = new String[21];

                for (int i = 0; i < 21 ; i++) {
                    board[i] = Integer.toString(i);
                }
                printBoard(board);
            }
        }
    }
    public static void printBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);

            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean isLastField = i == 20;

            if (isEndOfRow == false) {
                System.out.print(" | ");
            }
            if (isEndOfRow && !isLastField) {
                System.out.println("\n_____________");
            }
        }
    }
}


