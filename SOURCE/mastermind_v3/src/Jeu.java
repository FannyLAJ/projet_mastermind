import java.util.ArrayList;
import java.util.Collections;
/**
 * @author Fanny Lajeunesse, Mathias Lafontan
 * @version 1.0
 * Classe Jeu génère et gère toutes les informations
 * nécessaires au bon déroulement d'une partie.
 */

public class Jeu {
    private Secret secret;
    private Interface console;
    private Guess guess;
    private int nbTours= 1;
    private ArrayList<String> result;
    private ArrayList<String> possibilities = new ArrayList<>();
    private Boolean win = false;

    public Jeu() {
        this.secret = new Secret();
        this.console = new Interface();
    }

    public void makeGuess() {
        while (this.nbTours < 11) {
            if (this.win.equals(false)) {
                this.guess = new Guess(this.inputGuess());
                this.compare(this.secret, this.guess);
                this.showResult();
                this.nbTours++;
            }
        }
    }
    public void iaGuess() {
        String combinaison;

        result = new ArrayList<>();

        console.displayMessage("Écrivez votre combinaison sur une feuille de papier =].");
        createPossibilities();
        while(nbTours < 11) {
            if (nbTours == 1) {
                console.displayMessage(possibilities.get(0));
                inputBpMp();
            }
            if (nbTours < 11) {
                sortPossibilities(possibilities, result, possibilities.get(0));
                combinaison = possibilities.get(0);
                console.displayMessage(combinaison);
                inputBpMp();
            }
            nbTours ++;
        }
    }

    public void inputBpMp() {
        String message;
        result.clear();
        message = "Entrez le nombre de chiffres bien placés :\n";
        console.displayMessage(message);
        result.add(console.getUserInput());
        message = "Entrez le nombre de chiffres mal placés :\n";
        console.displayMessage(message);
        result.add(console.getUserInput());
    }

    public ArrayList<String> compare(Secret secret, Guess guess) {
        this.result = new ArrayList<>();
        for (int i=0; i<5; i++) {
            if (secret.contains(guess.get(i))) {
                if (guess.get(i).equals(secret.get(i))) {
                    this.result.add("BP");
                }
                else {
                    this.result.add("MP");
                }
            }
        }
        return this.result;
    }

    public String inputGuess() {
        console.setMessage("Your guess!");
        console.displayMessage(console.getMessage());
        return console.getUserInput();
    }

    public Boolean showResult() {
        int bp = Collections.frequency(this.result, "BP");
        int mp = Collections.frequency(this.result, "MP");
        console.setMessage("BP : "+bp+"/MP : "+mp);
        console.displayMessage(console.getMessage());
        if (bp == 5) {
            return this.win = true;
        }
        else return this.win = false;
    }

    public void sortPossibilities(ArrayList<String> possibilities, ArrayList<String> result, String combinaison) {
        int bpR = Integer.parseInt(result.get(0));
        int mpR = Integer.parseInt(result.get(1));
        for (int i=0; i<possibilities.size();i++) {
            int[] rez = compareTwo(possibilities.get(i), combinaison);
            if(rez[0] != bpR || rez[1] != mpR ){
                possibilities.remove(i);
                System.out.println(rez[0]+"   "+rez[1]);
            }
        }
    }

    /* Compare toutes les combinaisons avec la précédente jouée par l'ordinateur,
       et garde uniquement celles qui ont les mêmes bp/mp que celle jouée */
    public static int[] compareTwo(String c, String b) {
        int bpCompare = 0;
        int mpCompare = 0;

        for (int i=0; i<5; i ++) {
            if (c.contains(b.substring(i, i+1))) {
                try {
                    if (b.substring(i, i+1).equals(c.substring(i, i+1))) {
                        bpCompare ++;
                    }
                    else {
                        mpCompare ++;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        int[] tabCompare = {bpCompare, mpCompare};
        //Return bp et mp
        return tabCompare ;
    }

    public void createPossibilities() {
        int a = 1;
        int b = 1;
        int c = 1;
        int d = 1;
        int e = 1;

        possibilities.add("11111");
        boolean isOver = false;

        while (isOver != true) {
            if (e<9) {
                e++;
                possibilities.add(a+""+b+""+c+""+d+""+e);
            } else if (d<9) {
                d++;
                e=1;
                possibilities.add(a+""+b+""+c+""+d+""+e);
            } else if (c<9) {
                c++;
                d=1;
                e=1;
                possibilities.add(a+""+b+""+c+""+d+""+e);
            } else if (b<9) {
                b++;
                c=1;
                d=1;
                e=1;
                possibilities.add(a+""+b+""+c+""+d+""+e);
            } else if (a<9) {
                a++;
                b=1;
                c=1;
                d=1;
                e=1;
                possibilities.add(a+""+b+""+c+""+d+""+e);
            } else {
                isOver = true;
            }
        }
    }
}