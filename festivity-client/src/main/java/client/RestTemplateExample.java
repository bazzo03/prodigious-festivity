package client;

import org.springframework.web.client.RestTemplate;

import dto.FestivityDto;


public class RestTemplateExample {
	public static void main(String[] args) {
		
		getAllFestivities();
	}

	private static void getAllFestivities() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/festivity-api/festivity/";

		FestivityDto[] bean = restTemplate.getForObject(url,
				FestivityDto[].class);

		System.out.println("The object received from REST call : "
				+ bean[0].getName());
		
	}
}
