package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map{
	
	String level ;
	
	public void initMap() {
		try {
			BufferedReader br;
			if(level == "map1")
				br = new BufferedReader(new FileReader("src//map1.txt"));
			else
				br = new BufferedReader(new FileReader("src//map2.txt"));
			String c="";
			level="";
			while((c = br.readLine()) != null) {
				level +=c;
				level+="\n";
			}
			br.close();
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public Map(String str) {
		level=str;
		initMap();
	}
	
	public String getLevel() {
		return level;
	}
	
	public void setLevel(String str) {
		level = str;
	}
}
