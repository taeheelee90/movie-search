package springboot.movieAPI.module;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieApiClient movieApiClient;
	
	@Transactional(readOnly = true)
	public MovieDTO findByKeyword(String keyword) {
		return movieApiClient.requestMovie(keyword);
	}
	
	// Parse JSON
	
	

}
