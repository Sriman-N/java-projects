import java.util.*;
public class wordle1 {
    public static String WORD;
    private static int count = 6;
    private static String guess;
    static ArrayList<char[]> myarrayList = new ArrayList<>();
    static ArrayList<String> guessArray = new ArrayList<>();
    private static String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static void main(String[] args) {
        WORD = setRandomWord();
        char[] alphabetInChar = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Scanner input = new Scanner(System.in);
        wordle1 w = new wordle1();
        ArrayList<Character> alphabetForSolution = new ArrayList<Character>();
        System.out.println("Welcome to Wordle!");
        System.out.println("Key for the game:");
        System.out.println("'-' means that the letter is not in the word");
        System.out.println("a letter that is lowercase, for example 'a', means that the word contains the letter but it is not in the right position");
        System.out.println("a letter that is uppercase, for example 'A', means that the word contains the letter and is in the right position");
        System.out.println("There will be a alphabet list that shows up after the guess, and it will tell you what letters you have not tried and will follow the key above.");

        System.out.println();
        System.out.println();

        for(int i = 0; i < alphabet.length; i++) {
            alphabetForSolution.add(alphabetInChar[i]);
        }
        do {
            System.out.println("Guess a 5 letter word: (You have " + count + " tries left!)");
            guess = input.nextLine().toUpperCase();
            if(guess.length() == 5) {
                char[] a = w.guessCheck(guess);
                guessArray.add(guess);
                myarrayList.add(a);

                for(char[] l: myarrayList) {
                    System.out.println(l);
                }
                System.out.println("The words you used is/are: ");
                for(String b: guessArray) {
                    System.out.print(b + ", ");
                }
                System.out.println();
            /*
            for(int i = 0; i < myarrayList.size(); i++) {
                char [] chArr = myarrayList.get(i);
                for (int k=0; k<chArr.length; k++)
                     System.out.println(chArr[k] + ",");
               // System.out.println();
            }*/

                //System.out.println(a);

                //changing the alphabet arraylist
                char[] guessInArrayInMain = convertToChar(guess.toLowerCase());

                for(int i = 0; i < 5; i++) {
                    if(a[i] == '-') {
                        for(int j = 0; j < alphabetForSolution.size(); j++) {
                            if(guessInArrayInMain[i] == alphabetForSolution.get(j)) {
                                alphabetForSolution.set(j, '-');
                            }
                        }
                    }
                    else {
                        for(int j = 0; j < alphabetInChar.length; j++) {
                            alphabetInChar[j] = Character.toUpperCase(alphabetInChar[j]);
                            if(a[i] == alphabetInChar[j]) {
                                alphabetForSolution.set(j, a[i]);
                            }
                        }
                    }
                }
                System.out.println("Alphabet: ");
                System.out.print("|");
                for(char z : alphabetForSolution) {
                    System.out.print(" " + z + " |");
                }
                System.out.println();
                System.out.println();
                count--;
                if(count > 0 && guess.equals(WORD)) {
                    System.out.println("Good Job!! You got it right!!!  The Word was: " + WORD);
                }
                else if(count == 0 && (!guess.equals(WORD))) {
                    System.out.println("Nice try. The word was " + WORD.toLowerCase());
                }
                else {
                    System.out.println("Try Again!");
                }
            }
            else if(guess.length() != 5) {
                System.out.println("the word you typed is smaller or larger than 5");
            }
        }
        while(count != 0 && (!guess.equals(WORD)));
    }

    //checks the code
    public char[] guessCheck(String guess)
    {
        char[] solution = new char[5];
        char[] guessInArray = convertToChar(guess);
        char[] actualWord = convertToChar(getWord());

        for(int i = 0; i<guess.length();i++) {
            //checks the word and see if it is in the right position and right letter
            if (guess.equals(getWord())) {
                return actualWord;
            }
        }

        //checks to see if the letter is in the right spot and right position
        for(int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < WORD.length(); j++) {
                if (i == j && guessInArray[i] == actualWord[j]) {
                    solution[i] = Character.toUpperCase(guessInArray[i]);
                    break;
                } else {
                    solution[i] = containing(actualWord, guessInArray[i]);
                }
            }
        }
        return solution;
    }

    public static char[] convertToChar(String guess) {
        char[] a = new char[5];
        for(int i = 0; i < guess.length(); i++)
        {
            a[i] = guess.charAt(i);
        }
        return a;
    }

    public static char containing(char[] charArray, char charInGuessArr) {
        for(char c : charArray) {

            if(c == charInGuessArr) {
                return Character.toLowerCase(c);
            }
        }
        return '-';
    }

    public String getWord() {
        return WORD;
    }

    public static String setRandomWord() {
        int random_int = (int)Math.floor(Math.random()*(102));
        String[] arr = {"WHICH", "THERE", "THEIR", "ABOUT", "WOULD", "THESE", "OTHER", "WORDS", "COULD", "WRITE", "FIRST",
                "WATER", "AFTER", "WHERE", "RIGHT", "THINK", "THREE", "YEARS", "PLACE", "SOUND", "GREAT", "AGAIN", "STILL",
                "EVERY", "SMALL", "FOUND", "THOSE", "NEVER", "UNDER", "MIGHT", "WHILE", "HOUSE", "WORLD", "BELOW", "ASKED",
                "GOING", "LARGE", "UNTIL", "ALONG", "SHALL", "BEING", "OFTEN", "EARTH", "BEGAN", "SINCE", "STUDY", "NIGHT",
                "LIGHT", "ABOVE", "PAPER", "PARTS", "YOUNG", "STORY", "POINT", "TIMES", "HEARD", "WHOLE", "WHITE", "GIVEN",
                "MEANS", "MUSIC", "MILES", "THING", "TODAY", "LATER", "USING", "MONEY", "LINES", "ORDER", "GROUP", "AMONG",
                "LEARN", "KNOWN", "SPACE", "TABLE", "EARLY", "TREES", "SHORT", "HANDS", "STATE", "BLACK", "SHOWN", "STOOD",
                "FRONT", "VOICE", "KINDS", "MAKES", "COMES", "CLOSE", "POWER", "LIVED", "VOWEL", "TAKEN", "BUILT", "HEART",
                "READY", "QUITE", "CLASS", "BRING", "ROUND"};
        return arr[random_int];
    }
}