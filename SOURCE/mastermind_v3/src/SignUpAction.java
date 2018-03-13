import java.util.ArrayList;

/**
 * Implémente Strategy.
 * SignUpAction correspond au contexte où l'utilisateur doit s'inscrire.
 * @author Fanny Lajeunesse
 * @version 1.0
 *
 */
public class SignUpAction implements Strategy {
    private Interface console;
    private Player player;
    private ArrayList<String> playerInfos = new ArrayList<>();

    public void doAction() {
        console = new Interface();

        String message = "Choisissez votre nom d'utilisateur :\n";
        console.displayMessage(message);
        playerInfos.add(console.getUserInput());
        message = "Choisissez votre mot de passe :\n";
        console.displayMessage(message);
        playerInfos.add(console.getUserInput());
        message = "Entrez votre prénom :\n";
        console.displayMessage(message);
        playerInfos.add(console.getUserInput());
        message = "Entrez votre nom de famille :\n";
        console.displayMessage(message);
        playerInfos.add(console.getUserInput());
        message = "Entrez votre adresse mail :\n";
        console.displayMessage(message);
        playerInfos.add(console.getUserInput());
        message = "Entrez votre date de naissance (jj/mm/yy) :\n";
        console.displayMessage(message);
        playerInfos.add(console.getUserInput());

        String pseudo = playerInfos.get(0);
        String mdp = playerInfos.get(1);
        String prenom = playerInfos.get(2);
        String nom = playerInfos.get(3);
        String mail = playerInfos.get(4);
        String date = playerInfos.get(5);

        player = new Player(pseudo, mdp, prenom, nom, mail, date);
        addPlayer(player);
        console.displayMessage("Bienvenue "+player.getNickname()+", et merci de vous être inscrit !\n");
        Context context = new Context(new LoginAction());
        context.executeStrategy();
    }

    private void addPlayer(Player player) {
        DAO<Player> playerDao = DAOFactory.getPlayerDao();
        playerDao.Create(player);
    }
}
