package main;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Area extends Element{
	
	public Area(int x, int y) {
		super(x,y);
		initArea();
	}
	
	public void initArea() {
		ImageIcon icon=new ImageIcon("src//area.png");
		Image im= icon.getImage();
		setImage(im);
	}
}
