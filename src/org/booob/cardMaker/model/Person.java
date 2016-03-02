package org.booob.cardMaker.model;

public class Person {

	private String imieINazwisko;

	private String wydzial;

	private String kierunek;

	private String grupa;

	private String nrAlbumu;

	private String rok;

	public Person(String imieINazwisko, String wydzial, String kierunek, String grupa, String nrAlbumu, String rok) {
		this.imieINazwisko = imieINazwisko;
		this.wydzial = wydzial;
		this.kierunek = kierunek;
		this.grupa = grupa;
		this.nrAlbumu = nrAlbumu;
		this.rok = rok;
	}

	public String getImieINazwisko() {
		return imieINazwisko;
	}

	public void setImieINazwisko(String imieINazwisko) {
		this.imieINazwisko = imieINazwisko;
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

	public String getGrupa() {
		return grupa;
	}

	public void setGrupa(String grupa) {
		this.grupa = grupa;
	}

	public String getNrAlbumu() {
		return nrAlbumu;
	}

	public void setNrAlbumu(String nrAlbumu) {
		this.nrAlbumu = nrAlbumu;
	}

	public String getRok() {
		return rok;
	}

	public void setRok(String rok) {
		this.rok = rok;
	}

}
