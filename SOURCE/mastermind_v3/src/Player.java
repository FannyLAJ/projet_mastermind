import java.util.ArrayList;
import java.util.Date;

/**
 * POJO du joueur.
 * @author Fanny Lajeunesse
 * @version 1.0
 */
public class Player {
    private Integer id_player;
    private String nickname;
    private String mdp;
    private String firstname;
    private String lastname;
    private String mail;
    private String birthday;
    private ArrayList<Game> listGame = new ArrayList<>();

    /**
     * Constructeur vide
     */
    Player() { }

    /**
     * Constructeur avec paramètres
     * @param nickname le pseudo
     * @param mdp le mot de passe
     * @param firstname le prénom
     * @param lastname le nom de famille
     * @param mail l'adresse mail
     * @param birthday la date d'anniversaire
     */
    Player(String nickname, String mdp, String firstname, String lastname, String mail, String birthday) {
        this.nickname = nickname;
        this.mdp = mdp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.birthday = birthday;
    }

    /**
     * Getter
     * @return id_player l'id du joueur
     */
    public int getId_player() { return id_player; }

    /**
     * Setter
     * @param id l'id du joueur
     */
    public void setId_player(int id) {
        this.id_player = id;
    }

    /**
     * getter
     * @return mdp mot de passe du joueur
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * setter
     * @param mdp mot du passe du joueur
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * getter
     * @return firstname prénom du joueur
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * setter
     * @param firstname prénom du joueur
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * getter
     * @return lastname nom du joueur
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * setter
     * @param lastname nom du joueur
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * getter
     * @return mail adresse mail du joueur
     */
    public String getMail() {
        return mail;
    }

    /**
     * setter
     * @param mail mail du joueur
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * getter
     * @return birthday la date de naissance
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * setter
     * @param birthday date de naissance
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * getter
     * @return nickname pseudo du joueur
     */
    public String getNickname() {
        return this.nickname;
    }

    /**
     * setter
     * @param nickname pseudo du joueur
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Retourne la liste des parties jouées par l'utilisateur
     * @return listGame
     */
    public ArrayList<Game> getListGame() {
        return this.listGame;
    }

    /**
     * Modifie la valeur de listGame
     * @param listGame liste des parties
     */
    public void setListGame(ArrayList<Game> listGame) {
        this.listGame = listGame;
    }

}
