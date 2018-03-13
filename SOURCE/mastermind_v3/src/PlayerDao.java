import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Interface de communication entre le SGBD et le programme
 * spécifique à l'objet Player.
 * @author Fanny Lajeunesse
 * @version 1.0
 */
public class PlayerDao extends DAO<Player> {

    /**
     * Persistance d'un objet Player passé en paramètre.
     * @param player objet Player à persister.
     */
    public void Create(Player player) {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Player (nickname,mdp,firstname,lastname,mail,birthday)" +
                    "VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, player.getNickname());
            preparedStatement.setString(2, player.getMdp());
            preparedStatement.setString(3, player.getFirstname());
            preparedStatement.setString(4, player.getLastname());
            preparedStatement.setString(5, player.getMail());
            preparedStatement.setString(6, player.getBirthday());

            preparedStatement.executeUpdate();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupère le pseudo et le mdp correspondant à un
     * pseudo passé en paramètre.
     * @param nickname pseudo entré par l'utilisateur lors de la tentative
     *                 d'authentification
     * @return liste propriétés
     * @see LoginAction
     */
    public ArrayList<String> findByStringParam(String nickname) {
        ArrayList<String> playerInfos = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT nickname, mdp FROM Player WHERE nickname = ?;");
            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                playerInfos.add(resultSet.getString("nickname"));
                playerInfos.add(resultSet.getString("mdp"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerInfos;
    }

    /**
     * Récupère tous les champs d'un enregistrement Player
     * @param nickname le pseudo de l'utilisateur
     * @return Player
     */
    public Player getAll(String nickname) {
        Player player = new Player();

        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM Player WHERE nickname = ?;");
            preparedStatement.setString(1, nickname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                player.setId_player(Integer.parseInt(resultSet.getString("id_player")));
                player.setNickname(resultSet.getString("nickname"));
                player.setMdp(resultSet.getString("mdp"));
                player.setFirstname(resultSet.getString("firstname"));
                player.setLastname(resultSet.getString("lastname"));
                player.setMail(resultSet.getString("mail"));
                player.setBirthday(resultSet.getString("birthday"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return player;
    }

    public ArrayList<String> getAllAsArray(String param) {
        ArrayList<String> playerInfos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT * FROM Player WHERE nickname = ?;");
            preparedStatement.setString(1, param);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                playerInfos.add(resultSet.getString("nickname"));
                playerInfos.add(resultSet.getString("mdp"));
                playerInfos.add(resultSet.getString("firstname"));
                playerInfos.add(resultSet.getString("lastname"));
                playerInfos.add(resultSet.getString("mail"));
                playerInfos.add(resultSet.getString("birthday"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return playerInfos;
    }

    /**
     * Permet la modification d'un enregistrement en BDD
     * /!\ Non fonctionnel
     */
    public void Update() {

    }

    /**
     * Fonction de suppression d'un enregistrement
     * /!\ Non fonctionnel
     */
    public void Delete() {

    }

}
