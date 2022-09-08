public class MainSchtroumpf {

	public static void main (String[] argv) {
		
		//cr�ation du schtroumpf grognon
		Schtroumpf grognon;
		grognon =  new Schtroumpf("grognon", 135);
		
		//utilisation des methodes sur grognon
		grognon.sePresenter();
		grognon.chanter();
		grognon.allerTravailler();
		grognon.sePresenter();
		grognon.manger(10);
		grognon.sePresenter();
		grognon.anniversaire();
		grognon.sePresenter();
		
	}

}
