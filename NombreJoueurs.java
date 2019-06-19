package TwinTinBots.ihm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Toolkit;

public class NombreJoueurs extends JDialog implements ActionListener
{
	private SpinnerModel spinNbJ;
	private JSpinner spinner;
	private JPanel panHaut, panBas;
	private JButton bOk, bCancel;
	private Launcher menu;

	public NombreJoueurs(Launcher m)
	{
		this.setSize(320,70);
		this.setLocationRelativeTo(m);
		this.menu = m;
		this.spinNbJ = new SpinnerNumberModel(2,2,6,1);
		this.setUndecorated(true);
		this.spinner = new JSpinner(this.spinNbJ);   
		this.spinner.setBounds(100,100,50,30);  

		this.panHaut = new JPanel();
		this.panBas  = new JPanel();
		this.bOk=new JButton("Valider");
		this.bOk.addActionListener(this);
		this.bCancel=new JButton("Quitter");
		this.bCancel.addActionListener(this);

		this.panHaut.setLayout(new GridLayout(1,2));
		this.panHaut.setBackground(new Color(197, 175, 146));
		this.panBas.setLayout(new GridLayout(1,2));

		JLabel lbl = new JLabel("Nombre de joueurs : ");
		Apparence.setStyleLbl(lbl);
		this.panHaut.add(lbl);
		this.panHaut.add(this.spinner);

		this.panBas.add(this.bOk);
		this.panBas.add(this.bCancel);
		Apparence.setStyleBtn(this.bOk);
		Apparence.setStyleBtn(this.bCancel);

		this.setLayout(new GridLayout(2,1));
		this.add(this.panHaut);
		this.add(this.panBas);    
    
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==this.bCancel)
			this.dispose();
		if (e.getSource()==this.bOk)
		{	
			this.dispose();
			this.menu.setNbJ(Integer.valueOf(this.spinner.getValue().toString()));
		}
	}
}
