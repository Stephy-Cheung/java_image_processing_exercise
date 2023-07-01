/**

In this task you will implement the method getColourValue to check the actual intensity value of a pixel of a color image

Note that the colour image is stored is of type TYPE_3BYTE_BGR which stores the blue component first, then the green component and finally the red component. As before, all pixels are stored in a row major 1D array. 



**/

import java.util.Scanner;
public class Lab3 {
	public Lab3() {
		Img img = new Img("example.png");
		System.out.print("Input coordinates: ");
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int[] i = getColourValue(img, x, y);
		System.out.println("Colour value (rgb) at ("+x+","+y+") is "+i[0]+" "+i[1]+" "+i[2]);
	}
	/**
	 * Retrieve the colour value at location (x, y) of the image and
	 * return it as an RGB integer array.
	 * @param img in row major format
	 * @param x coordinate
	 * @param y coordinate
	 * @return the intensity value at (x, y)
	 */
	public int[] getColourValue(Img i, int x, int y) {
		//Your code here
		int position = (x * i.width + y)*3;
		int blue = i.img[position] &0XFF;
		int green = i.img[position+1] &0XFF;
		int red = i.img[position+2] &0XFF;

		return new int[]{red,
						 green,
						 blue};
	}
	public static void main(String[] args) {
		new Lab3();
	}
}
