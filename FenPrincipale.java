package TwinTinBots.ihm;
import TwinTinBots.metier.Joueur;
import TwinTinBots.metier.Pion;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FenPrincipale extends JFrame
{
	private MonPanel   monPanel;
	private Controleur ctrl;
	private int taille, tailleCalculee;
	private PanDroit panDroit;
	private ArrayList<Pion> pions;

	public FenPrincipale (Controleur ctrl)
	{
		this.monPanel = new MonPanel ( ctrl );
		this.ctrl = ctrl;
		this.taille = 76;
		this.tailleCalculee = 40;
		this.panDroit = new PanDroit(this.ctrl, this);
		this.pions = new ArrayList<Pion>();

		this.add (this.monPanel,  BorderLayout.CENTER);
		this.add (this.panDroit,  BorderLayout.EAST);
    	this.setSize    (1200,722);
    	//this.setLocation( 10, 10);
    	this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() { @Override public void windowClosing(WindowEvent e) { System.exit(0); } });
		this.setResizable(false);
		this.setVisible(true);

	}

	public void afficherJeu()
	{
		this.monPanel.revalidate();
		this.monPanel.repaint();
	}
}
