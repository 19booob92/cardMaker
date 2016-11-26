package org.booob.cardMaker.dataLoader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GraphicsIO {

	private static File inputImage;
	private static BufferedImage loadedImage;

	public static BufferedImage loadImage(String path) {
		inputImage = new File(path);
		try {
			loadedImage = ImageIO.read(inputImage);
		} catch (Exception ex) {
			System.err.println(ex);
		}

		return loadedImage;
	}

	public static void writeImage(BufferedImage imageToSave, String path) {
		try {
			ImageIO.write(imageToSave, "JPEG", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
