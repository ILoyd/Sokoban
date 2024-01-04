package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import main.Gam.Game;

public class Sokoban{
	
	public static Game game;
	
	public static class HelpListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			game.help();
		}
	}
	
	public static class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			game.Menu();
		}
		
	}
	
	public static class BackListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			game.back();
		}
		
	}
	
	public static class StartListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			game.start(game.Menu.map.getSelectedItem().toString());
		}
		
	}
	
	public static class ScreenAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
        	if(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getFullScreenWindow()!=null)
        		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(null);
        	else{
        		game.setExtendedState(JFrame.MAXIMIZED_BOTH);
        		GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(game);
        	}
            
        }
	}
	
	public static class CloseListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
		
	public static void main(String[] args){
		EventQueue.invokeLater(() -> {       
            game = new Game();
            game.setVisible(true);
            game.setTitle("Sokoban");
    		game.setMinimumSize(new Dimension(1920,1080));
    		game.setResizable(true);
    		game.setVisible(true);
        });
	}
}
