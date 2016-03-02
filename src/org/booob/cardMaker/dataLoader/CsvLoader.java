package org.booob.cardMaker.dataLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvLoader {
	
	private static final String DELIMETER = ",";
	
	private static BufferedReader reader;
	
	
	public static List<String[]> loadCsvFile(String path) {
		String line;
		List<String[]> data = new ArrayList<>();
		
		try {
			reader = new BufferedReader(new FileReader(path));
			
			while ((line = reader.readLine()) != null) {
				data.add(line.split(DELIMETER));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return data;
	}

}
