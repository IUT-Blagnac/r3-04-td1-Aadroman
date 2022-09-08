public class Schtroumpf {
	private String nom;
	private int age;
	private boolean content;
	private Village village;
	
	public Schtroumpf(String pfNom, int pfAge) {
		this.nom = pfNom;
		this.age = pfAge;
		this.content = true;
		this.village = null;
	}
	
	public Schtroumpf(String pfNom, int pfAge, Village pfVillage) {
		this.nom = pfNom;
		this.age = pfAge;
		this.content = true;
		this.village = pfVillage;
	}
	
	/*
	 * la methode getNom retourne le nom du schtroumpf
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	
	/*
	 * la methode getAge retourne l'age du schtroumpf
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	
	/*la methode isContent retourne l'�tat de joie du schtroumpf
	 * @return content
	 * 
	 */
	public boolean isContent() {
		return content;
	}
	
	/*
	 * Affiche un string servant de presentation du schtroumpf selon si il est content ou pas
	 * @return presentation
	 */
	public String toString() {
		String presentation ="";
		if(content) {
			if(village==null) {
				presentation="Je suis "+getNom()+" j'ai "+getAge()+" ans et je suis content\n"+
				"Je suis un ermite, je n'ai pas de village ";
			}else {
				presentation="Je suis "+getNom()+" j'ai "+getAge()+" ans et je suis content\n"+
				"Je viens du village "+village.getNom();
			}
		}else{
			if(village==null) {
				presentation="Je suis "+getNom()+" j'ai "+getAge()+" ans et je ne suis pas content\n"+
				"Je suis un ermite, je n'ai pas de village ";
			}else {
				presentation="Je suis "+getNom()+" j'ai "+getAge()+" ans et je ne suis pas content\n"+
				"Je viens du village "+village.getNom();
			}
		}
		return presentation;
	}
	
	/*
	 * Affiche la methode toString servant de presentation du schtroumpf
	 */
	public void sePresenter() {
		System.out.println(toString());
	}
	
	/*
	 * Afficher un chant si le schtroumpf est content sinon renvoie gloups
	 * @return String
	 */
	public String leChant() {
		if(content) {
			return("la, la, la Schtroumpf la, la");
		}else{
			return("gloups");
		}
	}
	
	/*
	 * Imprime la methode leChant()
	 */
	public void chanter() {
		System.out.println(leChant());
	}
	
	/*
	 * Fait avancer l'age d'un an du Schtroumpf pour son anniversaire
	 */
	public void anniversaire() {
		this.age++;
	}
	
	
	/**
	 * M�thode permettant de donner � manger au schtroumpf -> impacte leur etat "content"
	 * @param pfQte
	 */
	public void manger(int pfQte) {
		if (pfQte < 0) {
			this.content = false;
			System.out.println(nom+" n'est plus content");
		}else {
			this.content = true;
			System.out.println(nom+" est tr�s content");
		}
	}
	
	/*
	 * M�thode envoyant les shctroumpf au travail -> impacte leur etat "content"
	 */
	public void allerTravailler() {
		this.content=false;
		System.out.println(nom+" n'est pas content d'aller travailler");
	}
	
	
	/**
	 * @return
	 */
	public Village getVillage() {
		return village;
	}
	
	/**
	 * 
	 * @param pfVillage
	 */
	public void setVillage(Village pfVillage) {
		this.village=pfVillage;
	}
	
	public void recolterSalsePareille() throws Exception{
		this.allerTravailler();
		this.village.modifierSalsePareille(5);
	}
	
	public void dinnerAuVillage() throws Exception{
		this.village.modifierSalsePareille(-3);
		this.content=true;
	}
}
