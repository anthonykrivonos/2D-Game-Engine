package Environment;


import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
/**
 * Anything that can be drawn in our "world" is an "Object." You will notice they all extend this class
 * @author bnockles
 */
public class Object 
{
 protected int width;
 protected int height;
 protected int x;//xPosition
 protected int y;//yPosition
 protected int collisionLeft;
 protected int collisionRight;
 protected double vx;//xVelocity
 protected double vy;//yVelocity
 protected double ax;//xAcceleration
 protected double ay;//yAcceleration
 protected double angle;
 protected BufferedImage appearance;
 
 protected double bounceConstant;
 
 public int getWidth() 
 {
	 return width;
 }
 public void setWidth(int width) 
 {
	 this.width = width;
 }
 public int getHeight() 
 {
	 return height;
 }
 public void setHeight(int height) 
 {
	 this.height = height;
 }
 public int getX() 
 {
	 return x;
 }
 public void setX(int x) 
 {
	 this.x = x;
 }
 //important: this method changes the coordinate system from a negative to a positive
 public int getElevation() 
 {
	 return TheWorld.seaLevel-y;
 }
 public int getY() 
 {
	 return y;
 }
 public void setY(int y) 
 {
	 this.y = y;
 }
 /*
 public int getCollisionLeft() 
 {
	 return this.collisionLeft;
 }
 public int getCollisionRight() 
 {
	 return this.collisionRight;
 }
 public void setCollisionLeft(int left) 
 {
	 this.collisionLeft = left;
 }
 public void setCollisionRight(int right) 
 {
	 this.collisionRight = right;
 }*/
 /**
  * the following method will always draw an object right-side-up. You will need
  * to override this method if you want an object to be drawn at different angles.
  */
 public void draw (Graphics2D g2)
 {
	 AffineTransform old = g2.getTransform();
	 g2.rotate(getAngle(),x+width/2,TheWorld.seaLevel-y-getHeight()*Math.abs(Math.sin(getAngle())));
	 g2.drawImage(getAppearance(), x, y-getHeight(), null);
	 g2.setTransform(old);
 }
 
 public BufferedImage getAppearance() 
 {
	 return appearance;
 }
 public void setAppearance(BufferedImage appearance) 
 {
	 this.appearance = appearance;
 }
 public double getVx() 
 {
	 return vx;
 }
 public void setVx(double vx) 
 {
	 setAx(vx-this.vx);
	 this.vx = vx;
 }
 public double getVy() 
 {
	 return vy;
 }
 public void setVy(double vy) 
 {
	 setAy(vy-this.vy);
	 this.vy = vy;
 }
 public double getAx() 
 {
	 return ax;
 }
 public void setAx(double ax) 
 {
	 this.ax = ax;
 }
 public double getAy() 
 {
	 return ay;
 }
 public void setAy(double ay) 
 {
	 this.ay = ay;
 }
 /**
  * this method is called by the environment when the object hits the ground
  * it returns a double which is the velocity after hitting the ground.
  * Objects that bounce may override this method to return a positive velocity
  * otherwise the object will smack into the ground and have velocity 0.0
  * @param dydx 
  * @return
  */
 public void hitGround(int groundLevel, double dydx)
 {
	 //TODO: Enter a code for any object to follow when it hits the ground
 }
 public void updatePosition(int i) 
 {
	 x = (int)(x + vx);
	 y = (int)(y + vy);
 }
 public double getAngle() 
 {
	 return angle;
 }
 public void setAngle(double angle) 
 {
	 this.angle = angle;
 }
 
 
 
}
