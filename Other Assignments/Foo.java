public class Foo {
    public static int bar (int i) {
       if ( i <= 0 ) return 0;
       System.out.print(i+" ");
       return bar((i-1));
    }
    public static void main (String[] args) {
       bar(4);
    }
 }