package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import main.Sokoban.MenuListener;

public class Start {

	public static class StartJPanel extends JPanel{
		private static final long serialVersionUID = 1L;
		
		private Image image;
		private JButton back;
		
		private int OFFSET = 40;
	    private int SPACE = 30;
	    
	    private final int LEFT_COLLISION = 1;
	    private final int RIGHT_COLLISION = 2;
	    private final int TOP_COLLISION = 3;
	    private final int BOTTOM_COLLISION = 4;
	    
	    private ArrayList<Box> boxes;
	    private ArrayList<Wall> walls;
	    private ArrayList<Area> areas;
	    
	    private Player soko;
	    
	    private boolean isCompleted = false;
	    
	    private Map level;
	    
	    private boolean hasMap = false;
	    
	    public boolean getifCompleted() {
	    	return isCompleted;
	    }
	    
	    public int getBoxesSize(){
	    	return boxes.size();
	    }
	    
	    public int getAreasSize(){
	    	return areas.size();
	    }
	    
	    public int getWallsSize(){
	    	return walls.size();
	    }
	    
	    public void setLevel(Map m) {
	    	level=m;
	    }
	    
	    public void sethasMap() {
	    	hasMap=false;
	    	isCompleted = false;
	    }
	    
	    public void addWallTest(Wall ele) {
	    	walls=new ArrayList<>();
	    	walls.add(ele);
	    }
	    
	    public void addBoxTest(Box ele, Box ele2) {
	    	boxes=new ArrayList<>();
	    	boxes.add(ele);
	    	boxes.add(ele2);
	    }
	    
	    public void addAreaTest(Area ele, Area ele2) {
	    	areas=new ArrayList<>();
	    	areas.add(ele);
	    	areas.add(ele2);
	    }
	    
	    public Player getSoko() {
	    	return soko;
	    }
	    
	    public void setSoko(Player ele) {
	    	soko=ele;
	    }
	    
	    public StartJPanel() {
	    	setFocusable(true);
	    	setOpaque(false);
	    	initWorld();
	    	getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP,0),"up arrow");
	    	getActionMap().put("up arrow", new UpKey());
	    	getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0),"down arrow");
	    	getActionMap().put("down arrow", new DownKey());
	    	getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0),"right arrow");
	    	getActionMap().put("right arrow", new RightKey());
	    	getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0),"left arrow");
	    	getActionMap().put("left arrow", new LeftKey());
	    	getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_R,0),"restart");
	    	getActionMap().put("restart", new RestartKey());
	    }
	    
	    private class UpKey extends AbstractAction {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed(ActionEvent e) {
				if(checkWallColl(soko, TOP_COLLISION)) {
        			return;
        		}
        		if(checkBoxColl(TOP_COLLISION)) {
        			return;
        		}
        		soko.move(0,-SPACE);
        		repaint();
			}
	    }
	    
	    private class DownKey extends AbstractAction {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed(ActionEvent e) {
				if(checkWallColl(soko, BOTTOM_COLLISION)) {
        			return;
        		}
        		if(checkBoxColl(BOTTOM_COLLISION)) {
        			return;
        		}
        		soko.move(0,SPACE);
        		repaint();
			}
	    }
	    
	    private class RightKey extends AbstractAction {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed(ActionEvent e) {
				if(checkWallColl(soko, RIGHT_COLLISION)) {
        			return;
        		}
        		if(checkBoxColl(RIGHT_COLLISION)) {
        			return;
        		}
        		soko.move(SPACE,0);
        		repaint();
			}
	    }
	    
	    private class LeftKey extends AbstractAction {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed(ActionEvent e) {
				if(checkWallColl(soko, LEFT_COLLISION)) {
        			return;
        		}
        		if(checkBoxColl(LEFT_COLLISION)) {
        			return;
        		}
        		soko.move(-SPACE,0);
        		repaint();
			}
	    }
	    
	    private class RestartKey extends AbstractAction {
			private static final long serialVersionUID = 1L;

			@Override
	        public void actionPerformed(ActionEvent e) {
				restartLevel();
        		repaint();
			}
	    }
		
	    public void setImage(Image im) {
	    	image=im;
	    }
		
	    public void initWorld() {
			ImageIcon icon=new ImageIcon("src//background.png");
			Image im= icon.getImage();
			setImage(im);
			ImageIcon image = new ImageIcon("src//btn@0,5x.png");
			back = new JButton("MENÜ",image);
			back.setFont(new Font("Courier New", Font.BOLD, 40));
			back.setBorderPainted(false);
			back.setFocusPainted(false);
			back.setContentAreaFilled(false);
			back.setForeground(Color.white);
			back.setHorizontalTextPosition(JButton.CENTER);
			back.setVerticalTextPosition(JButton.CENTER);
			back.addActionListener(new MenuListener());
			back.setFocusable(false);
			add(back);
		}
		
		public void initMap() {
			walls = new ArrayList<>();
			boxes = new ArrayList<>();
			areas = new ArrayList<>();
			
			int x = OFFSET;
			int y = OFFSET;
			
			Wall wall;
			Box box;
			Area area;
			
			for(int i = 0; i< level.getLevel().length(); i++ ) {
				char item = level.getLevel().charAt(i);
				
				switch(item) {
					case '\n':
						y+= SPACE;
						x = OFFSET;
						break;
					case '#':
						wall = new Wall(x,y);
						walls.add(wall);
						x+= SPACE;
						break;
					case '$':
						box = new Box(x,y);
						boxes.add(box);
						x+=SPACE;
						break;
					case '.':
						area = new Area(x,y);
						areas.add(area);
						x+=SPACE;
						break;
					case '@':
						soko = new Player(x,y);
						x+=SPACE;
						break;
					case ' ':
						x+=SPACE;
						break;
					default:
						break;
				}
			}
		}
		
		private void  buildMap(Graphics g) {
			if(!hasMap)
				initMap();
			g.setColor(new Color(0,0,0,150));
			g.fillRect(600,300, 680, 400);
			
			 ArrayList<Element> world = new ArrayList<>();
			 
			 world.addAll(walls);
		     world.addAll(areas);
		     world.addAll(boxes);
		     world.add(soko);
		     
		     for (int i = 0; i < world.size(); i++) {
		    	 	hasMap=true;
		            Element item = world.get(i);

		            if (item instanceof Player || item instanceof Box) {
		                
		                g.drawImage(item.getImage(), item.getX()+600, item.getY()+300, this);
		            } else {
		                
		                g.drawImage(item.getImage(), item.getX()+600, item.getY()+300, this);
		            }

		            if (isCompleted) {
		                
		                g.setColor(new Color(0, 0, 0));
		                g.drawString("Teljesítve", 25, 20);
		                Sokoban.game.Menu();
		            }
		        }			
		}
		
		protected void paintComponent(Graphics g) {   
			super.paintComponents(g);
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		    buildMap(g);
		}
		
		public boolean checkWallColl(Element ele, int type) {

	        switch (type) {
	            case LEFT_COLLISION:	                
	                for (int i = 0; i < walls.size(); i++) {	                    
	                    Wall wall = walls.get(i);	                    
	                    if (ele.isLeftColl(wall)) {	                        
	                        return true;
	                    }
	                }	                
	                return false;
	                
	            case RIGHT_COLLISION:	                
	                for (int i = 0; i < walls.size(); i++) {	                    
	                    Wall wall = walls.get(i);	                    
	                    if (ele.isRightColl(wall)) {
	                        return true;
	                    }
	                }	                
	                return false;
	                
	            case TOP_COLLISION:	                
	                for (int i = 0; i < walls.size(); i++) {	                    
	                    Wall wall = walls.get(i);	                    
	                    if (ele.isTopColl(wall)) {	                        
	                        return true;
	                    }
	                }                
	                return false;
	                
	            case BOTTOM_COLLISION:	                
	                for (int i = 0; i < walls.size(); i++) {	                    
	                    Wall wall = walls.get(i);	                    
	                    if (ele.isBottomColl(wall)) {	                       
	                        return true;
	                    }
	                }	                
	                return false;	                
	            default:
	                break;
	        }	        
	        return false;
	    }
		
		public boolean checkBoxColl(int type) {
	        switch (type) {            
	            case LEFT_COLLISION:               
	                for (int i = 0; i < boxes.size(); i++) {
	                    Box b = boxes.get(i);
	                    if (soko.isLeftColl(b)) {
	                        for (int j = 0; j < boxes.size(); j++) {	                            
	                            Box item = boxes.get(j);	                            
	                            if (!b.equals(item)) {	                                
	                                if (b.isLeftColl(item)) {
	                                    return true;
	                                }
	                            }                           
	                            if (checkWallColl(b, LEFT_COLLISION)) {
	                                return true;
	                            }
	                        }                        
	                        b.move(-SPACE, 0);
	                        isCompleted();
	                    }
	                }            
	                return false;
	                
	            case RIGHT_COLLISION:	                
	                for (int i = 0; i < boxes.size(); i++) {
	                    Box b = boxes.get(i);	                    
	                    if (soko.isRightColl(b)) {	                        
	                        for (int j = 0; j < boxes.size(); j++) {
	                            Box item = boxes.get(j);                            
	                            if (!b.equals(item)) {  
	                                if (b.isRightColl(item)) {
	                                    return true;
	                                }
	                            }	                            
	                            if (checkWallColl(b, RIGHT_COLLISION)) {
	                                return true;
	                            }
	                        }                        
	                        b.move(SPACE, 0);
	                        isCompleted();
	                    }
	                }
	                return false;
	                
	            case TOP_COLLISION:	                
	                for (int i = 0; i < boxes.size(); i++) {
	                    Box b = boxes.get(i);	              
	                    if (soko.isTopColl(b)) {	                        
	                        for (int j = 0; j < boxes.size(); j++) {
	                            Box item = boxes.get(j);
	                            if (!b.equals(item)) { 
	                                if (b.isTopColl(item)) {
	                                    return true;
	                                }
	                            }	                            
	                            if (checkWallColl(b, TOP_COLLISION)) {
	                                return true;
	                            }
	                        }
	                        b.move(0, -SPACE);
	                        isCompleted();
	                    }
	                }
	                return false;
	                
	            case BOTTOM_COLLISION:
	                for (int i = 0; i < boxes.size(); i++) {
	                    Box b = boxes.get(i);	                    
	                    if (soko.isBottomColl(b)) {	                        
	                        for (int j = 0; j < boxes.size(); j++) {
	                            Box item = boxes.get(j);	                            
	                            if (!b.equals(item)) {	                                
	                                if (b.isBottomColl(item)) {
	                                    return true;
	                                }
	                            }	                            
	                            if (checkWallColl(b,BOTTOM_COLLISION)) {	                                
	                                return true;
	                            }
	                        }	                        
	                        b.move(0, SPACE);
	                        isCompleted();
	                    }
	                }	                
	                break;
	                
	            default:
	                break;
	        }

	        return false;
	    }
		
		public void isCompleted() {

	        int nOfBoxes = boxes.size();
	        int finishedBags = 0;

	        for (int i = 0; i < nOfBoxes; i++) {
	            
	            Box b = boxes.get(i);
	            
	            for (int j = 0; j < nOfBoxes; j++) {
	                
	                Area area =  areas.get(j);
	                
	                if (b.getX() == area.getX() && b.getY() == area.getY()) {
	                    
	                    finishedBags += 1;
	                }
	            }
	        }

	        if (finishedBags == nOfBoxes) {	            
	            isCompleted = true;
	            repaint();
	        }
	    }
		
		public void restartLevel() {

	        areas.clear();
	        boxes.clear();
	        walls.clear();

	        hasMap=false;
	        initWorld();

	        if (isCompleted) {
	            isCompleted = false;
	        }
	    }
	}
}
