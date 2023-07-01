/**

This task is to getMostFrequentIntensityValue that will return the most frequent intensity value in the image, i.e., the intensity that appears most often. 


**/

import java.util.Scanner; 

public class Lab4 {
	public Lab4() {
		Img img = new Img("Fig0314a.png");
		int i = getMostFrequentIntensityValue(img);
		System.out.println("Most frequent intensity value is "+i);
	}
	/**
	 * Retrieve the intensity value that occurs most often in the image
	 * @param img 
	 * @return the intensity value that occurs most often in the image
	 */
	public int getMostFrequentIntensityValue(Img i) {
		//Your code here

		int count[] = new int[255];

		for (int intensity: i.img) {
			count[intensity & 0xFF]++;
		} 
		
		int max = count[0];
		int intensity = 0;
		for (int num = 0; num < count.length; num++) {
			if (max < count[num]) {
				max = count[num];
				intensity = num;
			}
		}

		return intensity;
	}
	public static void main(String[] args) {
		new Lab4();
	}
}
