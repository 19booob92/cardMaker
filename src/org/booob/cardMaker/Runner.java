package org.booob.cardMaker;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import org.booob.cardMaker.dataLoader.GraphicsIO;
import org.booob.cardMaker.gui.MainWindow;
import org.booob.cardMaker.utils.Statics;

public class Runner {

	private static final String CSV_PATH = Statics.ROOT_PATH + "input/dane.csv";
	private static final String JPG_PATH = Statics.ROOT_PATH + "input/inputImg.jpeg";

	public static void main(String[] args) {

		MainWindow window = new MainWindow(JPG_PATH, CSV_PATH);
		window.show();
	}
}
