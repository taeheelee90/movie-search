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

	@Transactional(readOnly = true)
	public MovieDTO findByKeyword(String keyword) {
		return movieApiClient.requestMovie(keyword);
	}

	public List<Movie> renderMovieDTO(MovieDTO movieDTO) {
		Item[] items = movieDTO.getItems();

		for (Item item : items) {
			Movie movie = modelMapper.map(item, Movie.class);
			movieRepository.save(movie);
		}
		return movieRepository.findAll();

	}

}
