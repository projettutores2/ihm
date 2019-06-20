package TwinTinBots.ihm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class PanAlgo
{
	private final int NOMBRE_ORDRE_ROBOT = 3;
	private JLabel[] tabLabelOrdresRobot;

	public PanAlgo( Ordre[] algoRobot )
	{
		this.tabLabelOrdresRobot = new JLabel[NOMBRE_ORDRE_ROBOT];
		this.setLayout( new GridLayout( 1, NOMBRE_ORDRE_ROBOT ) );

		//Si l'ordre est null on met "vide.png", sinon on met l'image correspondant à l'ordre
		for (int i = 0; i<tabLabelOrdresRobot.length; i++) {
			if ( algoRobot[i] != null )
			{
				this.tabLabelOrdresRobot[i] = new JLabel( new ImageIcon(algoRobot[i].getImgOrdre() ) );
			}
			else  this.tabLabelOrdresRobot[i]= new JLabel(new ImageIcon("vide.png"));


			this.tabLabelOrdresRobot[i].addMouseListener(this);
			this.tabLabelOrdresRobot[i].setTransferHandler(new TransferHandler("icon"));
			this.tabLabelOrdresRobot[i].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
			this.panBas.add(this.tabLabelOrdresRobot[i]);	
		}

		for ( int i = 0; i < NOMBRE_ORDRE_ROBOT; i++ )
		{
			this.add( tabLabelOrdresRobot[i] );
		}
	}
}