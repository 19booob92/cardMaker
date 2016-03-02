package org.booob.cardMaker;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.List;

import org.booob.cardMaker.dataLoader.CsvLoader;
import org.booob.cardMaker.dataLoader.GraphicsIO;
import org.booob.cardMaker.model.Person;
import org.booob.cardMaker.processor.CsvDataProcessor;
import org.booob.cardMaker.processor.ImageProcessor;
import org.booob.cardMaker.utils.CreateOutputName;

public class CardMaker {

	private final String csvPath;
	private final String imagePath;

	private static int imageId = 0;

	private ImageProcessor imageProcessor;

	public CardMaker(String csvPath, String imagePath) {
		this.csvPath = csvPath;
		this.imagePath = imagePath;
	}

	public void makeCards() {
		List<String[]> data = CsvLoader.loadCsvFile(csvPath);
		Graphics graphics;
		BufferedImage renderedImage;

		List<Person> persons = CsvDataProcessor.processData(data);

		for (Person person : persons) {
			renderedImage = GraphicsIO.loadImage(imagePath);
			graphics = renderedImage.getGraphics();

			imageProcessor = new ImageProcessor(graphics);

			imageProcessor.setTextInImage(person.getImieINazwisko(), 140, 220, 40);
			imageProcessor.setTextInImage(person.getRok() + ", " + person.getKierunek(), 37, 330, 35);
			imageProcessor.setTextInImage(person.getNrAlbumu(), 450, 700, 40);
			imageProcessor.setTextInImage(person.getWydzial(), 470, 950, 40);

			imageProcessor.setTextInImage(person.getGrupa(), 500, 400, 40);

			imageProcessor.disposeImage();

			GraphicsIO.writeImage(renderedImage, CreateOutputName.getOutputName(imageId));

			imageId++;
		}
	}

}
