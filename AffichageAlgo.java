package TwinTinBots.ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

import TwinTinBots.metier.Robot;
import TwinTinBots.metier.Joueur;

public class AffichageAlgo extends JDialog implements ActionListener
{
	private Controleur ctrl;
	private ArrayList<Robot> lstRobots;

	private ArrayList<PanAlgo> lstPAlgo;

	private FenPrincipale fenP;

	private JButton boutonRetour;

	public AffichageAlgo( FenPrincipale parent, String titre, boolean modal, Controleur ctrl )
	{
		this.setTitle(titre);
		this.setUndecorated(true);
		this.setModal(modal);
		this.setSize(800,600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.fenP = parent;
		this.ctrl = ctrl;

		this.lstRobots = new ArrayList<Robot>();
		this.lstPAlgo  = new ArrayList<PanAlgo>();


		//Ajout des Robot de tous les joueurs dans la liste
		for ( Joueur joueur : this.ctrl.getMetier().getListJoueur() )
		{
			this.lstRobots.add( joueur.getRobot(0) );
			this.lstRobots.add( joueur.getRobot(1) );
		}

		JPanel panGlobal = new JPanel();
		panGlobal.setLayout( new GridLayout( this.lstRobots.size(), 20 ,1 ,20 ) );

		//Création des PanAlgo
		for ( Robot robot : this.lstRobots )
		{
			this.lstPAlgo.add( new PanAlgo( robot.getJoueur().getNom(), robot.getAlgo() ) );
		}

		for ( PanAlgo pAlgo : this.lstPAlgo )
		{
			panGlobal.add( pAlgo );
		}

		JScrollPane jsPaneListe    = new JScrollPane(panGlobal,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Apparence.setFondScrollPane(jsPaneListe);
		jsPaneListe.setOpaque(false);
		jsPaneListe.setBorder(null);
		this.add(jsPaneListe);

		this.boutonRetour = new JButton("Retour");
		this.boutonRetour.addActionListener(this);
		Apparence.setStyleBoutonMenu(this.boutonRetour);
		this.add(this.boutonRetour,BorderLayout.SOUTH);

		//this.add( new JLabel("Test") );
		//this.add( this.scrollPane );

		this.setDefaultCloseOperation( this.DISPOSE_ON_CLOSE );
		//La fenêtre sera centrée par rapport à la fenêtre principale
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==this.boutonRetour)
			this.dispose();
	}
}