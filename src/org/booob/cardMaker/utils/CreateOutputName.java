package org.booob.cardMaker.utils;

public class CreateOutputName {
	public static String getOutputName(int id) {
		StringBuilder builder = new StringBuilder();

		builder.append(Statics.ROOT_PATH);
		builder.append("output/output_");
		builder.append(id);
		builder.append(".bmp");
		
		return builder.toString();
	}
}
