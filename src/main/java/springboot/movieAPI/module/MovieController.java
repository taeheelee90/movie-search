package springboot.movieAPI.module;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MovieController {
	private final MovieService movieService;
	
	@GetMapping("/movies/{keyword}")
	public MovieDTO getMovie (@PathVariable String keyword) {
		return movieService.findByKeyword(keyword);
	}
}
