public class test {
    public static void main(String[] args) {
        int[] isbn = {0, 7, 4, 3, 2, 7, 3, 5, 6, 0};
        int sumOfProducts = 0;

        for(int i = 0; i < isbn.length-1; i++) {
            sumOfProducts = (isbn[i] * (10-i)) + sumOfProducts;
        }

        //step 2
        int rem = sumOfProducts % 11;

        //step 3
        int diff = 11 - rem;

        //step 4
        int checkDigit = diff % 11;

        if(checkDigit != isbn[isbn.length-1]) {
            isbn[isbn.length-1] = checkDigit;
        }

        for(int i = 0; i < isbn.length; i++) {
            System.out.print(isbn[i]);
        }
        
    }
}