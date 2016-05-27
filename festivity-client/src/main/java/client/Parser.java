package client;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dto.FestivityDto;

public class Parser {

	/** Url to post the festivities */
	private static final String POST_URL = "http://localhost:8080/festivity-api/festivity/add";

	/** Url to obtain the festivities */
	private static final String GET_URL = "http://localhost:8080/festivity-api/festivity/";

	/** Constant to refer to each of the festivities */
	private static final String FESTIVITY = "festivity";

	/** Constant to refer to end date */
	private static final String END_DATE = "endDate";

	/** Constant to refer to start date */
	private static final String START_DATE = "startDate";

	/** Constant to refer to end tag in the xml file */
	private static final String END = "end";

	/** Constant to refer to start tag in the xml file */
	private static final String START = "start";

	/** Constant to refer to place tag in the xml file */
	private static final String PLACE = "place";

	/** Constant to refer to name tag in the xml file */
	private static final String NAME = "name";

	/** Map to contain the values of the xml file */
	private static HashMap<String, String> values;

	/** List that contains all the values of the xml file */
	private static List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

	/**
	 * Main method to execute the parser and post the festivities of the xml
	 * file
	 * 
	 * @param args
	 *            Arguments - in this case not needed
	 */
	public static void main(String[] args) {

		readFile();
		postFestivities();
		getAllFestivities();
	}

	/**
	 * XML parser who reads and saves in memory the xml file information
	 */
	private static void readFile() {

		try {
			File inputFile = new File("./src/main/resources/festivities2.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName(FESTIVITY);
			for (int temp = 0; temp < nList.getLength(); temp++) {
				values = new HashMap<String, String>();
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					values.put(NAME, eElement.getElementsByTagName(NAME)
							.item(0).getTextContent());
					values.put(PLACE, eElement.getElementsByTagName(PLACE)
							.item(0).getTextContent());
					values.put(START, eElement.getElementsByTagName(START)
							.item(0).getTextContent());
					values.put(END, eElement.getElementsByTagName(END).item(0)
							.getTextContent());
				}
				list.add(values);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method to post each of the festivities obtained in the xml file
	 */
	private static void postFestivities() {

		for (HashMap<String, String> fest : list) {

			JSONObject request = new JSONObject();
			request.put(NAME, fest.get(NAME));
			request.put(PLACE, fest.get(PLACE));
			request.put(START_DATE, fest.get(START));
			request.put(END_DATE, fest.get(END));

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(
					request.toString(), headers);

			RestTemplate restTemplate = new RestTemplate();
			String urlString = POST_URL;
			ResponseEntity<FestivityDto> loginResponse = restTemplate.exchange(
					urlString, HttpMethod.POST, entity, FestivityDto.class);
		}
	}

	/**
	 * Method to obtain the festivities saved via the RestFul Service
	 */
	private static void getAllFestivities() {
		RestTemplate restTemplate = new RestTemplate();
		String url = GET_URL;

		FestivityDto[] bean = restTemplate.getForObject(url,
				FestivityDto[].class);
	}

}