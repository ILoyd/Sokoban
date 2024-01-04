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
		Assert.assertEquals("Le�r�s:",szoveg[0]);
		Assert.assertEquals("A Sokoban (magyarul rakt�rosnak is h�vj�k) egy olyan logikai j�t�k melyben a j�t�kosnak l�d�kat kell mozgatnia a megadott helyekre. A j�t�k gyakorlatilag egy �dobozban� j�tsz�dik, melyben X darab l�d�t kell X darab poz�ci�ba elhelyezni a p�lya teljes�t�s�hez. Egy adott p�ly�n a dobozokat a megadott pontokba kell tologatni. A j�t�k neh�zs�g�t az jelenti, hogy dobozokat nem lehet h�zni �s egyszerre csak egy dobozt tud a j�t�kos mozgatni. Illetve a p�lya kialak�t�s�t�l is f�gg, mert ha egy dobozt rossz helyre tol, kezdheti �jra a p�ly�t.",szoveg[1]);
		Assert.assertEquals("Billenty�k:",szoveg[2]);
		Assert.assertEquals("A mozg�s a kurzor billenty�kkel lesz lehets�ges, illetve az �R� gomb megnyom�s�val lesz lehet�s�g a p�lya �jrakezd�s�re. Az �F� gomb megnyom�s�val lehet v�ltani teljes k�perny�s n�zetbe �s vissza.",szoveg[3]);
	}

}
