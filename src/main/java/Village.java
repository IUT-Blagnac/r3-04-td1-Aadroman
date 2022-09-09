import java.util.ArrayList;


public class Village {
	private String nom;
	//private Schtroumpf[] SchtroumpfsduVillage;
	private ArrayList<Schtroumpf> SchtroumpfsduVillage;
	private int nbSchtroumpfs;
	private int stockSalsepareille;
	
	public Village (String pfNomV, int pfStockSalsepareille, String[] pfNomsDesSchtroumpfs) {
		this.nom = pfNomV;
		this.stockSalsepareille = pfStockSalsepareille;
		this.SchtroumpfsduVillage=new ArrayList<Schtroumpf>();
		for(int i=0; i<pfNomsDesSchtroumpfs.length;i++) {
			this.SchtroumpfsduVillage.add(new Schtroumpf(pfNomsDesSchtroumpfs[i], (int)(Math.random()*150)));
			this.SchtroumpfsduVillage.get(i).setVillage(this);
			this.nbSchtroumpfs++;
		}
	}
		
	/**
	 * @return
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @return
	 */
	public int getNbSchtroumpfs() {
		return nbSchtroumpfs;
	}
	
	/**
	 * @return
	 */
	public int getStockSalsepareille() {
		return stockSalsepareille;
	}
	
	
	public void solstice_d_ete() {
		System.out.println("Ici au village "+getNom()+" c'est le jour du solstice d'�t�\n"
				+ "Chaque Schtroumpf f�te ce jour !");
		for(int i=0; i<nbSchtroumpfs;i++) {
			SchtroumpfsduVillage.get(i).sePresenter();
			SchtroumpfsduVillage.get(i).chanter();
		}
		System.out.println("Il y a aujourd'hui "+getNbSchtroumpfs()+" Schtroumpfs");
		
		int nbContent=0;
		for(int i=0; i<nbSchtroumpfs; i++) {
			if(SchtroumpfsduVillage.get(i).isContent()) {
				nbContent++;
			}
		}
		System.out.println("Il y a en ce jour de solstice d'�t� "+nbContent+" Schtroumpfs heureux");
	}
	
	/**
	 * @return
	 */
	public Schtroumpf chefduVillage() {
		Schtroumpf chef = this.SchtroumpfsduVillage.get(0);
		for( int i=1; i<this.nbSchtroumpfs; i++) {
			if(chef.getAge()<this.SchtroumpfsduVillage.get(i).getAge()) {
				chef = this.SchtroumpfsduVillage.get(i);
			}
		}
		return chef;
	}
	
	/** Envoie les Schtroumpfs "impairs" au travail.
     * 
     */
	public void envoyerAuTravail() {
		boolean vaautravail=false;
		for(int i=1; i<this.nbSchtroumpfs-1; i+=2) {
			if(!vaautravail && this.SchtroumpfsduVillage.get(i).isContent()) {
				this.SchtroumpfsduVillage.get(i).allerTravailler();	
				vaautravail=true;
			}
			else vaautravail=false;
		}
	}
	
	/** Fait chanter les Schtroumpfs heureux.
     * 
     */
	public void schtroumpfsHeureux() {
		for(int i=0; i<this.nbSchtroumpfs; i++) {
			if(this.SchtroumpfsduVillage.get(i).isContent()) {
				this.SchtroumpfsduVillage.get(i).sePresenter();
				this.SchtroumpfsduVillage.get(i).chanter();
			}
		}
	}
	
	/**
	 * @param pfNbSalsePareille
	 * @throws Exception
	 */
	public void modifierSalsePareille(int pfNbSalsePareille) throws Exception{
		if(this.stockSalsepareille + pfNbSalsePareille > 0) {
			this.stockSalsepareille += pfNbSalsePareille;
		}else {
			throw new Exception("Erreur : Le nombre de Salsepareille est n�gatif.");
		}
	}
	
	/**
	 * 
	 */
	public void dinnerTousEnsemble() {
		for (int i=0; i<this.getNbSchtroumpfs();i++) {
			try {
				this.SchtroumpfsduVillage.get(i).dinnerAuVillage();
			} catch (Exception e) {
				System.out.println("Mince ! Le village est � court de Salsepareille...\n");
				break;
			}
		}
	}
	
	/**
	 * @throws Exception
	 */
	public void envoyerCueillirSalsePareille() throws Exception{
		boolean vaautravail=false;
		for(int i=1; i<this.nbSchtroumpfs-1; i+=2) {
			if(!vaautravail && this.SchtroumpfsduVillage.get(i).isContent()) {
				this.SchtroumpfsduVillage.get(i).recolterSalsePareille();	
				vaautravail=true;
			}
			else vaautravail=false;
		}
	}
}
