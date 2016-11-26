package org.booob.cardMaker;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import org.booob.cardMaker.dataLoader.CsvLoader;
import org.booob.cardMaker.dataLoader.GraphicsIO;
import org.booob.cardMaker.model.Card;
import org.booob.cardMaker.processor.CsvDataProcessor;
import org.booob.cardMaker.processor.ImageProcessor;
import org.booob.cardMaker.utils.CreateOutputName;
import org.booob.cardMaker.utils.Statics;

public class CardMaker {

	private final static int PERFECT_NAME_LENGTH = 21;
	private final static int IMIE_I_NAZWISKO_DEFAULT_LENGTH = 140;
	private final static double EM = 9.5;

	private int size = 35;
	private int imieINazwiskoLength = 140;
	private int rokIKierunekLength = 37;

	private final String csvPath;
	private final String imagePath;

	private int ROK_I_KIERUNEK_INDENT = 37;
	private int IMIE_I_NAZWISKO_INDENT = 140;

	private static int imageId = 0;

	private ImageProcessor imageProcessor;

	public CardMaker(String csvPath, String imagePath) {
		this.csvPath = csvPath;
		this.imagePath = imagePath;
	}

	public void makeCards() {
		List<String[]> data = CsvLoader.loadCsvFile(csvPath);
		Graphics2D graphics;
		BufferedImage renderedImage;

		List<Card> cards = CsvDataProcessor.processData(data);

//		for (Card card : cards) {
			Card card = cards.get(0);
		
			renderedImage = GraphicsIO.loadImage(imagePath);
			graphics = (Graphics2D) renderedImage.getGraphics();

			imageProcessor = new ImageProcessor(graphics);

			String wydzial = card.getWydzial();
			String rokIKierunek = card.getRok() + ", " + card.getKierunek();

			fitNameIndent(wydzial);
			fitRokIkierunekIndent(card.getKierunek());

			imageProcessor.setTextInImage(card.getWydzial(), 720, 300, 70);
			imageProcessor.setTextInImage(card.getKierunek(), 830, 500, 70);
			imageProcessor.setTextInImage(card.getRok(), 830, 700, 70);
			imageProcessor.setTextInImage(card.getStopien(), 900, 200, 70);
			imageProcessor.setTextInImage(card.getGrupa(), 850, 1000, 70);
			imageProcessor.setTextInImage(card.getRokRozpoczecia(), 1300, 1250, 70);

			imageProcessor.disposeImage();

			GraphicsIO.writeImage(renderedImage, CreateOutputName.getOutputName(imageId));

			imageId++;
//		}
	}

	private void fitRokIkierunekIndent(String kierunek) {
		switch (kierunek) {
		case Statics.AG:
			rokIKierunekLength = 120;
			break;
		case Statics.E:
			rokIKierunekLength = 270;
			break;
		case Statics.FIR:
			rokIKierunekLength = 125;
			break;
		case Statics.L:
			rokIKierunekLength = 270;
			break;
		case Statics.MSG:
			rokIKierunekLength = 50;
			break;
		case Statics.Z:
			rokIKierunekLength = 250;
			break;
		case Statics.ZIP:
			rokIKierunekLength = 40;
			break;
		case Statics.IB:
			rokIKierunekLength = 130;
			break;

		default:
			break;
		}
	}

	private void fitNameIndent(String imieINazwisko) {
		imieINazwiskoLength = IMIE_I_NAZWISKO_DEFAULT_LENGTH;
		if (imieINazwisko.length() < PERFECT_NAME_LENGTH) {
			imieINazwiskoLength += (PERFECT_NAME_LENGTH - imieINazwisko.length()) * EM;
		}
	}

}
