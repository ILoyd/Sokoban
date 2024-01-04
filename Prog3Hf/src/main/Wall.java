package main;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Wall extends Element {
	
	public Wall(int x, int y){
		super(x,y);
		initWall();
	}
	
	private void initWall() {
		
		ImageIcon icon=new ImageIcon("src//wall.png");
		Image im=icon.getImage();
		setImage(im);
	}
}
