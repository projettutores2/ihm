package TwinTinBots.ihm;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class DialogVictoire extends JDialog
{
	private Controleur ctrl;

	public DialogVictoire(Controleur ctrl)
	{
		this.setSize(400,150);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter(){
			public void windowsClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		this.ctrl = ctrl;

		JLabel lab01 = new JLabel("Victoire de ");
		Apparence.setStyleVictoire(lab01);
		this.add(lab01, BorderLayout.CENTER);
		lab01.setHorizontalAlignment(JLabel.CENTER);
		lab01.setVerticalAlignment(JLabel.CENTER);

		JLabel lab02 = new JLabel(ctrl.getGagnant());
		Apparence.setStyleVictoire2(lab02);
		this.add(lab02, BorderLayout.SOUTH);
		lab02.setHorizontalAlignment(JLabel.CENTER);
		lab02.setVerticalAlignment(JLabel.CENTER);

		this.setVisible(true);

		try
		{
			Thread.sleep(10000);
			System.exit(0);
		}
		catch(Exception e){System.out.println("Erreur");}
	}
}