import java.util.ArrayList;

/**
 * Affiche les données du profil de l'utilisateur.
 * Fait appel à la méthode readAll de PlayerDao pour récupérer
 * les informations du joueur.
 * Celles-ci sont ensuite affichées via une instance d'Interface.
 *
 * @author Fanny Lajeunesse
 * @version 1.0
 */
public class ShowPlayerInfoAction implements Strategy {
    private Player player;
    private ArrayList<String> playerInfos = new ArrayList<>();

    public ShowPlayerInfoAction(Player player) {
        this.player = player;
    }
    public void doAction() {

    }

    private void getAllInformations(Player player) {
        DAO<Player> playerDao = DAOFactory.getPlayerDao();
        //playerInfos = playerDao.getAllAsArray(player.getNickname());
    }

    private void display(ArrayList<String> playerInfos) {
        for (int i=0;i<playerInfos.size();i++) {

        }
    }
}
