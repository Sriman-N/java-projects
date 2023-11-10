public class test1 {
    public static void main(String[] args) {
        int[] ISBN = {0, 1, 4, 1, 4, 3, 9, 5, 1, 3};
        int sum = 0;

        for(int i = 0; i < ISBN.length-1; i++) {
            sum = (ISBN[i] * i) + sum;
        }

        System.out.println(sum);
    }
}