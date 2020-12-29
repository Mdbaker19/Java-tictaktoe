import java.util.Arrays;

public class Game {

    public static void main(String[] args) {

        Input sc = new Input();
        Player me = new Player('X');
        Player ai = new Player('O');

        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};
        displayBoard(board);


        boolean draw = false;
        boolean winner = false;
        int turns = 0;
        do{

            int rowChoice = sc.row();
            int colChoice = sc.col();
            space();

            if(turns % 2 == 0) {
                addPlay(board, rowChoice, colChoice, me);
                turns++;
            } else {
                addPlay(board, rowChoice, colChoice, ai);
                turns++;
            }
            space();
            displayBoard(board);
            if(turns > 8){
                draw = true;
                System.out.println("Draw!!!");
            }

            winner = findWinner(board);

            if(winner){
                System.out.println("Winner");
            }

        }while(!draw && !winner);


    }

    public static void addPlay (char[][] board, int rowChoice, int colChoice, Player player){
        board[rowChoice][colChoice] = player.getPlay();
    }

    public static void displayBoard(char[][] board){
        int counter = 0;
        System.out.printf("%-4s%d%-4s%d%-4s%d%n"," ", 0, " ", 1, " ", 2);
        System.out.println("  |----|----|----|");
        for(char[] row : board){
            System.out.printf("%d |", counter);
            counter++;
            for(char spot : row){
                System.out.printf("  %-1s |", spot);
            }
            System.out.println();
            System.out.println("  |----|----|----|");
        }
    }

    public static boolean findWinner(char[][] board){
        boolean winnerFound = false;

        if(matchingSet(board[0][0], board[0][1], board[0][2])){
            winnerFound = true;
        } else if(matchingSet(board[0][0], board[1][0], board[2][0])){
            winnerFound = true;
        } else if(matchingSet(board[1][0], board[1][1], board[1][2])){
            winnerFound = true;
        } else if(matchingSet(board[2][0], board[2][1], board[2][2])){
            winnerFound = true;
        } else if(matchingSet(board[0][0], board[1][1], board[2][2])){
            winnerFound = true;
        } else if(matchingSet(board[2][0], board[1][1], board[0][0])){
            winnerFound = true;
        } else if(matchingSet(board[0][1], board[1][1], board[2][1])){
            winnerFound = true;
        } else if(matchingSet(board[0][2], board[1][2], board[2][2])){
            winnerFound = true;
        }

        return winnerFound;
    }

    public static boolean matchingSet(char a, char b, char c){
        return ((a == b && b == c) && (a != ' ' && b != ' ' && c != ' '));
    }

    public static void space(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
    }

}
