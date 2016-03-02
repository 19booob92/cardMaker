package org.booob.cardMaker.processor;

import java.awt.Font;
import java.awt.Graphics;

public class ImageProcessor {

	private Graphics graphics;

	public ImageProcessor(Graphics graphics) {
		this.graphics = graphics;
	}

	public void setTextInImage(String text, int x, int y, int fontSize) {

		graphics.setFont(new Font("Arial", Font.PLAIN, fontSize));
		graphics.drawString(text, x, y);
	}

	public void disposeImage() {
		graphics.dispose();
	}

}
