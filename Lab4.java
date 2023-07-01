/**

In this task you will implement the method medianFilter of the class Lab4 which applies the median filter on the image. 

You should handle the boundary case by keeping the pixels unchanged. 

The expected output is provided in the files solution3.png and solution7.png.

**/

import java.util.Arrays;
import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;
public class Lab4 {
	public Lab4() {
		Img img = new Img("Fig0441.png");
		System.out.print("Size: ");
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		Instant start = Instant.now();
		medianFilter(img, size);
		Instant stop = Instant.now();
		//System.out.println("Elapsed time: "+Duration.between(start, stop).toMillis()+"ms");
		img.save();
	}

	public void medianFilter(Img i, int size) {
		// create image copy 
		byte[] img_copy = new byte[i.img.length];
		System.arraycopy(i.img, 0, img_copy, 0, i.img.length);
		int boundary_size = size/2;

		for (int r = boundary_size; r < i.height-boundary_size; r++) {
			for (int c = boundary_size; c < i.width-boundary_size; c++){
				
				// for each pixel, loop through the pixel 
				byte[] filter_intensity =  new byte[size*size]; 
				int counter = 0;
				for (int filterr = r-boundary_size; filterr <= (r+boundary_size); filterr++){
					for (int filterc = c-boundary_size; filterc <= (c+boundary_size); filterc++){
						int position = filterr *i.width + filterc;
						filter_intensity[counter] = (byte) img_copy[position];
						counter++;
					}
				}
				
				Arrays.sort(filter_intensity);
				int n = filter_intensity.length;

				if (n % 2 ==1 ){
					i.img[r*i.width + c] = (byte) (filter_intensity[(n+1)/2-1]);
				}
				else{
					i.img[r*i.width + c] = (byte) ((filter_intensity[n/2-1]+filter_intensity[n/2])/2);
				}
				
				
			}
		}
		}

		
	public static void main(String[] args) {
		new Lab4();
	}
}
