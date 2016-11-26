package org.booob.cardMaker.model;

public class Card {
	
	private String wydzial;
	
	private String kierunek;
	
	private String rok;

	private String stopien;

	private String grupa;
	
	private String rokRozpoczecia;

	public Card(String wydzial, String kierunek, String rok, String stopien, String grupa, String rokRozpoczecia) {
		super();
		this.wydzial = wydzial;
		this.kierunek = kierunek;
		this.rok = rok;
		this.stopien = stopien;
		this.grupa = grupa;
		this.rokRozpoczecia = rokRozpoczecia;
	}

	public String getWydzial() {
		return wydzial;
	}

	public void setWydzial(String wydzial) {
		this.wydzial = wydzial;
	}

	public String getKierunek() {
		return kierunek;
	}

	public void setKierunek(String kierunek) {
		this.kierunek = kierunek;
	}

	public String getRok() {
		return rok;
	}

	public void setRok(String rok) {
		this.rok = rok;
	}

	public String getStopien() {
		return stopien;
	}

	public void setStopien(String stopien) {
		this.stopien = stopien;
	}

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public String getRokRozpoczecia() {
		return rokRozpoczecia;
	}

	public void setRokRozpoczecia(String rokRozpoczecia) {
		this.rokRozpoczecia = rokRozpoczecia;
	}
	
	
}
