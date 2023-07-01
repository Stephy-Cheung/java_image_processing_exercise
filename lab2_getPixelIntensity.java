/** 

In this task you will implement the method getIntensityValue. 
The & in line 10 is a bitwise AND operation. 

When implementing getIntensityValue function, it uses a coordinate system where the x axis is vertical and the y is horizontal. This is important when transforming a 2D coordinate value to a 1D lookup in the byte array. 


**/

import java.util.Scanner;
public class Lab1 {
	public Lab1() {
		Img img = new Img("Fig0314a.png");
		System.out.print("Input coordinates: ");
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int i = getIntensityValue(img, x, y);
		System.out.println("Intensity at ("+x+","+y+") is "+i);
	}
	/**
	 * Retrieve the intensity value at location (x, y) of the image and return it
	 * @param img in row major format
	 * @param x coordinate
	 * @param y coordinate
	 * @return the intensity value at (x, y)
	 */
	public int getIntensityValue(Img i, int x, int y) {

		int position = x * i.width + y;
		int intensity = (int) (i.img[position] &0XFF) ;
		return intensity ;
	}
	public static void main(String[] args) {
		new Lab1();
	}
}
