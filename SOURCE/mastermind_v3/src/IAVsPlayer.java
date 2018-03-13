/**
 * IAVsPlayer implémente l'Interface Strategy.
 * Correspond au contexte où le joueur fait
 * deviner au programme.
 * @author Fanny Lajeunesse
 * @version 1.0
 */
public class IAVsPlayer implements Strategy {

    /**
     * Instancie un objet Jeu
     * et appelle la méthode correspondant
     * au contexte.
     */
    public void doAction() {
        Jeu jeu = new Jeu();
        jeu.iaGuess();
    }
}
