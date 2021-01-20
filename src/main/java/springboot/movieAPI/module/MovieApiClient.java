package springboot.movieAPI.module;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieApiClient {

	private final RestTemplate restTemplate;


	// Insert your own CLIENT_ID and CLIENT_SECRET
	private final String CLIENT_ID = "";
	private final String CLIENT_SECRET = "";

	private final String NaverUrl_getMovies = "https://openapi.naver.com/v1/search/movie.json?query={title}";

	public MovieDTO requestMovie(String title) {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", CLIENT_ID);
		headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

		final HttpEntity<String> entity = new HttpEntity<>(headers);

		MovieDTO movieDTO = restTemplate.exchange(NaverUrl_getMovies, HttpMethod.GET, entity, MovieDTO.class, title)
				.getBody();

		return movieDTO;
	}

}
