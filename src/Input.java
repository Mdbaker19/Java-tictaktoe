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

    public int row(){
        System.out.println("Pick row");
        String choice = getNext();
        try {
            int row = Integer.parseInt(choice);
            if(row <= 2 && row >= 0){
                return row;
            } else {
                return row();
            }
        } catch (Exception e){
            e.printStackTrace();
            return row();
        }
    }

    public int col(){
        System.out.println("Pick col");
        String choice = getNext();
        try {
            int col = Integer.parseInt(choice);
            if(col <= 2 && col >= 0){
                return col;
            } else {
                return col();
            }
        } catch (Exception e){
            e.printStackTrace();
            return col();
        }
    }

    public int[] turn(int row, int col){
        int[] play = new int[2];
        play[0] = row;
        play[1] = col;
        return play;
    }

}
