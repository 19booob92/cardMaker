package org.booob.cardMaker.processor;

import java.util.ArrayList;
import java.util.List;

import org.booob.cardMaker.model.Person;

public class CsvDataProcessor {

	private static final int IMIE_I_NAZWISKO_ID = 0;
	private static final int WYDZIAL_ID = 1;
	private static final int KIERUNEK_ID = 2;
	private static final int GRUPA_ID = 3;
	private static final int NR_ALBUMU_ID = 4;
	private static final int ROK_ID = 5;

	public static List<Person> processData(List<String[]> data) {
		List<Person> processedPersons = new ArrayList<>();

		for (String[] persons : data) {
			processedPersons.add(new Person(persons[IMIE_I_NAZWISKO_ID], persons[WYDZIAL_ID], persons[KIERUNEK_ID],
					persons[GRUPA_ID], persons[NR_ALBUMU_ID], persons[ROK_ID]));
		}

		return processedPersons;
	}
}
