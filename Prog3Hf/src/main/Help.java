package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;

import main.Sokoban.BackListener;

public class Help {
	
	public static class HelpJPanel extends JPanel{
		
		private JLabel title;
		private JLabel text;
		private Image image;
		private JButton back;
		
		private static final long serialVersionUID = 1L;
		
		public void setImage(Image im) {
			image=im;
		}
		
		public void initHelp(){
			ImageIcon icon=new ImageIcon("src//help2.png");
			Image im= icon.getImage();
			setImage(im);
			try {
				ImageIcon image = new ImageIcon("src//btn@0,5x.png");
				back = new JButton("VISSZA",image);
			} catch (Exception ex) {
			    System.out.println(ex);
			}
			back.setFont(new Font("Courier New", Font.BOLD, 40));
			back.setBorderPainted(false);
			back.setFocusPainted(false);
			back.setContentAreaFilled(false);
			back.setForeground(Color.white);
			back.setHorizontalTextPosition(JButton.CENTER);
			back.setVerticalTextPosition(JButton.CENTER);
			title= new JLabel("Játék információk / Segítség", JLabel.CENTER);
			title.setFont(new Font("Courier New", Font.BOLD, 50));
			String[] szoveg= {"","","",""};
			HelpTextRead(szoveg);
			text = new JLabel();
			text.setFont(new Font("Courier New", Font.PLAIN, 20));
			for(int i=0;i< szoveg.length;i++) {
				switch(i) {
					case 0:
						text.setText((text.getText()+"<html><br/><html/>"+szoveg[i]).toUpperCase()+"<html><br/><html/>");
						break;
					case 1:
						text.setText(text.getText()+"<html><br/><html/>"+szoveg[i]);
						break;
					case 2:
						text.setText(text.getText()+"<html><br/><html/><html><br/><html/>"+szoveg[i].toUpperCase()+"<html><br/><html/>");
						break;
					case 3:
						text.setText(text.getText()+"<html><br/><html/>"+szoveg[i]);
						break;
				}
			}
			
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
				
				c.gridwidth = 1;
				c.weightx = 1.0;
				c.ipady = 40;
				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(100,0,0,0);
				add(title,c);
				
				c.gridwidth = 1;
				c.weightx = 1.0;
				c.ipady = 40;
				c.gridy = 1;
				c.fill = GridBagConstraints.HORIZONTAL;
				c.insets = new Insets(100,200,0,200);
				add(text,c);
				
				c.weightx= 0.5;
				c.ipady = 20;
				c.weighty = 1.0;
				c.gridwidth = 2;
				c.gridy = 2;
				c.insets = new Insets(0,680,0,680);
				add(back, c);
			back.addActionListener(new BackListener());
		}

		protected void HelpTextRead(String[] szoveg) {
			try {
				File file= new File("src\\help.txt");
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
				String c;
				int i=0;
				while((c = br.readLine()) != null) {
					szoveg[i]=c;
					i++;
				}
				br.close();
			}catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		public HelpJPanel(){
			initHelp();
			setOpaque(false);
		}
		
		protected void paintComponent(Graphics g) {
		       super.paintComponents(g);
		       g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		}
		
	}
}
