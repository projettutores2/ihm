import java.awt.*;
import java.awt.font.*;
import java.util.*;
import java.io.*;

import javax.swing.*;

public class PanCentral extends JPanel
{
	private Controleur ctrl;
	public PanCentral(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.initComponents();
	}
	
	private void initComponents()
	{
		SpringLayout sl_panel = new SpringLayout();
		this.setLayout(sl_panel);
		
		JLabel lblCreation = new JLabel("");
		sl_panel.putConstraint(SpringLayout.WEST, lblCreation, -5, SpringLayout.WEST, this);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblCreation, -300, SpringLayout.SOUTH, this);
		this.add(lblCreation);

		Apparence.setFond(this);
	}
}
