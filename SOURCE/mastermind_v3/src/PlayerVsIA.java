/**
 * PlayerVsIA implémente l'Interface Strategy.
 * Correspond au contexte où le programme fait
 * deviner au joueur.
 * @author Fanny Lajeunesse
 * @version 1.0
 */
public class PlayerVsIA implements Strategy {

    /**
     * Instancie un objet Jeu
     * et appelle la méthode correspondant
     * au contexte
     * @since 1.0
     */
    public void doAction() {
        Jeu jeu = new Jeu();
        jeu.makeGuess();
    }
}
