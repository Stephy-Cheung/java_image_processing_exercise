/**

This task you will implement the boxFilter which applies the box smooth filter on the image i. 

Boundary case pixel will be unchanged. 

**/

import java.util.Scanner;

import javax.swing.text.Position;

import java.time.Instant;
import java.time.Duration;
public class Lab3 {
	public Lab3() {
		Img img = new Img("Fig0441.png");
		System.out.print("Size: ");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		Instant start = Instant.now();
		boxFilter(img, size);
		Instant stop = Instant.now();
		System.out.println("Elapsed time: "+Duration.between(start, stop).toMillis()+"ms");
		img.save();
	}
	
	public void boxFilter(Img i, int size) {

		// create image copy 
		byte[] img_copy = new byte[i.img.length];
		System.arraycopy(i.img, 0, img_copy, 0, i.img.length);
		int boundary_size = size/2;

		for (int r = boundary_size; r < i.height-boundary_size; r++) {
			for (int c = boundary_size; c < i.width-boundary_size; c++){
				
				// for each pixel, loop through the pixel 
				int sum = 0; 
				for (int filterr = r-boundary_size; filterr <= (r+boundary_size); filterr++){
					for (int filterc = c-boundary_size; filterc <= (c+boundary_size); filterc++){
						int position = filterr *i.width + filterc;
						sum += (int) (img_copy[position] &0XFF); 
					}
				
				}
				i.img[r*i.width + c] = (byte) Math.round(sum/ (size*size));
				
			}
		}


		
	}
		
	public static void main(String[] args) {
		new Lab3();
	}
}
