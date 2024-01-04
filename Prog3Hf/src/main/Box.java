package main;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Box extends Element {

	public Box(int x, int y) {
		super(x,y);
		initBox();
	}
	
	public void initBox() {
		ImageIcon icon=new ImageIcon("src//box.png");
		Image im=icon.getImage();
		setImage(im);
	}
	
	public void move(int x, int y) {
		setX(getX()+x);
		setY(getY()+y);
	}
}
