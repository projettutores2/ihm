import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class FenPrincipale extends JFrame implements ActionListener
{
	private MonPanel   monPanel;
	private JButton    cote01, cote02, cote03, cote04, cote05, cote06;
	private Controleur ctrl;
	private JPanel     panBas;
	private int taille, tailleCalculee;
	private PanDroit panDroit;

	public FenPrincipale (Controleur ctrl)
	{
		this.monPanel = new MonPanel ( ctrl );
		this.panBas   = new JPanel();
		this.panBas.setLayout(new GridLayout(2,3));
		this.ctrl = ctrl;
		this.taille = 76;
		this.tailleCalculee = 40;
		this.cote01 = new JButton  ("Cote 01");
		this.cote01.addActionListener(this);

		this.cote02 = new JButton  ("Cote 02");
		this.cote02.addActionListener(this);

		this.cote03 = new JButton  ("Cote 03");
		this.cote03.addActionListener(this);

		this.cote04 = new JButton  ("Cote 04");
		this.cote04.addActionListener(this);

		this.cote05 = new JButton  ("Cote 05");
		this.cote05.addActionListener(this);

		this.cote06 = new JButton  ("Cote 06");
		this.cote06.addActionListener(this);

		this.panBas.add(this.cote01);
		this.panBas.add(this.cote02);
		this.panBas.add(this.cote03);
		this.panBas.add(this.cote04);
		this.panBas.add(this.cote05);
		this.panBas.add(this.cote06);

		this.panDroit   = new PanDroit(this.ctrl, this);

		this.add(this.panBas, BorderLayout.SOUTH);
		this.add (this.monPanel,  BorderLayout.CENTER);
		this.add (this.panDroit,  BorderLayout.EAST);
    	this.setSize    (1200,800);
    	this.setLocation( 10, 10);
		this.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e)
	{
		int x, y;
		x = this.ctrl.getPion().getX();
		y = this.ctrl.getPion().getY();
		if (e.getSource() == this.cote01)
		{
			this.ctrl.getPion().setX(x + this.taille/2);
			this.ctrl.getPion().setY(y - (this.tailleCalculee+this.tailleCalculee/2));
			//this.ctrl.getPion().setIndiceDirection(1);
		}
		else if (e.getSource() == this.cote02)
		{
			this.ctrl.getPion().setX(x + this.taille);
			this.ctrl.getPion().setY(y);
			//this.ctrl.getPion().setIndiceDirection(2);
		}
		else if (e.getSource() == this.cote03)
		{
			this.ctrl.getPion().setX(x + this.taille/2);
			this.ctrl.getPion().setY(y + this.tailleCalculee+this.tailleCalculee/2);
			//this.ctrl.getPion().setIndiceDirection(3);
		}
		else if (e.getSource() == this.cote04)
		{
			this.ctrl.getPion().setX(x - this.taille/2);
			this.ctrl.getPion().setY(y + this.tailleCalculee+this.tailleCalculee/2);
			//this.ctrl.getPion().setIndiceDirection(4);
		}
		else if (e.getSource() == this.cote05)
		{
			this.ctrl.getPion().setX(x - this.taille);
			this.ctrl.getPion().setY(y);
			//this.ctrl.getPion().setIndiceDirection(5);
		}
		else if (e.getSource() == this.cote06)
		{
			this.ctrl.getPion().setX(x - this.taille/2);
			this.ctrl.getPion().setY(y - (this.tailleCalculee+this.tailleCalculee/2));
			//this.ctrl.getPion().setIndiceDirection(6);
		}
		
		this.majIhm();
	}

	public void majIhm()
	{
		this.monPanel.repaint();
	}
}