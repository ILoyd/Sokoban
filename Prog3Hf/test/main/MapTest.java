package main;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import junit.framework.Assert;

public class MapTest {

	Map palya;
	Map palya2;
	
	@Test
	public void InputException() throws IOException{
		palya=new Map("palya");
	}
	
	@Test
	public void MapsNotSame() {
		palya=new Map("map1");
		palya2=new Map("map2");
		Assert.assertNotSame(palya.getLevel(), palya2.getLevel());
	}
}
