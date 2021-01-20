package springboot.movieAPI.module;

import org.springframework.stereotype.Controller;
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

	@GetMapping("/movies") 
	public @ResponseBody MovieDTO getMovie (@RequestParam String keyword) {
		return movieService.findByKeyword(keyword);
	}
}
