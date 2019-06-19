public class Metier
{
	private Pion pion;
	private String[] tabString;
	private Controleur ctrl;
	private int indiceJoueurActif;
	private int nbTour;

	public Metier(Controleur c, String[] tabNom)
	{	
		this.pion = new Pion(0,0,0);
		this.ctrl = c;
		this.nbTour = 0;
		this.indiceJoueurActif = 0;
		this.tabString = new String[tabNom.length];
		for (int i=0; i<this.tabString.length; i++)this.tabString[i]=tabNom[i];
	}

	public Pion getPion ()
	{
		return this.pion;
	}
	public String getJoueurActif()
	{
		return this.tabString[this.indiceJoueurActif];
	}
	public int getNombreTour()
	{
		return this.nbTour;
	}

	public int getScoreJoueurActif()
	{
		//pour tester
		return this.indiceJoueurActif;
	}

	public int getNombreJoueurs(){return this.tabString.length;}

	public void passerTour()
	{
		this.indiceJoueurActif = (this.indiceJoueurActif+1)%this.tabString.length;
		if (this.indiceJoueurActif==0)
			this.nbTour++;	
	}
}