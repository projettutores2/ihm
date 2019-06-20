package TwinTinBots.ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class AffichageAlgo extends JDialog
{
	private Controleur ctrl;
	private ArrayList<Robot> lstRobots;

	private JScrollPane scrollPane;
	private ArrayList<PanAlgo> lstPAlgo;

	private FenPrincipale fenP;

	public AffichageAlgo( FenPrincipale parent, String titre, boolean modal, Controleur ctrl )
	{
		super ( parent, titre, modal );

		this.fenP = parent;
		this.ctrl = ctrl;

		this.lstRobots = new ArrayList<Robot>();
		this.lstPAlgo  = new ArrayList<PanAlgo>();

		this.scrollPane = new JScrollPane();

		//Ajout des Robot de tous les joueurs dans la liste
		for ( Joueur joueur : this.ctrl.getMetier().getListJoueur() )
		{
			this.lstRobots.add( joueur.getRobot(0) );
			this.lstRobots.add( joueur.getRobot(1) );
		}

		//Création des PanAlgo
		for ( Robot robot : this.lstRobots )
		{
			this.lstPAlgo.add( new PanAlgo( robot.getAlgo() ) );
		}

		this.setLayout( new GridLayout( 1, this.lstPAlgo.size() ) );

		for ( PanAlgo pAlgo : this.lstPAlgo )
		{
			this.scrollPane.add( pAlgo );
		}

		this.add( this.scrollPane );

		//La fenêtre sera centrée par rapport à la fenêtre principale
		this.setLocationRelativeTo(this.fenP);
		this.setSize(150,100);
		this.setResizable(false);
	}
}