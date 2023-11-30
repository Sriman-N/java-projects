import java.util.*;

public class hangman {
    
    public static String WORD;
    public static char[] correct_letter;
    public static ArrayList<Character> wrong_letter = new ArrayList<Character>();
    public static int hangman_drawing;
    public static int y;
    public static void main(String[] args) {
        //Actual Word
        WORD = randomWord();
        System.out.println("The length of the word is: " + WORD.length());
        correct_letter = new char[WORD.length()];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < WORD.length(); i++) {
            correct_letter[i] = '_';
        }
        //Guess - letter

        do {
            y = 0;
            System.out.println("Type a guess");
            String guess = input.nextLine();
            checking(word_to_char_array(WORD), word_to_char_array(guess), guess);
            for(int j = 0; j < correct_letter.length; j++) {
                if(correct_letter[j] == '_') {
                   y++; 
                }
            }
        } while(hangman_drawing != 7 || y == 0);
    }

    private static int checking(char[] word, char[] guess, String guessWord) {
        int drawing = 0;
        int abc = 0;
        for(int i = 0; i < word.length; i++) {
            for(int j = 0; j < 1; j++) {
                if(word[i] == guess[j]) {
                    abc++;
                    correct_letter[i] = guess[j];
                }
                else {
                    abc+=0;
                }
            }
        }
        if(abc != 0) {
            System.out.println("Letter is in word.");
            if(hangman_drawing == 0) {
                System.out.println("    ----------|");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 1) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 2) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |         |");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 3) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing ==4) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|/");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 5) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|/");
                System.out.println("    |         |");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 6) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|/");
                System.out.println("    |         |");
                System.out.println("    |        / ");
                System.out.println("    |          ");
                System.out.println("    |          ");
            } else if(hangman_drawing == 7) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|/");
                System.out.println("    |         |");
                System.out.println("    |        / \\");
                System.out.println("    |          ");
                System.out.println("    |          ");
            }
        } else {
            System.out.println("Letter is not in word.");
            wrong_letter.add(guessWord.charAt(0));
            hangman_drawing = wrong_letter.size();
            if(hangman_drawing == 0) {
                System.out.println("    ----------|");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 1) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 2) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |         |");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 3) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing ==4) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|/");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 5) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|/");
                System.out.println("    |         |");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("    |          ");
                System.out.println("----------");
            } else if(hangman_drawing == 6) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|/");
                System.out.println("    |         |");
                System.out.println("    |        / ");
                System.out.println("    |          ");
                System.out.println("    |          ");
            } else if(hangman_drawing == 7) {
                System.out.println("    ----------|");
                System.out.println("    |         O");
                System.out.println("    |        \\|/");
                System.out.println("    |         |");
                System.out.println("    |        / \\");
                System.out.println("    |          ");
                System.out.println("    |          ");
            }
        } 
        for(char d: correct_letter) {
            System.out.print(d);
        }
        System.out.println();
        System.out.println();
        System.out.print("Letters used that are not in the word: ");
        for(char e: wrong_letter) {
            System.out.print(e + ", ");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        return drawing;
    }

    private static String randomWord() {
        int random_int = (int) (Math.floor(Math.random()*(101)));
        String[] wordArray = {"checking", "abruptly", "absurd", "abyss", "affix", "avenue", "bagpipes",
                             "bayou", "banjo", "beekeeper", "bikini", "blitz", "blizzard", "boggle", "bookworm", "boxcar", "boxful", 
                             "buckaroo", "buffalo", "buffoon", "buxom", "buzzard", "buzzing", "buzzwords", "caliph", "cobweb", 
                             "cockiness", "embezzle", "crypt", "cycle", "dwarves", "equip", "espionage", "exodus", "faking", 
                             "fixable", "fjord", "flyby", "glyph", "gossip", "zigzag", "zephyr", "zilch", "zombie", "onyx", 
                             "ovary", "nymph", "pajama", "pixel", "pizazz", "pneumonia", "psyche", "puppy", "quartz", "queue", 
                             "quips", "quiz", "quizzes", "quorum", "rhythm", "rickshaw", "scratch", "shiv", "snazzy", "sphinx", 
                             "staff", "strength", "jinx", "jigsaw", "jelly", "joking", "subway", "swivel", "syndrome", "topaz", 
                             "syndrome", "thumbscrew", "transcript", "transplant", "unknown", "unworthy", "vaporize", "unzip", 
                             "twelfth", "vixen", "voodoo", "waltz", "wavy", "waxy"};
        return wordArray[random_int];
    }

    private static char[] word_to_char_array(String word) {
        char[] letter_words = new char[word.length()];
        ArrayList<Character> c = new ArrayList<Character>(); 
        for(int i = 0; i < word.length(); i++) {
            c.add(word.charAt(i));
        }
        for(int i = 0; i < word.length(); i++) {
            letter_words[i] = c.get(i); 
        }
        return letter_words;
    }
    
}