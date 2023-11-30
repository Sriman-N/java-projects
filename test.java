public class test {
    public static void main(String[] args) {


        String sequence = "AGATAGATAGATAGATAAACCCAATGAATGAATGGGGGGTATCTATCTATCTATC";
        System.out.println(sequence.length());
        String STR = "TATC";
        int numOfRepeats = 0;


        for(int i = 0; i < sequence.length()-4; i++) {
            if(sequence.substring(i, i+1).equals(STR.substring(0, 1))) {
                if(sequence.substring(i+1, i+STR.length()).equals(STR.substring(1))) {
                    numOfRepeats++;
                    i+=STR.length();
                }
            }   
        } 

        System.out.println(numOfRepeats);

        int numOfRepeats1 = 0;

        for(int i = 0; i < sequence.length()-STR.length(); i++) {
            if(sequence.substring(i, i+STR.length()).equals(STR.substring(0))) {
                numOfRepeats1++;
                i+=STR.length();
            }
        } 

        System.out.println(numOfRepeats1);

        int i = 0;
        int numOfRepeats2 = 0;
        while(i < sequence.length()-STR.length()) {
            if(sequence.substring(i, i+1).equals(STR.substring(0, 1))) {
                if(sequence.substring(i+1, i+STR.length()).equals(STR.substring(1))) {
                    numOfRepeats2++;
                    i+=STR.length()-1;
                }
            } else { 
                i++;
            }
            i++;
        } 

        System.out.println(numOfRepeats2);
    }
}

