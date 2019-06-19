import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Toolkit.*;
import java.io.*;

/*
POUR LES TESTS, JE CREE LES ORDRES DANS CETTE CLASSE.
NORMALEMENT, ILS DEVRONT ETRE ENVOYES AU ROBOT
*/

public class Tab2 extends JDialog implements ActionListener, MouseListener
{
	private final int NOMBRE_ORDRES=6, NOMBRE_ORDRES_POSSEDES=3;
	private JLabel [] tabLabelOrdres;
	private JLabel [] tabLabelOrdresPossedes;
	private Controleur ctrl;
	private FenPrincipale fenP;
	private JPanel panHaut, panBas, panGlobal;
	private JButton boutonRetour, boutonValider;


	/*Pour les tests*/
	private String[] tabOrdresTests = new String[3];
	
	public Tab2(FenPrincipale f, String titre, boolean modal, Controleur ctrl)
	{
		super (f, titre, modal);
		this.ctrl = ctrl;
		this.fenP = f;
		this.initComponents();		
	}
	private void initComponents()
	{
		this.panHaut = new JPanel();
		this.panHaut.setLayout(new GridLayout(1,NOMBRE_ORDRES));
		this.tabLabelOrdres = new JLabel[NOMBRE_ORDRES];
		for (int i = 0; i<tabLabelOrdres.length; i++) {
			this.tabLabelOrdres[i]= new JLabel(new ImageIcon("imgOrdre"+i+".png"));
			this.tabLabelOrdres[i].addMouseListener(this);
			this.tabLabelOrdres[i].setTransferHandler(new TransferHandler("icon"));
			this.panHaut.add(tabLabelOrdres[i]);
		}
		this.panBas = new JPanel();
		this.panBas.setLayout(new GridLayout(1,NOMBRE_ORDRES_POSSEDES));
		this.tabLabelOrdresPossedes = new JLabel[NOMBRE_ORDRES_POSSEDES];
		//init
		for (int i = 0; i<tabLabelOrdresPossedes.length; i++) {
			this.tabLabelOrdresPossedes[i]= new JLabel(new ImageIcon("vide.png"));
			this.tabLabelOrdresPossedes[i].addMouseListener(this);
			this.tabLabelOrdresPossedes[i].setTransferHandler(new TransferHandler("icon"));
			this.tabLabelOrdresPossedes[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
			this.panBas.add(this.tabLabelOrdresPossedes[i]);	
		}
		
		this.panGlobal = new JPanel();
		this.panGlobal.setLayout(new GridLayout(2,30,1,0));
		this.panGlobal.add(this.panHaut);
		this.panGlobal.add(this.panBas);
		
		this.boutonRetour = new JButton("Retour");
		this.boutonRetour.addActionListener(this);

		this.boutonValider = new JButton("Valider");
		this.boutonValider.addActionListener(this);

		this.add(this.panGlobal, BorderLayout.CENTER);
		this.add(this.boutonRetour, BorderLayout.SOUTH);
		this.add(this.boutonValider, BorderLayout.EAST);

		this.setResizable(false);		
		this.setSize(800,400);
		this.setLocationRelativeTo(this.fenP);
	}	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==this.boutonRetour)
		{
			// ...
			this.dispose();
		}
		else if (e.getSource() == this.boutonValider)
		{
			this.ctrl.
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		
		boolean estEnOk = true;
		for (int i=0; i<NOMBRE_ORDRES_POSSEDES; i++)
		{
			if (e.getSource()==this.tabLabelOrdresPossedes[i])estEnOk=false;
		}
		if (estEnOk)
		{
			JComponent jc = (JComponent)e.getSource();
			TransferHandler th = jc.getTransferHandler();
			th.exportAsDrag(jc, e, TransferHandler.COPY);				
		}
		this.majPanel();
	}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		this.majPanel();
	}

	public void majPanel()
	{
		for (int i = 0; i<this.tabLabelOrdres.length; i++) {
			this.panHaut.remove(this.tabLabelOrdres[i]);
		}
		
		for (int i = 0; i<this.tabLabelOrdres.length; i++) {
			this.tabLabelOrdres[i]= new JLabel(new ImageIcon("imgOrdre"+i+".png"));
			this.tabLabelOrdres[i].addMouseListener(this);
			this.tabLabelOrdres[i].setTransferHandler(new TransferHandler("icon"));
			this.panHaut.add(tabLabelOrdres[i]);
		}
		this.revalidate();
		this.repaint();
	}

	public void lireOrdresPossedes()
	{
		/*String s_Img = "imgOrdre0";
		ImageIcon icon_ImgIcon = new ImageIcon(s_Img);*/
		for (int j = 0; j<this.tabLabelOrdresPossedes.length; j++)
		{
			switch(this.tabLabelOrdresPossedes[j].getIcon())
			{

			}

		}
	}
}