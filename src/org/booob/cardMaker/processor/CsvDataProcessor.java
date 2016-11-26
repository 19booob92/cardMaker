package org.booob.cardMaker.processor;

import java.util.ArrayList;
import java.util.List;

import org.booob.cardMaker.model.Card;
import org.booob.cardMaker.model.Person;

public class CsvDataProcessor {

	private static final int WYDZIAL_ID = 0;
	private static final int KIERUNEK_ID = 1;
	private static final int ROK_ID = 2;
	private static final int STOPIEN_ID = 3;
	private static final int GRUPA_ID = 4;
	private static final int ROK_ROZPOCZECIA = 5;
	// private static final int IMIE_I_NAZWISKO_ID = 0;

	public static List<Card> processData(List<String[]> data) {
		List<Card> processedCards = new ArrayList<>();

		for (String[] card : data) {
			// processedPersons.add(new Person(persons[IMIE_I_NAZWISKO_ID],
			// persons[WYDZIAL_ID], persons[KIERUNEK_ID],
			// persons[GRUPA_ID], persons[NR_ALBUMU_ID], persons[ROK_ID]));

			processedCards.add(new Card(card[WYDZIAL_ID], card[KIERUNEK_ID], card[ROK_ID], card[STOPIEN_ID],
					card[GRUPA_ID], card[ROK_ROZPOCZECIA]));
		}

		return processedCards;
	}
}
