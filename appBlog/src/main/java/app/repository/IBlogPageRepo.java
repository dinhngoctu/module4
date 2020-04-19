package app.repository;

import app.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogPageRepo extends PagingAndSortingRepository<Blog,Long> {
}
