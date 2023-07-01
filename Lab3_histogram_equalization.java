/**

This task implements the histogram equalization by first creating the mapping table by the distribution of intensity.

The expected output is provided in the files solution1.png and solution2.png.

**/

import java.util.Scanner;
public class Lab2 {
	public Lab2() {
		Img img = new Img("Fig03161.png");
		histogramEqualization(img);
		img.save("out1.png");
		img = new Img("HawkesBay.png");
		histogramEqualization(img);
		img.save("out2.png");
	}

	public void histogramEqualization(Img i) {
		//histogram
		int histogram[] = new int[256];
		for (int r = 0; r < i.height; r++) {
			for (int c = 0; c < i.width; c++){
				int position = r*i.width + c;
				int intensity = i.img[position]& 0xFF;
				histogram[intensity]++;
			}
		}

		//cummulative histogram
		int cdf [] = new int[256];
		cdf[0] = histogram[0];
		for (int intensity=1; intensity<256; intensity++){
			cdf[intensity] = cdf[intensity-1] + histogram[intensity];
		}

		//mapping table 
		int map[] = new int[256];
		int total_pixel = i.height*i.width;
		for (int intensity=0; intensity < 256; intensity++) {
			map[intensity] = Math.round(cdf[intensity]*255/total_pixel);
		}

		// update pixel 
		for (int r = 0; r < i.height; r++) {
			for (int c = 0; c < i.width; c++){
				int position = r*i.width + c;
				int ori_intensity = i.img[position] & 0xFF;
				int new_intensity = map[ori_intensity];
				i.img[position] = (byte)new_intensity;
			}


		}
	}
		

	public static void main(String[] args) {
		new Lab2();
	}
}
