public class BusStop {
    public static void main(String[] args) {
        int i = 0;
        int last_num = Integer.parseInt(args[args.length-1]);
        int[] array = new int[args.length - 1];
        int location = 0;
        int counter = 0;

        //moving the string array args to the integer array array
        while(i < args.length - 1) {
            array[i] = Integer.parseInt(args[i]);
            i++;
        }

        int k = 0;

        while(k < array.length) {
            if(last_num == array[k]) {
                location = k + 1;
                counter++;
            }
            else if(last_num != array[k]) {
                counter += 0;
            }
            k++;
        }

        if(counter == 0) {
            System.out.println(1000);

        }
        else if(counter == 1) {
            System.out.println(location);
        }
        else if(counter >= 2) {
            int u = 0;
            while(u < array.length) {
                if(array[u] == last_num) {
                    System.out.println(u+1);
                    break;
                }
                u++;
            }
        }
        
    }
}
