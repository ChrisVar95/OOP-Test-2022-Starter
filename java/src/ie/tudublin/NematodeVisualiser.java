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

	//draws a male
	public void drawMale(float x, float y){
		pushMatrix();
		translate(x, y);
		stroke(255);
		noFill();

		line(0, 0, 0, -25);
		circle(0, 5, 10);
		popMatrix();
	}
	//draws a female()
	public void drawFemale(float x, float y){
		pushMatrix();
		translate(x, y);
		stroke(255);
		noFill();

		circle(0, 0, 25);
		popMatrix();
	}
	//draws eyes
	public void drawEyes(float x, float y){
		pushMatrix();
		translate(x, y);
		stroke(255);
		noFill();

		line(50, -10, sin(y)*25, cos(y)*25);
		line(-50, -10, sin(-y)*25, cos(-y)*25);
		circle(-55, -15, 10);
		circle(55, -15, 10);
		popMatrix();
	}

	public void nemLength(float x, float y, int j){
		pushMatrix();
		int len = nematodes.get(j).getLength();
		translate(x, y + (len *50)/2);
		stroke(255);
		noFill();
		
		//EYES
		if(nematodes.get(j).isEyes()){
			drawEyes(0,  -y+ (len *75));
		}
		//CIRCLES!!
		for(int i = 1; i <= len; i++){
			circle(0 , - i*50  , 50);
			//LIMBS
			if(nematodes.get(j).isLimbs()){
				line(-50, - i*50, -25, - i*50);//limbs left
				line(+50, - i*50, +25, - i*50);//limbs right
			}
		}
		//GENDERS
		if(nematodes.get(j).getGender().equals("m")){
			//System.out.print("I am here");
			drawMale(0, 0);
		}
		else if(nematodes.get(j).getGender().equals("f")){
			drawFemale(0, -50);
		}
		else if(nematodes.get(j).getGender().equals("h")){
			drawMale(0, 0);
			drawFemale(0, -50);
		}
		
	

		

		popMatrix();
	}


	public void draw()
	{	
		float cx = width/2;
		float cy = height/2;
		nemLength(cx, cy, 0);

	}
}
