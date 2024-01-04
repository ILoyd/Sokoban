package main;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Help.HelpJPanel;
import main.Start.StartJPanel;

public class HelpTest {

	HelpJPanel help;
	String[] szoveg= {"","","",""};
	
	@Before
	public void setUp() {
		help = new HelpJPanel();
		help.HelpTextRead(szoveg);
	} 
	
	@Test
	public void HelpTextNotNull() {
		for(int i=0; i<szoveg.length;i++) {
		Assert.assertNotSame("", szoveg[i]);
		}
	}
	
	@Test
	public void HelpTextContent() {
		Assert.assertEquals("Leírás:",szoveg[0]);
		Assert.assertEquals("A Sokoban (magyarul raktárosnak is hívják) egy olyan logikai játék melyben a játékosnak ládákat kell mozgatnia a megadott helyekre. A játék gyakorlatilag egy „dobozban” játszódik, melyben X darab ládát kell X darab pozícióba elhelyezni a pálya teljesítéséhez. Egy adott pályán a dobozokat a megadott pontokba kell tologatni. A játék nehézségét az jelenti, hogy dobozokat nem lehet húzni és egyszerre csak egy dobozt tud a játékos mozgatni. Illetve a pálya kialakításától is függ, mert ha egy dobozt rossz helyre tol, kezdheti újra a pályát.",szoveg[1]);
		Assert.assertEquals("Billentyûk:",szoveg[2]);
		Assert.assertEquals("A mozgás a kurzor billentyûkkel lesz lehetséges, illetve az „R” gomb megnyomásával lesz lehetõség a pálya újrakezdésére. Az „F” gomb megnyomásával lehet váltani teljes képernyõs nézetbe és vissza.",szoveg[3]);
	}

}
