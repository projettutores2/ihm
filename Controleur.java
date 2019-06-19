package TwinTinBots.ihm;
import TwinTinBots.metier.Metier;
import TwinTinBots.metier.Joueur;
import TwinTinBots.metier.Pion;
import TwinTinBots.metier.Ordre;
import TwinTinBots.metier.Robot;
import java.util.ArrayList;
public class Controleur
{
	public static boolean DEBUG ;

	private FenPrincipale ihm ;
	private Metier metier;

	public Controleur(String[] tabNoms)
	{
		/*if(debug.equals("debug"))*/ DEBUG = false;
		this.metier = new Metier(this, tabNoms);
		
		this.ihm    = new FenPrincipale(this);

		//boucle de jeu
		do
		{
			this.metier.jouer();
		}
		while(!this.metier.getEnd());
	}

	/*public static void main(String[] agrs)
	{
		new Controleur(agrs[0]);
	}*/

	//--------------------------------------------------------------
	//                          LIEN AFFICHAGE
	public void afficherAlgo(Joueur joueur)        { /*this.ihm.afficherAlgo(joueur);                       */}
	public void afficherStockJoueur(Joueur joueur) { /*this.ihm.afficherStockJoueur(joueur);                */}
	public int  demandeAction()                    { return 0;/*return this.ihm.demandeAction();            */}
	public int  choisirSlot()                      { return 0;/*return this.ihm.choisirSlot();              */}
	public int  choisirRobot()                     { return 0;/*return this.ihm.choisirRobot();             */}
	public int  choisirOrdreJoueur(Joueur joueur)  { return 0;/*return this.ihm.choisirOrdreJoueur(joueur); */}
	
	//--------------------------------------------------------------
	//                            LIEN SCANNER
	public int    nombreDeJoueur () { return 2 ;      }
	public String creeJoueur     () { return "teste ";}

	public void afficherJeu() { this.ihm.afficherJeu(); }

	//--------------------------------------------------------------
	//                             GET
	public FenPrincipale getIhm()    { return this.ihm ;  }
	public Metier        getMetier() { return this.metier;}

	public ArrayList<String> getStockJoueur(Joueur joueur)
	{
		ArrayList<String> tmp = new ArrayList<String>();
		for(Ordre ordre : joueur.getStockOrdres())
			tmp.add(ordre.toString());
		return tmp;
	}

	public ArrayList<Pion> getListePions()
	{
		ArrayList<Pion> tmp = new ArrayList<Pion>();
		for(Pion pion : this.metier.getListePions())
			tmp.add(pion);
		return tmp;
	}

	public Robot[] getRobotsCourants()
	{
		return this.metier.getRobotsCourants();
	}
}
