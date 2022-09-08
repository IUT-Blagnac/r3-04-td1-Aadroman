public class MainVillage {

	public static void main (String[] argv) {
		
		//creation tableaux de noms des schtroumpfs du village 
		String[] nomsSchtroumpfs = {
		        "Grand Schtroumpf", "Schtroumpf courant (et pas ordinaire)", "Schtroumpf ordinaire (et pas courant)", "Schtroumpf moralisateur � lunettes",
		        "Schtroumpf boudeur", "Schtroumpf volant", "Schtroumpf �tonn�", "Schtroumpf acrobate", "Schtroumpf paresseux"};
		
		//creation du village
		Village lostland = new Village("lostland", 100, nomsSchtroumpfs);
		
		lostland.solstice_d_ete();	
		System.out.println("\n");
		
		System.out.println("Bienvenue au village "+lostland.getNom()+" je me présente je suis le chef du village :");
		lostland.chefduVillage().sePresenter();
		System.out.println("\n");
		
		lostland.envoyerAuTravail();
		lostland.schtroumpfsHeureux();
		System.out.println("\n");
		
		try {
			lostland.envoyerCueillirSalsePareille();
		} catch (Exception e) {
			e.printStackTrace();
		}
		lostland.solstice_d_ete();
		System.out.println("\n");
		
		lostland.dinnerTousEnsemble();
		lostland.solstice_d_ete();
	}

}
