import java.util.ArrayList;
import java.util.Random;

/**
 * Secret étend la Classe ArrayList.
 * Génère une combinaison à deviner.
 * @author Fanny Lajeunesse
 * @version 1.0
 */
public class Secret extends ArrayList<Integer> {

    /**
     * Génère une combinaison aléatoire
     * à 5 chiffres,
     * à l'aide de la méthode Random().
     * @since 1.0
     */
    public Secret() {
        int a = 0;
        while (a < 5) {
            int nb = new Random().nextInt(6)+1;
            if (!this.contains(nb)) {
                this.add(a, nb);
                a++;
            }
        }
    }

    /**
     * Fonction de retour.
     * @return Secret l'objet Secret
     * @since 1.0
     */
    public ArrayList<Integer> getSecret() {
        return this;
    }
}