package org.booob.cardMaker.utils;

import static org.booob.cardMaker.utils.Statics.X_SCALE;
import static org.booob.cardMaker.utils.Statics.Y_SCALE;

import java.awt.Point;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.JLabel;

import org.booob.cardMaker.model.RoundedPoint;

public class ImageUtils {

	public static List<Point> extractPoint(Set<JLabel> labels) {
		return labels.stream().map(label -> label.getLocation()).sorted((labelA, labelB) -> {
			if (labelA.getY() > labelB.getY()) {
				return 1;
			} else if (labelA.getY() < labelB.getY()) {
				return -1;
			} else {
				return 0;
			}
		}).collect(Collectors.toList());
	}

	public static RoundedPoint getScaledPoint(Point pointToProcess) {
		int scaledX = new Double(pointToProcess.getX()).intValue() + X_SCALE;
		int scaledY = new Double(pointToProcess.getY()).intValue() + Y_SCALE;

		return new RoundedPoint(scaledX, scaledY);
	}

}
