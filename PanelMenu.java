package TwinTinBots.ihm;
import java.awt.*;
import java.awt.font.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import javax.swing.*;

public class PanelMenu extends JPanel implements ActionListener
{
	private JButton bLancerPartie;
	private JButton bScenario;
	private JButton bQuitter;
	private Launcher menu;
	
	public PanelMenu(Launcher m)
	{
		SpringLayout panelGlobal = new SpringLayout();
		this.setLayout(panelGlobal);
		this.menu =m;
		
		JLabel lblCreation = new JLabel("");//vide
		panelGlobal.putConstraint(SpringLayout.WEST, lblCreation, -5, SpringLayout.WEST, this);
		panelGlobal.putConstraint(SpringLayout.SOUTH, lblCreation, -400, SpringLayout.SOUTH, this);
		Font font = new Font("Helvetica",Font.BOLD,40);
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		this.add(lblCreation);
		
		this.bLancerPartie = new JButton("Jouer");
		this.bLancerPartie.addActionListener(this);
		Apparence.setStyleBoutonMenu(this.bLancerPartie);
		panelGlobal.putConstraint(SpringLayout.NORTH, this.bLancerPartie, 150, SpringLayout.SOUTH, lblCreation);
		panelGlobal.putConstraint(SpringLayout.WEST, this.bLancerPartie, 200, SpringLayout.WEST, this);
		panelGlobal.putConstraint(SpringLayout.SOUTH, this.bLancerPartie, -200, SpringLayout.SOUTH, this);
		panelGlobal.putConstraint(SpringLayout.EAST, this.bLancerPartie, -200, SpringLayout.EAST, this);
		this.add(this.bLancerPartie);

		this.bScenario = new JButton("Mode Sc\u00e9nario");
		this.bScenario.addActionListener(this);	
		Apparence.setStyleBoutonMenu(this.bScenario);
		panelGlobal.putConstraint(SpringLayout.NORTH, this.bScenario, 20, SpringLayout.SOUTH, this.bLancerPartie);
		panelGlobal.putConstraint(SpringLayout.WEST, this.bScenario, 0, SpringLayout.WEST, this.bLancerPartie);
		panelGlobal.putConstraint(SpringLayout.SOUTH, this.bScenario, -120, SpringLayout.SOUTH, this);
		panelGlobal.putConstraint(SpringLayout.EAST, this.bScenario, 0, SpringLayout.EAST, this.bLancerPartie);
		this.add(bScenario);

		this.bQuitter = new JButton("Quitter");
		this.bQuitter.addActionListener(this);	
		Apparence.setStyleBoutonMenu(this.bQuitter);
		panelGlobal.putConstraint(SpringLayout.NORTH, this.bQuitter, 20, SpringLayout.SOUTH, this.bScenario);
		panelGlobal.putConstraint(SpringLayout.WEST, this.bQuitter, 0, SpringLayout.WEST, this.bScenario);
		panelGlobal.putConstraint(SpringLayout.SOUTH, this.bQuitter, -60, SpringLayout.SOUTH, this);
		panelGlobal.putConstraint(SpringLayout.EAST, this.bQuitter, 0, SpringLayout.EAST, this.bScenario);
		this.add(bQuitter);
		
		Apparence.setFondMenu(this);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==this.bScenario)
		{
			this.menu.addScenario();
			//this.menu.lancerPartie(null);
		}
		if (e.getSource()==this.bLancerPartie)
		{
			this.menu.addPanDemandeJ();
		}

		if (e.getSource()==this.bQuitter)
		{
			System.exit(0);
		}

	}
}