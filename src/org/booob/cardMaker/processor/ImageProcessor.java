package org.booob.cardMaker.processor;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

import org.booob.cardMaker.model.RoundedPoint;
import org.booob.cardMaker.utils.ImageUtils;

public class ImageProcessor {

	private Graphics2D graphics;

	public ImageProcessor(Graphics2D graphics) {
		this.graphics = graphics;
	}

	public void setTextInImage(String text, Point pointOfLabel, int fontSize) {

		RoundedPoint scaledPoint = ImageUtils.getScaledPoint(pointOfLabel);

		graphics.setFont(new Font("Helvetica", Font.PLAIN, fontSize));
		graphics.drawString(text, scaledPoint.getX(), scaledPoint.getY());

		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	}

	public void disposeImage() {
		graphics.dispose();
	}

}
