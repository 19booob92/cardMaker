package org.booob.cardMaker;

import org.booob.cardMaker.gui.view.MainWindow;
import org.booob.cardMaker.utils.Statics;

public class Runner {

	private static final String CSV_PATH = Statics.ROOT_PATH + "input/dane.csv";
	private static final String JPG_PATH = Statics.ROOT_PATH + "input/inputImg.jpeg";

	public static void main(String[] args) {

		MainWindow window = new MainWindow(JPG_PATH, CSV_PATH);
		window.show();
	}
}
