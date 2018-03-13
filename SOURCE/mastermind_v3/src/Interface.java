/**
 * Created by canel on 22/12/2017.
 */
import java.util.*;

public class Interface {
    private String message;
    public Interface() {

    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
    public void displayMessage(String message) {
        System.out.println(message);
    }
    public String getUserInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        return input;
    }
}
