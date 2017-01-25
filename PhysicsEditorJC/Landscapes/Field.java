package Landscapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Environment.Landscape;
import Environment.TheWorld;

public class Field implements Landscape
{
	private BufferedImage appearance;
	public Field(int width, int height)
	{
		appearance = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);//constructs the appearance
		Graphics2D g2 = appearance.createGraphics();//takes the "canvas" from the appearance
		g2.setColor(new Color(190,190,190));//chooses the "paintbrush" color
		//0,204,0
		for(int i = 0; i <= width; i++)//for every x pixel on the screen...
			g2.drawLine(i, height, i, getLandscapeHeightAt(i, 0));//...draw a line from the bottom of the screen to the height of the landscape
		g2.setColor(new Color(255,140,0));
		g2.drawArc(100,100,500,500,500,500);
		g2.setColor(new Color(255,160,0));
		g2.fillOval(100,100,500,500);
	}
	@Override
	public int getLandscapeHeightAt(int x, int y) 
	{
		return TheWorld.seaLevel+(int)(50*(Math.sin(x/(50*Math.PI))));
	}

	@Override
	public BufferedImage getAppearance() 
	{
		return appearance;
	}

	@Override
	public double getDyDxAt(int x, int y) 
	{
		return (Math.cos(x/(50*Math.PI))/Math.PI);
	}

	@Override
	public double getFriction(int x, int y) 
	{
		// TODO Auto-generated method stub
		return 1.0;
	}
	
}
