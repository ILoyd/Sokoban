package main;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import main.Start.StartJPanel;

@Category(Start.class)
public class StartTest {
	
	final int LEFT_COLLISION = 1;
    final int RIGHT_COLLISION = 2;
    final int TOP_COLLISION = 3;
    final int BOTTOM_COLLISION = 4;
	StartJPanel start;
	Player p;
	Wall w;
	Box b1,b2;
	Area a1,a2;
	
	@Before
	public void setUp() {
	    start = new StartJPanel();
	}

	
	@Test
	public void LeftWallColl() {
		p=new Player(120,90);
		w=new Wall(90,90);
		start.setSoko(p);
		start.addWallTest(w);
		Assert.assertEquals(true,start.checkWallColl(start.getSoko(),LEFT_COLLISION));
	}
	
	@Test
	public void BotWallColl() {
		p=new Player(90,90);
		w=new Wall(90,150);
		start.setSoko(p);
		start.addWallTest(w);
		Assert.assertEquals(false,start.checkWallColl(start.getSoko(),BOTTOM_COLLISION));
	}

	@Test
	public void RightBoxColl() {
		b1=new Box(120,90);
		b2=new Box(90,90);
		p=new Player(60,90);
		start.addBoxTest(b1,b2);
		start.setSoko(p);
		Assert.assertEquals(true,start.checkBoxColl(RIGHT_COLLISION));
	}
	
	@Test
	public void TopBoxColl() {
		b1=new Box(90,60);
		b2=new Box(90,90);
		p=new Player(90,120);
		start.addBoxTest(b1,b2);
		start.setSoko(p);
		Assert.assertEquals(true,start.checkBoxColl(TOP_COLLISION));
	}
	
	@Test
	public void isCompleted() {
		b1=new Box(90,60);
		b2=new Box(90,90);
		p=new Player(90,120);
		a1=new Area(90,90);
		a2=new Area(120,120);
		start.addBoxTest(b1,b2);
		start.addAreaTest(a1,a2);
		start.setSoko(p);
		start.isCompleted();
		Assert.assertNotSame(start.getifCompleted(), true);
	}
	
	@Test
	public void RestartLevel() {
		b1=new Box(90,60);
		b2=new Box(90,90);
		p=new Player(90,120);
		a1=new Area(90,90);
		a2=new Area(120,120);
		w=new Wall(150,150);
		start.addBoxTest(b1,b2);
		start.addAreaTest(a1,a2);
		start.addWallTest(w);
		start.setSoko(p);
		Assert.assertNotSame(start.getAreasSize(),0);
		Assert.assertNotSame(start.getBoxesSize(),0);
		Assert.assertNotSame(start.getWallsSize(),0);
		start.restartLevel();
		Assert.assertEquals(start.getAreasSize(),0);
		Assert.assertEquals(start.getBoxesSize(),0);
		Assert.assertEquals(start.getWallsSize(),0);
	}
}
