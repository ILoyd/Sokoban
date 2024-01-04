package main;

import java.awt.Image;

public class Element {

	private int SPACE = 30;
	private int x;
	private int y;
	private Image image;
	
	public Element(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Image getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y=y;
	}
	
	public void setImage(Image im) {
		image=im;
	}
	
	public boolean isLeftColl(Element ele) {
		return getX()-SPACE == ele.getX() && getY() == ele.getY();
	}
	
	public boolean isRightColl(Element ele) {
		return getX()+SPACE == ele.getX() && getY() == ele.getY();
	}

	public boolean isTopColl(Element ele) {
		return getY()-SPACE == ele.getY() && getX() == ele.getX();
	}
	
	public boolean isBottomColl(Element ele) {
		return getY()+SPACE == ele.getY() && getX() == ele.getX();
	}
}
