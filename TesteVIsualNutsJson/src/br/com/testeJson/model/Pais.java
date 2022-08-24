package br.com.testeJson.model;

import java.util.List;

public class Pais {

	String country;
	List<Language> languages;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	@Override
	public String toString() {
		return country;
	}

}
