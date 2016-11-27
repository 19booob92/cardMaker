package org.booob.cardMaker.utils;

import static org.booob.cardMaker.utils.Statics.ROOT_PATH;

public class CreateOutputName {
	public static String getOutputName(int id, String fieldName) {
		StringBuilder builder = new StringBuilder();

		builder.append(ROOT_PATH);
		builder.append("output/");
		builder.append(fieldName);
		builder.append(id);
		builder.append(".jpeg");
		
		return builder.toString();
	}
}
