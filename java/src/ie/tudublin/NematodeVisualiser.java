package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
		
	}

	public void loadNematodes(){
		Table t = loadTable("nematodes.csv", "header");
		for (TableRow r: t.rows()){
			Nematode nematode = new Nematode(r);
			nematodes.add(nematode);
		}
	}
	public void printNematodes(){
		for(Nematode f: nematodes){
			System.out.println(f);
		}
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();				
	}
	


	public void draw()
	{	

	}
}
