package br.com.testeJson.model;

import java.util.Objects;

public class Language {

	String language;

	public Language() {
	}	

	public Language(String language) {
		super();
		this.language = language;
	}



	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		return Objects.hash(language);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		return Objects.equals(language, other.language);
	}

	@Override
	public String toString() {
		return "Language [language=" + language + "]";
	}
	
	

}
