package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Sokoban.HelpListener;
import main.Sokoban.StartListener;
import main.Sokoban.CloseListener;

public class Men {
	
	public static class MenuJPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		private JButton start;
		private JButton help;
		private JButton exit;
		private Image image;
		public JComboBox<String> map;
		private JLabel title;
		
		public void setImage(Image im) {
			image=im;
		}
		
		private void initMenu() {
			ImageIcon image = new ImageIcon("src//btn@0,5x.png");
			start = new JButton("START",image);
			help = new JButton("SEGÍTSÉG",image);
			exit = new JButton("KILÉPÉS",image);
			ImageIcon icon=new ImageIcon("src//background.png");
			Image im= icon.getImage();
			setImage(im);
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			start.setBorderPainted(false);
			start.setFocusPainted(false);
			start.setContentAreaFilled(false);
			start.setFont(new Font("Courier New", Font.BOLD, 40));
			start.setForeground(Color.white);
			start.setHorizontalTextPosition(JButton.CENTER);
			start.setVerticalTextPosition(JButton.CENTER);
			start.addActionListener(new StartListener());
			help.setBorderPainted(false);
			help.setFocusPainted(false);
			help.setContentAreaFilled(false);
			help.setFont(new Font("Courier New", Font.BOLD, 40));
			help.setForeground(Color.white);
			help.setHorizontalTextPosition(JButton.CENTER);
			help.setVerticalTextPosition(JButton.CENTER);
			help.addActionListener(new HelpListener());
			exit.setBorderPainted(false);
			exit.setFocusPainted(false);
			exit.setContentAreaFilled(false);
			exit.setFont(new Font("Courier New", Font.BOLD, 40));
			exit.setForeground(Color.white);
			exit.setHorizontalTextPosition(JButton.CENTER);
			exit.setVerticalTextPosition(JButton.CENTER);
			exit.addActionListener(new CloseListener());
			String str[]= {"map1","map2"};
			map=new JComboBox<String>(str);
			map.setBackground(Color.BLACK);
			map.setFont(new Font("Arial", Font.PLAIN, 20));
			map.setForeground(Color.white);
			map.setEditable(false);
			map.setMaximumSize(new Dimension(150,50));
			title=new JLabel("Sokoban");
			title.setFont(new Font("Courier New", Font.BOLD, 80));
			c.gridx=0;
			c.gridy=0;
			c.ipady=40;
			c.gridwidth = 2;
			c.weightx = 1;
			add(title,c);
			
			c.gridwidth = 1;
			c.weightx = 0.475;
			c.ipady = 20;
			c.gridx = 0;
			c.gridy = 1;
			c.anchor=GridBagConstraints.EAST;
			add(map,c);
			
			c.gridwidth = 1;
			c.weightx = 0.525;
			c.ipady = 20;
			c.gridx = 1;
			c.gridy = 1;
			c.anchor=GridBagConstraints.WEST;
			add(start,c);
			
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 2;
			c.weightx=1;
			c.anchor=GridBagConstraints.CENTER;
			add(help,c);
			
			c.gridx = 0;
			c.gridy = 3;
			c.gridwidth = 2;
			c.weightx=1;
			c.anchor=GridBagConstraints.CENTER;
			add(exit,c);
		}

		protected void paintComponent(Graphics g) {
			super.paintComponents(g);
		    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
		
		public MenuJPanel(){
			initMenu();
			setOpaque(false);
		}
	
	}
}
