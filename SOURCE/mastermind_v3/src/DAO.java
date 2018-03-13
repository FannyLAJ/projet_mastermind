import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Modèle DAO.
 * Contient les méthodes abstraites implémentées
 * par les classes DAO.
 * @author Fanny Lajeunesse
 * @version 1.0
 */
public abstract class DAO<T> {
    /**
     * Ouvre une instance de connexion au SGBD.
     * @since 1.0
     */
    public Connection connect = MysqlConnection.getInstance();

    /**
     * Persiste un objet en BDD.
     * @param obj un objet
     */
    public abstract void Create(T obj);

    public abstract void Update();
    public abstract void Delete();

    /**
     * Retourne une liste contenant les enregistrements
     * récupérés dans la BDD.
     * @param param une propriété connue de l'objet
     * @return liste des propriétés d'un objet
     */
    public abstract ArrayList<String> findByStringParam(String param);

    /**
     * Retourne un objet construit à partir
     * de la BDD
     * @param param un propriété connue de l'objet
     * @return un objet
     */
    public abstract T getAll(String param);

    /**
     * Retourne sous forme de tableau l'ensemble des propriétés
     * afin d'être traitées ultérieurement.
     * Non fonctionnel. /!\
     * @param param une propriété connue de l'objet
     * @return une liste contenant l'intégralité des enregistrements
     * en BDD
     */
    //public abstract ArrayList<String> getAllAsArray(String param);

}
