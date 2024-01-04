package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import main.Help.HelpJPanel;
import main.Men.MenuJPanel;
import main.Sokoban.ScreenAction;
import main.Start.StartJPanel;
import javax.swing.Timer;

public class Gam{ 
	
	public static class Game extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public MenuJPanel Menu;
	private HelpJPanel Help;
	private StartJPanel Start;

	
	public Game() {
		Menu=new MenuJPanel();
		Help=new HelpJPanel();
		Start=new StartJPanel();
		Menu.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F"),"fullscreen");
		Menu.getActionMap().put("fullscreen", new ScreenAction());
		Help.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F"),"fullscreen");
		Help.getActionMap().put("fullscreen", new ScreenAction());
		Start.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F"),"fullscreen");
		Start.getActionMap().put("fullscreen", new ScreenAction());
		getContentPane().add(Menu);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void help() {
		Menu.setVisible(false);
		getContentPane().remove(Menu);
		getContentPane().add(Help);
		Help.setVisible(true);
	}
	
	public void back() {
		Help.setVisible(false);
		getContentPane().remove(Help);
		getContentPane().add(Menu);
		Menu.setVisible(true);
	}
	
	public void Menu() {
		if(Start.getifCompleted()) {
			ActionListener win = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Start.setVisible(false);
                    Start.sethasMap();
            		getContentPane().remove(Start);
            		getContentPane().add(Menu);
            		Menu.setVisible(true);
				}
				
			};
			Timer timer =new Timer(3000, win);
	        timer.setRepeats(false);
	        timer.start();
		}
		else {
			Start.setVisible(false);
            Start.sethasMap();
    		getContentPane().remove(Start);
    		getContentPane().add(Menu);
    		Menu.setVisible(true);
		}
	}
	
	public void start(String map) {
		Menu.setVisible(false);
		getContentPane().remove(Menu);
		Start.sethasMap();
		getContentPane().add(Start);
		Start.setVisible(true);
		Start.setLevel(new Map(map));
	}
	
}
}