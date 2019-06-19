package TwinTinBots.ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.font.*;
import java.util.*;

public class Launcher extends JFrame
{
	private boolean lancerP = false;
	private PanelMenu panelAccueil;
	private NombreJoueurs panelDemandeJ;
	private NomsJoueurs panNomsJ;
	private int nbJoueurs;
	private String[] tabNoms;

	public Launcher()
	{
		this.setSize(640,504);
		this.setLocationRelativeTo(null);
		this.panelAccueil  = new PanelMenu(this);
		this.panelDemandeJ = new NombreJoueurs(this);
		this.setContentPane(this.panelAccueil);	

		this.setVisible(true);

		//initialisation nbJ
		this.nbJoueurs = 0;
	}

	public void addPanDemandeJ()
	{
		this.panelDemandeJ.setVisible(true);
	}

	public void setNbJ(int i)
	{
		this.nbJoueurs=i;
		this.panNomsJ = new NomsJoueurs(this.nbJoueurs,this);
	}

	public void lancerPartie(String[] tabNoms)
	{
		this.tabNoms = tabNoms;
		this.lancerP = true;
		this.dispose();
		//new Controleur(tabNoms);
	}

	public static void main (String[] a)
	{
		Launcher launcher = new Launcher();
		while(!launcher.lancerP)
		{
			try{Thread.sleep(500);}
			catch(Exception e){}
			System.out.print("");
		}
		new Controleur(launcher.tabNoms);
	}

}