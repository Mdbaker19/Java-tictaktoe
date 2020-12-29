import java.util.Arrays;

public class Game {

    public static void main(String[] args) {

        Input sc = new Input();

        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};

        int rowChoice = sc.row();
        int colChoice = sc.col();

        int[] play = sc.turn(rowChoice, colChoice);

        board[play[0]][play[1]] = 'X';

        System.out.println("|----|----|----|");
        for(char[] row : board){
            System.out.print("|");
            for(char spot : row){
                System.out.printf("  %-2s|", spot);
            }
            System.out.println();
            System.out.println("|----|----|----|");
        }



    }

}
