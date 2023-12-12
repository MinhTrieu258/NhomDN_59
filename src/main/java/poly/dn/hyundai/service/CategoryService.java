package poly.dn.hyundai.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.hyundai.Entity.Category;

public interface CategoryService {

	void deleteAll();

	<S extends Category> List<S> findAll(Example<S> example, Sort sort);

	<S extends Category> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Category> entities);

	void deleteAllById(Iterable<? extends String> ids);

	Category getReferenceById(String id);

	void delete(Category entity);

	Category getById(String id);

	void deleteById(String id);

	long count();

	<S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Category getOne(String id);

	void deleteAllInBatch();

	<S extends Category> boolean exists(Example<S> example);

	<S extends Category> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<String> ids);

	boolean existsById(String id);

	void deleteAllInBatch(Iterable<Category> entities);

	Optional<Category> findById(String id);

	<S extends Category> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Category> entities);

	List<Category> findAllById(Iterable<String> ids);

	List<Category> findAll();

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Category> S saveAndFlush(S entity);

	Page<Category> findAll(Pageable pageable);

	void flush();

	List<Category> findAll(Sort sort);

	<S extends Category> Optional<S> findOne(Example<S> example);

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	<S extends Category> S save(S entity);

	Category update(Category cate);
    List<Category> findByNameContaining(String name);

	Page<Category> findByNameContaining(String name, Pageable pageable);

}
