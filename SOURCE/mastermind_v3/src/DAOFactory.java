/**
 * Created by canel on 20/02/2018.
 */
public class DAOFactory {
    public static DAO<Player> getPlayerDao() {
        return new PlayerDao();
    }
    public static DAO<Game> getGameDao() {
        return new GameDao();
    }
}
