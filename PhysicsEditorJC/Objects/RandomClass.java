package Objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class RandomClass extends Environment.Object
{
	public RandomClass()
	{
		int bodyWidth=24;
		int bodyHeight=52;
		int outlineThickness=1;
		int headWidth = 20;
		int headHeight = 15;
		int torsoWidth = 14;
		int torsoHeight = 22;
		int armWidth = (bodyWidth-torsoWidth)/2;
		int armsHeight = 18;
		int legWidth = 5;
		int legsHeight = 15;
		int headX = (bodyWidth-headWidth)/2;
		int headY = 0;
		
		setWidth(bodyWidth+1);
		setHeight(bodyHeight+1);
		setX(630);
		setY(400);
		setVx(0.0);
		setVy(0.0);
		bounceConstant = 0.3;
		
		appearance=new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2=appearance.createGraphics();  
		
		//invisible hit-box
		g2.setColor(new Color(255,230,200, 0));
		g2.fillRect(0, 0, bodyWidth, bodyHeight);//colors the face
		//whole body
		g2.drawRect(0, 0, bodyWidth, bodyHeight);//outlines the face
		//head
		g2.setColor(Color.black);
		g2.setStroke(new BasicStroke(outlineThickness));
		g2.drawArc(headX, headY, headWidth, headHeight, 0, 360);
		g2.setColor(Color.white);
		g2.fillOval(headX+1, headY+1, headWidth-1, headHeight-1);
		//visor
		g2.setColor(Color.black);
		g2.fillOval(headX+2, headY+3, headWidth-3, headHeight-3);
		//torso
		g2.setColor(Color.black);
		g2.drawRoundRect(armWidth, headHeight, torsoWidth, torsoHeight, 5, 5);
		g2.setColor(Color.white);
		g2.fillRoundRect(armWidth+1, headHeight+1, torsoWidth-1, torsoHeight-1, 5, 5);
		//arms
		g2.setColor(Color.black);
		g2.drawRoundRect(0, headHeight+2, armWidth, armsHeight, 5, 3);
		g2.drawRoundRect(bodyWidth-armWidth, headHeight+2, armWidth, armsHeight, 5, 3);
		g2.setColor(Color.white);
		g2.fillRoundRect(1, headHeight+2, armWidth-1, armsHeight, 5, 3);
		g2.fillRoundRect(bodyWidth-armWidth+1, headHeight+2, armWidth-1, armsHeight, 5, 3);
		//legs
		g2.setColor(Color.black);
		g2.drawRect(bodyWidth/2-5, 37, legWidth, legsHeight);
		g2.drawRect(bodyWidth/2, 37, legWidth, legsHeight);
		g2.setColor(Color.white);
		g2.fillRect(bodyWidth/2-4, 37, legWidth-1, legsHeight);
		g2.fillRect(bodyWidth/2+1, 37, legWidth-1, legsHeight);
	}
	
	public void hitGround(int groundLevel, double dydx)
	{ 
		double v = Math.sqrt(Math.pow(vx, 2)+Math.pow(vy,2));//calculate velocity
		double angleIncidence = Math.atan(vy/vx);
		if(angleIncidence<0)
			angleIncidence=Math.PI+angleIncidence;
		double angleNormal = Math.atan(dydx);
		double angleReflection = 2*angleNormal-angleIncidence;
		setVx(v*bounceConstant*Math.cos(angleReflection));
		setVy(v*bounceConstant*Math.sin(angleReflection));
		if(Math.abs(getVy())<1)
			setVy(0.0);
		if(Math.abs(getVx())<1)
			setVx(0.0);
	}
}
