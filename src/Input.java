import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private Scanner sc;

    public Input(){
        this.sc = new Scanner(System.in);
    }

    public String getNext(){
        return this.sc.next();
    }

    public boolean gameMode(){
        System.out.println("\033[0;38mPick a game mode, [1] player, [2] player");
        String mode = getNext();
        return Integer.parseInt(mode) == 1;
    }

    public int row(){
        System.out.println("\033[0;38mPick row");
        String choice = getNext();
        try {
            int row = Integer.parseInt(choice);
            if(row <= 2 && row >= 0){
                return row;
            } else {
                return row();
            }
        } catch (Exception e){
            String err = e.getMessage();
            System.out.println("Invalid input " + err);
            return row();
        }
    }

    public int col(){
        System.out.println("\033[0;38mPick col");
        String choice = getNext();
        try {
            int col = Integer.parseInt(choice);
            if(col <= 2 && col >= 0){
                return col;
            } else {
                return col();
            }
        } catch (Exception e){
            String err = e.getMessage();
            System.out.println("Invalid input " + err);
            return col();
        }
    }

}
