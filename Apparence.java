package TwinTinBots.ihm;
import java.awt.*;
import java.awt.font.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;


public class Apparence
{
	public static void setStyleLbl(JLabel lbl)
	{
		lbl.setFont(new Font("Helvetica", Font.BOLD, 20));
		lbl.setForeground(new Color(100, 100, 100));
		lbl.setOpaque(true);
		lbl.setBackground(new Color(197,175,146));
	}
	public static void setStyleBtn(JButton btn){
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setBackground(new Color(197,175,146));
		btn.setForeground(new Color(100, 100, 100));
		btn.setFont(new Font("Helvetica", Font.BOLD, 20));
	}
	public static void setStyleBtnRetour(JButton btn){
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setBackground(new Color(177,155,126));
		btn.setForeground(new Color(100, 100, 100));
		btn.setFont(new Font("Helvetica", Font.BOLD, 20));
	}
	public static void setStyleBoutonMenu(JButton btn)
	{
		btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn.setBorderPainted(false);
		btn.setFocusable(false);
		btn.setBackground(new Color(197,175,146));
		btn.setForeground(new Color(100, 100, 100));
		btn.setFont(new Font("Helvetica", Font.BOLD, 20));
	}
	public static void setFondColore(JPanel pan)
	{
		pan.setBackground(new Color(197, 175, 146));
	}
	public static void setFond(JPanel pan){
		JLabel label_01 = new JLabel("");
		label_01.setIcon(new ImageIcon("./TwinTinBots/Plateau2-4.jpg"));
		pan.add(label_01);
	}

	public static void setFondMenu(JPanel pan){
		JLabel label_01 = new JLabel("");
		label_01.setIcon(new ImageIcon("./TwinTinBots/img/fondMenu.png"));//mettre image menu
		pan.add(label_01);
	}

	public static void setFondOrdres(JPanel pan)
	{
		JLabel label_01 = new JLabel("");
		label_01.setIcon(new ImageIcon("./TwinTinBots/FondOrdresHaut.png"));//mettre image menu
		pan.add(label_01);
	}

	public static void setFondBas(JPanel pan,int k)
	{
		JLabel label_01 = new JLabel("");
		label_01.setIcon(new ImageIcon("./TwinTinBots/fondOrdres"+(k+2)+".png"));
		pan.add(label_01);
	}
}
