package TwinTinBots.ihm;
import TwinTinBots.metier.Joueur;
import TwinTinBots.metier.Ordre;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Toolkit.*;
import java.io.*;

public class Tab2 extends JDialog implements ActionListener, MouseListener
{
	private final int NOMBRE_ORDRES=6, NOMBRE_ORDRES_POSSEDES=3;
	private JLabel [] tabLabelOrdres;
	private JLabel [] tabLabelOrdresPossedes;
	private Controleur ctrl;
	private FenPrincipale fenP;
	private JPanel panHaut, panBas, panGlobal;
	private JButton boutonRetour, boutonValider, boutonTransformer, boutonCorbeille;
	//ensemble de l'écran avec les images + fonction "transformer"
	private JPanel panBoutonsDeDroite;
	private JPanel panEnsembleBoutonsCombo;
	private JComboBox<String> listeImage1, listeImage2;


	/*Pour les tests*/
	private String[] tabOrdresTests = new String[3];
	
	public Tab2(FenPrincipale f, String titre, boolean modal, Controleur ctrl,int idRobot)
	{
		super (f, titre, modal);
		this.ctrl = ctrl;
		this.fenP = f;
		this.initComponents(idRobot);		
	}
	private void initComponents(int idRobot)
	{
		this.panHaut = new JPanel();
		this.panHaut.setLayout(new GridLayout(1,NOMBRE_ORDRES));
		this.tabLabelOrdres = new JLabel[NOMBRE_ORDRES];

		this.panBas = new JPanel();
		this.panBas.setLayout(new GridLayout(1,NOMBRE_ORDRES_POSSEDES));
		this.tabLabelOrdresPossedes = new JLabel[NOMBRE_ORDRES_POSSEDES];
		
		this.panGlobal = new JPanel();
		this.panGlobal.setLayout(new GridLayout(2,30,1,0));
		this.panGlobal.add(this.panHaut);
		this.panGlobal.add(this.panBas);
		//creation panel et initialisation
		this.panBoutonsDeDroite = new JPanel();
		this.panBoutonsDeDroite.setLayout(new GridLayout(3,1));
		this.panEnsembleBoutonsCombo = new JPanel();
		this.panEnsembleBoutonsCombo.setLayout(new GridLayout(1,4));
		//init
		this.afficherOrdres();
		this.algoRobot(idRobot);

		//cree les boutton et ajout des boutton
		this.boutonRetour=this.creeButton("Retour",this.panBoutonsDeDroite);
		Apparence.setStyleBtnRetour(this.boutonRetour);
		this.boutonValider=this.creeButton("Valider",this.panBoutonsDeDroite);
		Apparence.setStyleBtn(this.boutonValider);
		this.boutonCorbeille=this.creeButton("Supprimer",this.panBoutonsDeDroite);
		Apparence.setStyleBtn(this.boutonCorbeille);
		this.boutonTransformer=this.creeButton("Echanger",this.panEnsembleBoutonsCombo);

		this.listeImage1 = new JComboBox<String>();
		this.listeImage2 = new JComboBox<String>();

		this.listeImage1.addItem("");		
		this.listeImage2.addItem("");
		for (int i=0; i<NOMBRE_ORDRES_POSSEDES; i++)
		{
			this.listeImage1.addItem("Indice "+i);
			this.listeImage2.addItem("Indice "+i);
		}

		this.panEnsembleBoutonsCombo.add (this.listeImage1);
		JLabel jLab = new JLabel(" avec ");
		Apparence.setStyleLbl(jLab);
		jLab.setHorizontalAlignment(JLabel.CENTER);
		jLab.setVerticalAlignment(JLabel.CENTER);
		this.panEnsembleBoutonsCombo.add (jLab);
		this.panEnsembleBoutonsCombo.add (this.listeImage2);


		this.add(this.panGlobal, BorderLayout.CENTER);
		this.add(this.panEnsembleBoutonsCombo, BorderLayout.SOUTH);
		this.add(this.panBoutonsDeDroite, BorderLayout.EAST);

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
		else if (e.getSource()==this.boutonTransformer)
		{
			if (this.listeImage1.getSelectedItem() != ""
				&&
				this.listeImage2.getSelectedItem() != "")
				this.majEchange(this.listeImage1.getSelectedIndex(), this.listeImage2.getSelectedIndex());
		}
		else if (e.getSource()==this.boutonCorbeille)
		{
			this.majSupprimerAffichageOrdres();
		}
	}

	public void majSupprimerAffichageOrdres()
	{
		for (int i=0; i<this.tabLabelOrdresPossedes.length; i++)
		{
			this.tabLabelOrdresPossedes[i].setIcon(new ImageIcon("vide.png"));
			this.revalidate();
			this.repaint();
		}
	}

	public void majEchange(int o1, int o2)
	{
		System.out.println("entree");
		o1--;o2--;
		Icon iconTemporaire = this.tabLabelOrdresPossedes[o1].getIcon();
		this.tabLabelOrdresPossedes[o1].setIcon(new ImageIcon(this.tabLabelOrdresPossedes[o2].getIcon().toString()));

		this.tabLabelOrdresPossedes[o2].setIcon(new ImageIcon(iconTemporaire.toString()));

		this.revalidate();
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		/*en commentaires : la partie qui permet de ne pas déplacer les objets du bas*/
		
		/*boolean estEnOk = true;
		for (int i=0; i<NOMBRE_ORDRES_POSSEDES; i++)
		{
			if (e.getSource()==this.tabLabelOrdresPossedes[i])estEnOk=false;
		}
		if (estEnOk)
		{*/
		JComponent jc = (JComponent)e.getSource();
		TransferHandler th = jc.getTransferHandler();
		th.exportAsDrag(jc, e, TransferHandler.COPY);				
		//}
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
		for(Ordre ordre : this.ctrl.getMetier().getJoueurActif().getStockOrdres())
			this.panHaut.remove(ordre.getImg());
		/*for (int i = 0; i<this.tabLabelOrdres.length; i++) {
			this.panHaut.remove(this.tabLabelOrdres[i]);
		}*/
		
		/*for (int i = 0; i<this.tabLabelOrdres.length; i++) {
			this.tabLabelOrdres[i]= new JLabel(new ImageIcon("./TwinTinBots/img/imgOrdre"+i+".png"));
			this.tabLabelOrdres[i].addMouseListener(this);
			this.tabLabelOrdres[i].setTransferHandler(new TransferHandler("icon"));
			this.panHaut.add(tabLabelOrdres[i]);
		}*/
		this.afficherOrdres();
		this.revalidate();
		this.repaint();
	}

	private void afficherOrdres()
	{
		for(Ordre ordre : this.ctrl.getMetier().getJoueurActif().getStockOrdres())
		{
			System.out.println(ordre);
			ordre.getImg().addMouseListener(this);
			ordre.getImg().setTransferHandler(new TransferHandler("icon"));
			this.panHaut.add(ordre.getImg());
		}
	}

	private void algoRobot(int idRobot)
	{
		for(Ordre ordre : this.ctrl.getMetier().getJoueurActif().getRobot(idRobot).getAlgo())
		{
			JLabel lblOrdre ;
			if(ordre == null) 
				lblOrdre = new JLabel(new ImageIcon("vide.png"));
			else lblOrdre=ordre.getImg();
			lblOrdre.addMouseListener(this);
			lblOrdre.setTransferHandler(new TransferHandler("icon"));
			lblOrdre.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
			this.panBas.add(lblOrdre);	
		}
	}
	private JButton creeButton(String nom,JPanel panel)
	{
		//cree le bouton
		JButton tmp = new JButton(nom);
		//ajoute au panel
		panel.add(tmp);
		//ajoute a l'action
		tmp.addActionListener(this);
		return tmp ;
	}

	/*public void lireOrdresPossedes()
	{
		/*String s_Img = "imgOrdre0";
		ImageIcon icon_ImgIcon = new ImageIcon(s_Img);
		for (int j = 0; j<this.tabLabelOrdresPossedes.length; j++)
		{
			switch(this.tabLabelOrdresPossedes[j].getIcon())
			{

			}

		}
	}*/
}
