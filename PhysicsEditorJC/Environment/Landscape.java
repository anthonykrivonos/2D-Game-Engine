package Environment;

import java.awt.image.BufferedImage;

public interface Landscape 
{
	int getLandscapeHeightAt(int x, int y);
	BufferedImage getAppearance();
	double getDyDxAt(int x, int y);
	double getFriction(int x, int y);
}