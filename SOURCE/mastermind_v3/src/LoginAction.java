import java.util.ArrayList;

/**
 * Contexte d'authentification.
 */
public class LoginAction implements Strategy {
    private Interface console = new Interface();
    private Player player;
    private ArrayList<String> playerInfos = new ArrayList<>();
    private boolean success = false;

    /**
     * Actions à exécuter dans le cadre de ce contexte.
     *
     */
    public void doAction() {
        String message = "Veuillez entrer votre nom d'utilisateur :";
        console.displayMessage(message);
        playerInfos.add(console.getUserInput());
        message = "Veuillez entrer votre mot de passe :";
        console.displayMessage(message);
        playerInfos.add(console.getUserInput());

        checkNicknamePassword(playerInfos);
        if (success) {
            message = "1 : Devinez !\n" +
                    "2 : Faites deviner !" +
                    "\n3 : Accéder à votre profil";
		    console.setMessage(message);
		    console.displayMessage(message);
            String choice = console.getUserInput();
            switch (choice) {
                case "1":
                    Context context1 = new Context(new PlayerVsIA());
                    context1.executeStrategy();

                    break;
                case "2":
                    Context context2 = new Context(new IAVsPlayer());
                    context2.executeStrategy();
                    break;
                case "3":
                    Context context3 = new Context(new ShowPlayerInfoAction(player));
                    context3.executeStrategy();
                    break;
                default:
                    System.out.println("Faites votre choix ! Taper 1 ou 2.");
            }
        }
    }

    private void checkNicknamePassword(ArrayList<String> playerInfos) {
        DAO<Player> playerDao = DAOFactory.getPlayerDao();
        ArrayList<String> loginInfo = playerDao.findByStringParam(playerInfos.get(0));
        String trueLogin = loginInfo.get(0);
        String tryLogin = playerInfos.get(0);
        String trueMdp = loginInfo.get(1);
        String tryMdp = playerInfos.get(1);
        if (trueLogin.equals(tryLogin) && trueMdp.equals(tryMdp)) {
            this.player = playerDao.getAll(tryLogin);
            this.success = true;
            console.displayMessage("Vous êtes désormais connecté, "+player.getNickname());
        }
        else {
            console.displayMessage("Erreur lors de la connexion =/");
        }
    }
}