import java.util.Scanner;

public class Wordle {
    private String secretWord;
    private int attempts;

    public Wordle(String secretWord, int attempts) {
        this.secretWord = secretWord;
        this.attempts = attempts;
    }

    public void play() {
        Scanner read = new Scanner(System.in);
        int remainingAttempts = attempts;


        while(remainingAttempts > 0) {
            System.out.println("Verbleibende Versuche: " + remainingAttempts);
            System.out.println("Das gesuchte Wort hat eine Länge von " + secretWord.length() + " Buchstaben.");
            System.out.print("Bitte geben Sie Ihre Vermutung ein: ");
            String guess = read.nextLine();

            if(guess.length() != secretWord.length()) {
                System.out.println("Ungültige Eingabe! Bitte geben Sie ein Wort ein welches so lange ist wie das gesuchte Wort");
                continue;
            }
            int correctChars = 0;
            int correctPositions = 0;
            // String positions = "";


            for (int i = 0; i < secretWord.length(); i++) {
                char c = guess.charAt(i);
                if(c == secretWord.charAt(i)) {
                    correctPositions++;
                 //   positions = positions + " " + guess.indexOf(i);
                }
                else if(secretWord.indexOf(c) >= 0) {
                    correctChars++;
                }
            }

            if(correctPositions == secretWord.length()) {
                System.out.println("Gratulation! Sie haben das korrekte Wort erraten: " + secretWord);
                break;
            }
            else {

                System.out.println("Korrekte Positionen: " + correctPositions);
                // System.out.println("Die richten Buchstaben befinden sich an folgenden Positionen: " + positions);
                System.out.println("Zusätzlich richtig geratene Buchstaben: " + correctChars);
                remainingAttempts--;
            }
        }

        if(remainingAttempts == 0) {
            System.out.println("Sorry, Sie haben alle Ihre Versuche verbraucht. Das korrekte Wort wäre gewesen: " + secretWord);
        }
    }
}
