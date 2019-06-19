import javax.swing.JPanel;
import java.awt.*;
import java.lang.Object;
import javax.swing.*;
import java.awt.geom.AffineTransform;


public class MonPanel extends JPanel
{
	Controleur ctrl;
	private final int HAUTEUR = 1000, LARGEUR = 722;


	public MonPanel ( Controleur ctrl )
	{
		this.ctrl = ctrl;
	}

	public int getHauteur(){return this.HAUTEUR;}
	public int getLargeur(){return this.LARGEUR;}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		String sImage;

		// Ajout de l'image du fond
		
		Image img = new ImageIcon(new ImageIcon(this.ctrl.getFond()).getImage().getScaledInstance(HAUTEUR, LARGEUR, Image.SCALE_DEFAULT)).getImage();
		Pion p;

		//pion représenté par une image :
		Image imgRobot = new ImageIcon(new ImageIcon(this.ctrl.getStringRobot()).getImage().getScaledInstance(57, 60, Image.SCALE_DEFAULT)).getImage();


		g2.drawImage ( img, 0,0, this );


		p =  ctrl.getPion();

		//Pour dessiner un pion
		/*if ( p != null )
		{
			g2.setColor ( Color.BLACK );
			int taille = 5;
			g2.fillOval ( p.getX() + 470-taille, p.getY() + 338-taille , taille, taille );
		}*/

		if (p != null)
		{
			AffineTransform rotation = new AffineTransform();
			rotation.translate(p.getX() + 472, p.getY() + 85);
			//rotation.rotate(p.getDoubleDirection(),(int)(imgRobot.getWidth(null)/2),(int)(imgRobot.getHeight(null)/2));
			/*
			** rotate (double theta, double x, double y)
			** theta est l'angle en radians
			** on a donc en possibilité de déplacement :
			** +-      60      |      120     |    180         DEGREE
			** soit 
			** +- 0.33*Math.PI | 0.67*Math.PI | 0.1*Math.PI    RADIAN
			*/
			g2.drawImage (imgRobot, rotation , this);
		}
	}
}