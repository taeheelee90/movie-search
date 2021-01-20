package springboot.movieAPI.module;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import springboot.movieAPI.module.MovieDTO.Item;

@Service
@RequiredArgsConstructor
public class MovieService {

	private final MovieApiClient movieApiClient;
	private final ModelMapper modelMapper;
	private final MovieRepository movieRepository;

	public MovieDTO searchMovie(String title) {
		return movieApiClient.requestMovie(title);
	}

	@Transactional
	public List<Movie> renderMovieDTO(MovieDTO movieDTO, String title) {
		Item[] items = movieDTO.getItems();

		for (Item item : items) {
			Movie movie = modelMapper.map(item, Movie.class);
			movieRepository.save(movie);
		}
		System.out.println(movieRepository.findAll());
		return movieRepository.findAll();
	}

}
