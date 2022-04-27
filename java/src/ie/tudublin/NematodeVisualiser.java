package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{
	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	private int mode;
	public void keyPressed()
	{		
		if (keyCode == LEFT)
		{
		}		
	}


	public void settings()
	{
		size(800, 800);
		loadNematodes();
		
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
	
	public void nemLength(float x, float y, int j){
		pushMatrix();
		translate(x, y + (nematodes.get(j).getLength() *50)/2);
		stroke(255);
		noFill();

		//CIRCLES!!
		if(nematodes.get(j).getLength() > 1){
			for(int i = 1; i <= nematodes.get(j).getLength(); i++){
				circle(i , i - i*50  , 50);
			}
		} else {
			circle(0, 0, 50);
		}

		popMatrix();
	}


	public void draw()
	{	
		float cx = width/2;
		float cy = height/2;
		nemLength(cx, cy, 2);

	}
}
