package springboot.movieAPI.module;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import springboot.movieAPI.module.MovieDTO.Item;

@Service
@RequiredArgsConstructor
@Transactional
public class MovieService {

	private final MovieApiClient movieApiClient;
	private final ModelMapper modelMapper;

	public MovieDTO searchMovie(String title) {
		return movieApiClient.requestMovie(title);
	}

	public List<Movie> renderMovieDTO(MovieDTO movieDTO, String title) {
		Item[] items = movieDTO.getItems();
		List<Movie> movies = new ArrayList<>();

		for (Item item : items) {
			Movie movie = modelMapper.map(item, Movie.class);
			movies.add(movie);
		}
		return movies;
	}

}
