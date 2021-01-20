package springboot.movieAPI.module;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MovieController {

	private final MovieService movieService;

	@GetMapping("/")
	public String main() {
		return "search";
	}

	@GetMapping("/rest-movies")
	public @ResponseBody MovieDTO getMovie(@RequestParam String keyword) {
		return movieService.findByKeyword(keyword);
	}

	@GetMapping("/movies")
	public String showMovies(@RequestParam String keyword, Model model) {
		MovieDTO movieDTO = movieService.findByKeyword(keyword);
		List<Movie> movies = movieService.renderMovieDTO(movieDTO);

		model.addAttribute("keyword", keyword);
		model.addAttribute("movies", movies);
		
		return "movies";
	}
}
