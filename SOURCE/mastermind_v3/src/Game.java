/**
 * Created by canel on 09/02/2018.
 */
public class Game {
    private int id_game;
    private Player player;
    private int nb_coups;
    private boolean gagne;

    public Game() { }

    public Game(int id_game, Player player, int nb_coups, boolean gagne) {
        this.id_game = id_game;
        this.player = player;
        this.nb_coups = nb_coups;
        this.gagne = gagne;
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getNb_coups() {
        return nb_coups;
    }

    public void setNb_coups(int nb_coups) {
        this.nb_coups = nb_coups;
    }

    public boolean isGagne() {
        return gagne;
    }

    public void setGagne(boolean gagne) {
        this.gagne = gagne;
    }
}
