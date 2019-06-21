package TwinTinBots.ihm;
import TwinTinBots.metier.Joueur;
import TwinTinBots.metier.Ordre;
import TwinTinBots.metier.ModifAlgo;
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
	private JButton boutonRetour, boutonValider, boutonTransformer, boutonAppliquer, boutonCorbeille, boutonSupprimerIndice;
	//ensemble de l'écran avec les images + fonction "transformer"
	private JPanel panBoutonsDeDroite;
	private JPanel panEnsembleBoutonsCombo;
	private JComboBox<String> listeImage1, listeImage2, listeImage3, listeImage4, listeImage5;
	private ModifAlgo modifAlgo;


	/*Pour les tests*/
	private String[] tabOrdresTests = new String[3];
	
	public Tab2(FenPrincipale f, String titre, boolean modal, Controleur ctrl,int idRobot)
	{
		super (f, titre, modal);
		this.ctrl = ctrl;
		this.fenP = f;
		Toolkit kit = Toolkit.getDefaultToolkit(); 
        // Modifier l'icône de JFrame
        String s= "./TwinTinBots/img/";
        if (idRobot == 0)
            s+="grosRobot";
        else
            s+="petitRobot";
        s+=this.ctrl.getMetier().getIndJoueurActif()+".png";
        Image img = kit.getImage(s);
        setIconImage(img);
		this.tabLabelOrdresPossedes = new JLabel[3];
		this.initComponents(idRobot);
		this.modifAlgo  = this.ctrl.getMetier().getModifAlgo();
		this.modifAlgo.setJoueur(this.ctrl.getMetier().getJoueurActif());
		this.modifAlgo.setRobot(this.modifAlgo.getJoueur().getRobot(idRobot));
	}
	private void initComponents(int idRobot)
	{
		this.panHaut = new JPanel();
		this.panHaut.setLayout(new GridLayout(2,NOMBRE_ORDRES));
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
		this.panEnsembleBoutonsCombo.setLayout(new GridLayout(3,4));
		//init
		this.afficherOrdres();
		this.algoRobot(idRobot);

		//cree les boutton et ajout des button
		this.boutonRetour=this.creeButton("Retour",this.panBoutonsDeDroite);
		Apparence.setStyleBtnRetour(this.boutonRetour);
		this.boutonValider=this.creeButton("Valider",this.panBoutonsDeDroite);
		Apparence.setStyleBtn(this.boutonValider);
		this.boutonCorbeille=this.creeButton("Supprimer",this.panBoutonsDeDroite);
		Apparence.setStyleBtnRetour(this.boutonCorbeille);
		this.boutonTransformer=this.creeButton("Echanger",this.panEnsembleBoutonsCombo);
		Apparence.setStyleBtnRetour(this.boutonTransformer);
		this.boutonAppliquer=this.creeButton("Appliquer",this.panEnsembleBoutonsCombo);
		Apparence.setStyleBtn(this.boutonAppliquer);
		this.boutonSupprimerIndice=this.creeButton("Supprimer (indice)", this.panEnsembleBoutonsCombo);
		Apparence.setStyleBtnRetour(this.boutonSupprimerIndice);

		this.listeImage1 = new JComboBox<String>();
		this.listeImage2 = new JComboBox<String>();
		this.listeImage3 = new JComboBox<String>();
		this.listeImage4 = new JComboBox<String>();
		this.listeImage5 = new JComboBox<String>();

		for (int i=1; i<NOMBRE_ORDRES_POSSEDES+1; i++)
		{
			this.listeImage1.addItem("Indice "+i);
			this.listeImage2.addItem("Indice "+i);
			this.listeImage4.addItem("Indice "+i);
			this.listeImage5.addItem("Indice "+i);
		}
		for (int i=1; i<14; i++)
		{
			this.listeImage3.addItem("Indice "+i);
		}

		this.panEnsembleBoutonsCombo.add(this.boutonTransformer);
		this.panEnsembleBoutonsCombo.add (this.listeImage1);
		JLabel jLab = new JLabel(" avec ");
		Apparence.setStyleLbl(jLab);
		jLab.setHorizontalAlignment(JLabel.CENTER);
		jLab.setVerticalAlignment(JLabel.CENTER);
		this.panEnsembleBoutonsCombo.add (jLab);
		this.panEnsembleBoutonsCombo.add (this.listeImage2);

		this.panEnsembleBoutonsCombo.add(this.boutonAppliquer);
		this.panEnsembleBoutonsCombo.add(this.listeImage3);
		JLabel jLab2 = new JLabel(" vers ");
		Apparence.setStyleLblRetour(jLab2);
		jLab2.setHorizontalAlignment(JLabel.CENTER);
		jLab2.setVerticalAlignment(JLabel.CENTER);
		this.panEnsembleBoutonsCombo.add(jLab2);
		this.panEnsembleBoutonsCombo.add(this.listeImage4);

		this.panEnsembleBoutonsCombo.add(this.boutonSupprimerIndice);
		this.panEnsembleBoutonsCombo.add(listeImage5);

		//Pour remettre un fond esthétiquement correct :
		JLabel[] tabFond = new JLabel[2];
		for (int i=0; i<2; i++)
		{
			tabFond[i] = new JLabel();
			Apparence.setStyleLbl(tabFond[i]);
			this.panEnsembleBoutonsCombo.add(tabFond[i]); 
		}

		this.add(this.panGlobal, BorderLayout.CENTER);
		this.add(this.panEnsembleBoutonsCombo, BorderLayout.SOUTH);
		this.add(this.panBoutonsDeDroite, BorderLayout.EAST);

		//this.setResizable(false);		
		this.setSize(1600,500);
		this.setLocationRelativeTo(this.fenP);
	}	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==this.boutonRetour)
		{
			this.modifAlgo.setTypeModif(5);
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
			this.modifAlgo.setTypeModif(4);
			this.majSupprimerAffichageOrdres();
		}
		else if (e.getSource()==this.boutonValider)
		{
			this.dispose();
		}
		else if (e.getSource() == this.boutonAppliquer)
		{
			this.majApplication(this.listeImage3.getSelectedIndex(), this.listeImage4.getSelectedIndex());
		}
		else if (e.getSource() == this.boutonSupprimerIndice)
		{
			this.majSuppressionAvecIndice(this.listeImage5.getSelectedIndex());
		}
	}

	public void majSuppressionAvecIndice(int o1)
	{
		this.modifAlgo.setTypeModif(3);
		this.modifAlgo.setSlot(o1);
		
		for (int i=0; i<this.tabLabelOrdresPossedes.length; i++)
		{
			if (i==o1)
				this.tabLabelOrdresPossedes[i].setIcon(new ImageIcon("vide.png"));
			this.revalidate();
			this.repaint();
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
	public void majApplication(int o1, int o2)
	{

		for(int i=0; i<this.ctrl.getMetier().getJoueurActif().getStockOrdres().size(); i++)
		{
			if (i==o1)
			{
				Icon iconTemporaire = this.ctrl.getMetier().getJoueurActif().getStockOrdres().get(i).getImg().getIcon();
				this.tabLabelOrdresPossedes[o2].setIcon(new ImageIcon(iconTemporaire.toString()));

				this.revalidate();
				this.repaint();
			}
		}

		this.modifAlgo.setTypeModif(1);
		this.modifAlgo.setNewOrdre(o1);
		this.modifAlgo.setSlot(o2);
		
			/*String s = ordre.getImg().getIcon().toString();
			System.out.println("ENTREE COMPTAGE "+ s);
			switch (s)
			{
				case "./TwinTinBots/img/imgOrdre0.png":
					this.nombreChaqueOrdre[0] = this.nombreChaqueOrdre[0] + 1;
					break;
				case "./TwinTinBots/img/imgOrdre1.png":
					this.nombreChaqueOrdre[1] = this.nombreChaqueOrdre[1] + 1;
					break;
				case "./TwinTinBots/img/imgOrdre2.png":
					this.nombreChaqueOrdre[2] = this.nombreChaqueOrdre[2] + 1;
					break;
				case "./TwinTinBots/img/imgOrdre3.png":
					this.nombreChaqueOrdre[3] = this.nombreChaqueOrdre[3] + 1;
					break;
				case "./TwinTinBots/img/imgOrdre4.png":
					this.nombreChaqueOrdre[4] = this.nombreChaqueOrdre[4] + 1;
					break;
				case "./TwinTinBots/img/imgOrdre5.png":
					this.nombreChaqueOrdre[5] = this.nombreChaqueOrdre[5] + 1;
					break;
			}*/
	}

	public void majEchange(int o1, int o2)
	{
		Icon iconTemporaire = this.tabLabelOrdresPossedes[o1].getIcon();
		this.tabLabelOrdresPossedes[o1].setIcon(new ImageIcon(this.tabLabelOrdresPossedes[o2].getIcon().toString()));

		this.tabLabelOrdresPossedes[o2].setIcon(new ImageIcon(iconTemporaire.toString()));

		this.modifAlgo.setTypeModif(2);
		this.modifAlgo.setSlot(o1);
		this.modifAlgo.setSlot2(o2);
		
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
		this.panHaut.removeAll();
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
			ordre.getImg().addMouseListener(this);
			ordre.getImg().setTransferHandler(new TransferHandler("icon"));
			this.panHaut.add(ordre.getImg());
		}
		int i=0;
        for (Ordre ordre : this.ctrl.getMetier().getJoueurActif().getStockOrdres())
        {
            JLabel indiceOrdre = new JLabel(""+(i+1));
            Apparence.setStyleLbl(indiceOrdre);
            indiceOrdre.setHorizontalAlignment(JLabel.CENTER);
            indiceOrdre.setVerticalAlignment(JLabel.CENTER);
            this.panHaut.add(indiceOrdre);
            i++;
        }
	}

	private void algoRobot(int idRobot)
	{
		int i = 0;
		try{Thread.sleep(500);}
		catch(Exception e){}
		for(Ordre ordre : this.ctrl.getMetier().getJoueurActif().getRobot(idRobot).getAlgo())
		{
			if(ordre == null) 
				this.tabLabelOrdresPossedes[i] = new JLabel(new ImageIcon("vide.png"));
			else
				this.tabLabelOrdresPossedes[i] = ordre.getImg();
			this.tabLabelOrdresPossedes[i].addMouseListener(this);
			this.tabLabelOrdresPossedes[i].setTransferHandler(new TransferHandler("icon"));
			this.tabLabelOrdresPossedes[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
			this.panBas.add(this.tabLabelOrdresPossedes[i]);
			i++;
		}
		this.revalidate();
		this.repaint();
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