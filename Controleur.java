public class Controleur
{
	private Metier   metier;
	private FenPrincipale  ihm;

	public Controleur (String[] tabNom)
	{
		this.metier = new Metier(this, tabNom);
		this.ihm    = new FenPrincipale(this);
	}

	public Pion   getPion   () { return this.metier.getPion ();      }
	public String getFond   () { return "plateau2-4.jpg"; }
	public String getStringRobot() {return "grosRobotRouge.png";}

	public Metier getMetier(){return this.metier;}
}