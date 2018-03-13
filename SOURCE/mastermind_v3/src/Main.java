public class Main {
    public static void main(String[] args) {

		Interface console = new Interface();
		String message = "Bienvenue dans notre Mastermind !\n";
		message += "1 : Connexion \n2 : Inscription";
		console.setMessage(message);
		console.displayMessage(console.getMessage());
		String choice = console.getUserInput();

		switch (choice) {
			case "1":
				Context context1 = new Context(new LoginAction());
				context1.executeStrategy();

				break;
			case "2":
				Context context2 = new Context(new SignUpAction());
				context2.executeStrategy();
				break;
			default:
				System.out.println("Faites votre choix ! Taper 1 ou 2.");
		}
	}
}

