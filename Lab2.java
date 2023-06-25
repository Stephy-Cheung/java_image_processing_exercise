/**

In this task you will implement the method setOdd of the class Lab2 which will set all intensity values with odd coordinates to white (255), all others will be set to black (0). An odd coordinate is defined as a coordinate that has and odd x value or an odd y value.

The expected output is provided in the file solution.png.

**/

import java.util.Scanner;
public class Lab2 { 
	public Lab2() {
		Img img = new Img("Fig0314a.png");
		setOdd(img);
		img.save();
	}
	/**
	 * Sets all odd coordinates to 255 and others to 0.
	 * @param img in row major format
	 */
	public void setOdd(Img i) {
		
		for (int r = 0; r < i.height; r++) {

			for (int c = 0; c < i.width; c++){

				int position = r*i.width + c;

				if ((r % 2 == 1) || (c % 2== 1)){
					i.img[position] = (byte) 255;
				}
				else{
					i.img[position] = (byte) 0;
				}

			}
		} 

	}
	
	public static void main(String[] args) {
		new Lab2();
	}

}