import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Created by canel on 20/02/2018.
 */
public class GameDao extends DAO<Game> {
    public void Create(Game game) {
        try {
            PreparedStatement preparedStatement = connect.prepareStatement("INSERT INTO Game (id_player, total_coups, gagne)" +
                    "VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, game.getPlayer().getId_player());
            preparedStatement.setInt(2, game.getNb_coups());
            preparedStatement.setBoolean(3, game.isGagne());

            preparedStatement.executeUpdate();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Update() {

    }
    public void Delete() {

    }
    public ArrayList<String> findByStringParam(String param) {
        ArrayList<String> toModify = new ArrayList<>();
        return toModify;
    }
    public Game getAll(String param) {


        return new Game();
    }
}
