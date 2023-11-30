package Assignment8.Assignment8;

public class test2 {
    public static void main(String[] args) {
        String sequence = "AGATAGATAGATAGATAAACCCAATGAATGAATGGGGGGTATCTATCTATCTATC";
        System.out.println(sequence.length());
        String STR = "ATsajfasdjf;lakskdfjlkasdfj;lakskdjf;lkasdjf;lksdjf;lkasjdf;la";


        int numOfRepeats = 0;
        int j = 0;

        while(j < sequence.length()-STR.length()+1) {
            if(sequence.substring(j, j+STR.length()).equals(STR.substring(0))) {
                numOfRepeats++;
                j+=STR.length();
            } else {
                j++;
            }
        }

        System.out.println(numOfRepeats);


        numOfRepeats = 0;


        int i = 0;
        while(i < sequence.length()-STR.length()+1) {
            if(sequence.substring(i, i+1).equals(STR.substring(0, 1))) {
                if(sequence.substring(i+1, i+STR.length()).equals(STR.substring(1))) {
                    numOfRepeats++;
                    i+=STR.length();
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }



        System.out.println(numOfRepeats);
    }
}
