import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class DemandeRobots extends JDialog implements ActionListener
{
	private Controleur ctrl;

	private JComboBox<String> listeRobots;

	private JButton boutonValider;
	
	private FenPrincipale fenP;

	public DemandeRobots(FenPrincipale parent, String titre, boolean modal, Controleur ctrl)
	{
		super(parent, titre, modal);
		//le "modal" permet de dire que nous ne pouvons pas, ou non pouvons, accéder à d'autre fenêtre depuis DemandeRobots.
		//Le focus reste ou non sur cette fenêtre ajout
		this.fenP   = parent;
		this.ctrl   = ctrl;
		this.listeRobots = new JComboBox<String>();

		//méthode à utiliser mais n'est pas encore implémentée
		// for (Robot r : this.ctrl.getRobots())
			// this.listeRobots.addItem(r.getNom());
		//Pour tester :
		this.listeRobots.addItem("");
		for (int i=0; i<2; i++)
			this.listeRobots.addItem("Indice "+i);

		this.boutonValider = new JButton("Modifier ce robot");
		this.boutonValider.addActionListener(this);

		this.setLayout(new BorderLayout(0,10));
		this.add(this.listeRobots,   BorderLayout.CENTER);
		this.add(this.boutonValider, BorderLayout.SOUTH);

		//La fenêtre sera centrée par rapport à la fenêtre principale
		this.setLocationRelativeTo(this.fenP);
		this.setSize(150,100);
		this.setResizable(false);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.boutonValider)
		{
			this.dispose();
			new Tab2(this.fenP, "Ordres de votre robot", true, this.ctrl).setVisible(true);			
		}
	}

}
