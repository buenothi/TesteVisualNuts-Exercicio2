package br.com.testeJson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.com.testeJson.model.Language;
import br.com.testeJson.model.Pais;

public class Paises {

	JSONObject jsonObject;
	JSONParser parser = new JSONParser();

	JSONArray array = new JSONArray();

	public int countCountries(String file) {

		try {
			array = (JSONArray) parser.parse(new FileReader(file));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		return array.size();
	}

	public List<Pais> findCountriesByLanguage(Language lan, String file) {

		List<Pais> countriesByLanguage = new ArrayList<Pais>();

		try {
			array = (JSONArray) parser.parse(new FileReader(file));
			for (int i = 0; i < array.size(); i++) {
				JSONObject countryJson = (JSONObject) array.get(i);
				JSONArray languagesJson = (JSONArray) countryJson.get("languages");
				Pais pais = new Pais();
				pais.setCountry(countryJson.get("country").toString());
				pais.setLanguages(new ArrayList<Language>());
				for (int j = 0; j < languagesJson.size(); j++) {
					Language lang = new Language(languagesJson.get(j).toString());
					pais.getLanguages().add(lang);
				}
				countriesByLanguage.add(pais);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		return countriesByLanguage.stream().filter(p -> p.getLanguages().contains(lan)).collect(Collectors.toList());
	}

	public Map<String, Integer> countLanguagesByCountry(String file) {

		Map<String, Integer> countLanguagesByCountry = new HashMap<>();

		try {
			array = (JSONArray) parser.parse(new FileReader(file));
			for (int i = 0; i < array.size(); i++) {
				JSONObject countryJson = (JSONObject) array.get(i);
				JSONArray languagesJson = (JSONArray) countryJson.get("languages");
				Pais pais = new Pais();
				pais.setCountry(countryJson.get("country").toString());
				pais.setLanguages(new ArrayList<Language>());
				for (int j = 0; j < languagesJson.size(); j++) {
					Language lang = new Language(languagesJson.get(j).toString());
					pais.getLanguages().add(lang);
				}
				countLanguagesByCountry.put(pais.getCountry(), pais.getLanguages().size());
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		return countLanguagesByCountry;
	}

	public Pais findCountryHighestLanguages(String file) {

		List<Pais> countriesByLanguage = new ArrayList<Pais>();

		try {
			array = (JSONArray) parser.parse(new FileReader(file));
			for (int i = 0; i < array.size(); i++) {
				JSONObject countryJson = (JSONObject) array.get(i);
				JSONArray languagesJson = (JSONArray) countryJson.get("languages");
				Pais pais = new Pais();
				pais.setCountry(countryJson.get("country").toString());
				pais.setLanguages(new ArrayList<Language>());
				for (int j = 0; j < languagesJson.size(); j++) {
					Language lang = new Language(languagesJson.get(j).toString());
					pais.getLanguages().add(lang);
				}
				countriesByLanguage.add(pais);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		return countriesByLanguage.stream()
				.max((pais1, pais2) -> Integer.compare(pais1.getLanguages().size(), pais2.getLanguages().size())).get();
	}

	public Map<Object, List<String>> findMostCommonLanguageInCountries(String file) {

		List<Pais> countriesByLanguage = new ArrayList<>();

		try {
			array = (JSONArray) parser.parse(new FileReader(file));
			for (int i = 0; i < array.size(); i++) {
				JSONObject countryJson = (JSONObject) array.get(i);
				JSONArray languagesJson = (JSONArray) countryJson.get("languages");
				Pais pais = new Pais();
				pais.setCountry(countryJson.get("country").toString());
				pais.setLanguages(new ArrayList<Language>());
				for (int j = 0; j < languagesJson.size(); j++) {
					Language lang = new Language(languagesJson.get(j).toString());
					pais.getLanguages().add(lang);
				}
				countriesByLanguage.add(pais);
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		return countriesByLanguage
				.stream()
				.flatMap(p -> p.getLanguages().stream().map(l -> l.getLanguage()))
				.collect(Collectors.groupingBy(l -> l.toString()));
	}

}
