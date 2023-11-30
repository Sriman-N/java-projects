public class StaircaseBuilder {
    public static void main(String[] args) {
        int d = Integer.parseInt(args[0]);
        int bricks = Integer.parseInt(args[1]);
        char[][] staircase = new char[d][d];

        //setting some staircases as blank
        for(int i = 0; i < d; i++) {
            for(int j = 0; j < d-i-1; j++) {
                staircase[i][j] = ' ';
            }
        }

        //making the staircase with X's
        for(int j = 0; j < d; j++) {
            for(int i = d-1; i >= 0; i--) {
                if(staircase[i][j] != ' ' && bricks != 0) {
                    staircase[i][j] = 'X';
                    bricks--;
                }
            }
        }

        //printing the staircase
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                if (staircase[i][j] == 'X') {
                    System.out.print("X");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("Bricks remaining: " + bricks);
    }
}