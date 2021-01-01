import java.util.ArrayList;
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

        if(!sc.gameMode()) {
            System.out.println("Two player mode");
            System.out.println("Player one's turn");
            do {
                int rowChoice = sc.row();
                int colChoice = sc.col();
                space();

                if (turns % 2 == 0) {
                    addPlay(board, rowChoice, colChoice, me, sc);
                    System.out.println("\033[0;39mPlayer two's turn");
                    turns++;
                } else {
                    addPlay(board, rowChoice, colChoice, ai, sc);
                    System.out.println("\033[0;39mPlayer one's turn");
                    turns++;
                }
                space();
                displayBoard(board);
                draw = drawCheck(turns);

                winner = findWinner(board);

                if (winner) {
                    System.out.println("\033[0;32mWinner!");
                } else if(draw){
                    System.out.println("\033[0;32mDraw!");
                }

            } while (!draw && !winner);
        } else {
            System.out.println("One player mode");
            do {
                space();

                if (turns % 2 == 0) {
                    int rowChoice = sc.row();
                    int colChoice = sc.col();
                    addPlay(board, rowChoice, colChoice, me, sc);
                    System.out.println("\033[0;39mComputer's turn");
                    turns++;
                } else {
                    aiPlay(board, ai);
                    System.out.println("\033[0;39mPlayer one's turn");
                    turns++;
                }
                space();
                displayBoard(board);
                draw = drawCheck(turns);

                winner = findWinner(board);

                if (winner) {
                    System.out.println("\033[0;32mWinner!");
                } else if(draw){
                    System.out.println("\033[0;32mDraw!");
                }

            } while (!draw && !winner);
        }

    }


    public static boolean aiPlay(char[][] board, Player player){
        ArrayList<String> possiblePlays = new ArrayList<>();
        ArrayList<Integer> actualPlay = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] == ' '){
                    int[] play = new int[2];
                    play[0] = i;
                    play[1] = j;
                    possiblePlays.add(Arrays.toString(play));

                    int play1 = i;
                    int play2 = j;
                    actualPlay.add(play1);
                    actualPlay.add(play2);

                }
            }
        }
        System.out.println(possiblePlays);
        int listValue = possiblePlays.size();
        int choice = (int)( Math.random() * listValue);
        System.out.println(possiblePlays.get(choice));

        int actualChoice = choice * 2;

        int row = actualPlay.get(actualChoice);
        int col = actualPlay.get(actualChoice + 1);

        board[row][col] = player.getPlay();
        return true;
    }


    public static void addPlay (char[][] board, int rowChoice, int colChoice, Player player, Input sc){
        if(board[rowChoice][colChoice] == ' ') {
            board[rowChoice][colChoice] = player.getPlay();
        } else {
            System.out.println("\033[0;31mInvalid play");
            addPlay(board, sc.row(), sc.col(), player, sc);
        }
    }

    public static void displayBoard(char[][] board){
        int counter = 0;
        System.out.printf("\033[0;32m            %-4s%d%-4s%d%-4s%d%n"," ", 0, " ", 1, " ", 2);
        System.out.printf("\033[0;35m%-13s|----|----|----|%n", " ");
        for(char[] row : board){
            System.out.printf("%-11s\033[0;32m%d\033[0;35m |", " ", counter);
            counter++;
            for(char spot : row){
                System.out.printf("\033[0;37m  %-1s\033[0;35m |", spot);
            }
            System.out.println();
            System.out.printf("%-13s|----|----|----|%n", " ");
        }
        System.out.println();
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
        } else if(matchingSet(board[0][2], board[1][1], board[2][0])){
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

    public static boolean drawCheck(int turns){
        return turns > 8;
    }


    public static void space(){
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("\033[0;38m ");
    }

}
