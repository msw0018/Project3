import java.awt.Color;

public class ImageProcessing {
	
	public static void main(String[] args) {
		//Create new image utility.
		ImageUtils utils = new ImageUtils();
		
		// Load in an image.
		Color[][] orig = utils.loadImage("src/LennaCV.png");
		
		// Add original image tab.
		utils.addImage(orig, "Original image.");
		
		// Process the image.
		Color[][] checker = process(orig);
		Color[][] inverse = inverse(orig);
		Color[][] blackWhite = blackWhite(orig);
		Color[][] blackAndWhite = blackAndWhite(orig);
		
		utils.addImage(checker, "Checkers");
		utils.addImage(inverse, "Inverse");
		utils.addImage(blackWhite, "Black and White");
		utils.addImage(blackAndWhite, "Grey Scale");
		
		// Display the images.
		utils.display();
	}
	
	public static Color[][] blackWhite(Color[][] img){
		Color[][] tmp = ImageUtils.cloneArray(img);
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				Color pixel = tmp[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				if (r > 95 && b > 95 && g > 95) {
					r = 255;
					b = 255;
					g = 255;
				}
				else {
					r = 0;
					b = 0;
					g = 0;
				}
				tmp[i][j] = new Color(r, b, g);
			}
		}
		return tmp;
	}
	
	public static Color[][] inverse(Color[][] img){
		Color[][] tmp = ImageUtils.cloneArray(img);
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				Color pixel = tmp[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
				tmp[i][j] = new Color(255-r, 255-b, 255-g);
			}
		}	
		
		return tmp;
	}
	
	public static Color[][] process(Color[][] img){
		Color[][] tmp = ImageUtils.cloneArray(img);
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				// Red, Green, Blue: 0-255
				Color pixel = tmp[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				
                if ( (i/74 % 2) == (j/74 % 2) )
                    
                tmp[i][j] = new Color(r/2, b/2, g/2);

			}
		}
		
		return tmp;
	}
	
	public static Color[][] blackAndWhite(Color[][] img){
		Color[][] tmp = ImageUtils.cloneArray(img);
		
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				Color pixel = tmp[i][j];
				int r = pixel.getRed();
				int g = pixel.getGreen();
				int b = pixel.getBlue();
				tmp[i][j] = new Color((r+b+g)/3, (r+b+g)/3, (r+b+g)/3);
			}
		}
		return tmp;
	}
	
}