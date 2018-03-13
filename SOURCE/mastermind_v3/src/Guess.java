import java.util.ArrayList;
import java.util.Scanner;
/**
 * Created by canel on 22/12/2017.
 */
public class Guess extends ArrayList<Integer> {

    public Guess(String guess) {
        for (int n=0; n<guess.length();n++) {
            int x = Integer.parseInt(guess.substring(n,n+1));
            this.add(x);
        }
    }

    public ArrayList<Integer> getGuess() {
        return this;
    }

}
