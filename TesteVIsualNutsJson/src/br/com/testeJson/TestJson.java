package br.com.testeJson;

import java.util.List;
import java.util.Map;

import br.com.testeJson.model.Language;
import br.com.testeJson.model.Pais;

public class TestJson {

	public static void main(String[] args) {
		
		Paises countries = new Paises();
		
		//segundo exercício do teste (1/5)
		int p = countries.countCountries("src/paises.json");
		System.out.println("The number of Countries in the file is " + p);
		
		//segundo exercício do teste (2/5)		
		List<Pais> searchesCountries = ((Paises) countries).findCountriesByLanguage(new Language("de"), "src/paises.json");
		System.out.println(searchesCountries);
		
		//segundo exercício do teste (3/5)
		Map<String, Integer> languagesByCountries = countries.countLanguagesByCountry("src/paises.json");
		System.out.println(languagesByCountries);
		
		//segundo exercício do teste (4/5)
		Pais countryHighestLanguages = countries.findCountryHighestLanguages("src/paises.json");
		System.out.println(countryHighestLanguages);
		
		
		//segundo exercício do teste (5/5)
		Map<Object, List<String>> countCountriesByLanguage = countries.findMostCommonLanguageInCountries("src/paises.json");
		System.out.println(countCountriesByLanguage);
		
	}

}
