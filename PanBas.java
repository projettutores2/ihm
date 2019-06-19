import java.awt.*;
import javax.swing.*;

public class PanBas extends JPanel
{
	private Controleur ctrl;

	private JLabel labPointsJoueur;
	private String message;
	
	public PanBas(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.message = "Points de "+this.ctrl.getMetier().getJoueurActif()+" ";
		this.labPointsJoueur = new JLabel(message + this.ctrl.getMetier().getScoreJoueurActif());

		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		Apparence.setStyleLbl(this.labPointsJoueur);
		this.add(this.labPointsJoueur);
	}

	public void majPanel()
	{
		this.message = "Points de "+this.ctrl.getMetier().getJoueurActif()+ " ";
		this.labPointsJoueur.setText(message + this.ctrl.getMetier().getScoreJoueurActif());
		this.revalidate();
		this.repaint();
	}
}
