package movie;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieListRepository extends CrudRepository<MovieList, Long> {


}