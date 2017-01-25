package Environment;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import Landscapes.Field;
import Objects.BouncyBall;
import Objects.RandomClass;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Controls extends JPanel implements KeyListener
{
	TheWorld world;
	
    public Controls(TheWorld world) 
    {
    	this.world = world;
    	
    	JLabel title = new JLabel("PHYSICS EDITOR BY ADVANCED GROUP", JLabel.CENTER);
   		add(title);
    	
    	//SHOW GRAVITY
    	JLabel gravity = new JLabel(printG(world.gravity), JLabel.CENTER);
    	add(gravity);
    	
    	//SWAP GRAVITY
    	JButton gravityUp = new JButton("G-Up");
    	add(gravityUp);
    	gravityUp.addActionListener(new ActionListener()
    	{
    		public synchronized void actionPerformed(ActionEvent e)
    		{
    			world.requestFocusInWindow();
    			world.gravity *= -1;
    			world.accelerationVertical *= -1;
    			gravity.setText(printG(world.gravity));
    		}
    	});
    	//INCREASE GRAVITY
    	JButton gravityIn = new JButton("G+");
    	add(gravityIn);
    	gravityIn.addActionListener(new ActionListener()
    	{
    		public synchronized void actionPerformed(ActionEvent e)
    		{
    			world.requestFocusInWindow();
    			world.gravity -= 0.1;
    			gravity.setText(printG(world.gravity));
    		}
    	});
    	//DECREASE GRAVITY
    	JButton gravityDec = new JButton("G-");
    	add(gravityDec);
    	gravityDec.addActionListener(new ActionListener()
    	{
    		public synchronized void actionPerformed(ActionEvent e)
    		{
    			world.requestFocusInWindow();
    			world.gravity += 0.1;
    			gravity.setText(printG(world.gravity));
    		}
    	});
    	//SET ZERO GRAVITY
    	JButton gravityZero = new JButton("0-G");
    	add(gravityZero);
    	gravityZero.addActionListener(new ActionListener()
    	{
    		public synchronized void actionPerformed(ActionEvent e)
    		{
    			world.requestFocusInWindow();
    			world.gravity = 0;
    			gravity.setText(printG(world.gravity));
    		}
    	});
    }
    
     @Override
 public synchronized void keyPressed(KeyEvent arg0) 
 { 
	 if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) 
		 world.rightHeld=true;
	 if(arg0.getKeyCode()==KeyEvent.VK_LEFT) 
		 world.leftHeld=true;
	 if(arg0.getKeyCode()==KeyEvent.VK_UP) 
		 world.upHeld=true;
//	 if(arg0.getKeyCode()==KeyEvent.VK_DOWN) 
//		 world.downHeld=true;
 }

 @Override
 public synchronized void keyReleased(KeyEvent arg0) 
 {
	 if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) 
		 world.rightHeld=false;
	 if(arg0.getKeyCode()==KeyEvent.VK_LEFT) 
		 world.leftHeld=false;
	 if(arg0.getKeyCode()==KeyEvent.VK_UP) 
		 world.upHeld=false;
 }

 @Override
 public synchronized void keyTyped(KeyEvent arg0) 
 {
	 
 }
 
 public static String printG (double g)
 {
 	if (g == 0 || g == -0)
 		return "" + 0;
 	if (g < 0)
 		return ("" + Math.abs(g)).substring(0,3);
 	return ("-" + g).substring(0,3);
 }
}