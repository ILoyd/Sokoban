package main;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Player extends Element{
	
	public Player(int x, int y){
		super(x,y);
		initPla();
	}
	
	public void initPla() {
		ImageIcon icon=new ImageIcon("src//player.png");
		Image im=icon.getImage();
		setImage(im);
	}
	
	public void move(int x, int y) {
		setX(getX()+x);
		setY(getY()+y);
	}
}
