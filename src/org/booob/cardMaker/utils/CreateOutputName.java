package org.booob.cardMaker.utils;

import static org.booob.cardMaker.utils.Statics.ROOT_PATH;

public class CreateOutputName {
	public static String getOutputName(int id) {
		StringBuilder builder = new StringBuilder();

		builder.append(ROOT_PATH);
		builder.append("output/output_");
		builder.append(id);
		builder.append(".jpeg");
		
		return builder.toString();
	}
}
