import java.awt.*;
import javax.swing.*;
import java.awt.font.*;
import java.util.*;

public class Menu extends JFrame
{
	private PanelMenu panelAccueil;
	private NombreJoueurs panelDemandeJ;
	private NomsJoueurs panNomsJ;
	private int nbJoueurs;

	public Menu()
	{
		this.setSize(640,504);
		this.setLocationRelativeTo(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./Images/de20.png"));
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
		this.dispose();
		new Controleur(tabNoms);
	}

	public static void main (String[] a)
	{
		new Menu();
	}

}