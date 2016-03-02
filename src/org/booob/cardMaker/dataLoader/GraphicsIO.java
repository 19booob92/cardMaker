package org.booob.cardMaker.dataLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.booob.cardMaker.utils.Statics;

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
			ImageIO.write(imageToSave, "bmp", new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
