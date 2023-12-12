package poly.dn.hyundai.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.hyundai.Entity.Authority;

public interface AuthorityService {

	void deleteAll();

	<S extends Authority> List<S> findAll(Example<S> example, Sort sort);

	<S extends Authority> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Authority> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	Authority getReferenceById(Integer id);

	void delete(Authority entity);

	Authority getById(Integer id);

	void deleteById(Integer id);

	long count();

	<S extends Authority, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Authority getOne(Integer id);

	void deleteAllInBatch();

	<S extends Authority> boolean exists(Example<S> example);

	<S extends Authority> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	boolean existsById(Integer id);

	void deleteAllInBatch(Iterable<Authority> entities);

	Optional<Authority> findById(Integer id);

	<S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Authority> entities);

	List<Authority> findAllById(Iterable<Integer> ids);

	List<Authority> findAll();

	<S extends Authority> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Authority> S saveAndFlush(S entity);

	Page<Authority> findAll(Pageable pageable);

	void flush();

	List<Authority> findAll(Sort sort);

	<S extends Authority> Optional<S> findOne(Example<S> example);

	<S extends Authority> List<S> saveAll(Iterable<S> entities);

	<S extends Authority> S save(S entity);

	List<Authority> findAuthoritiesOfAdministrators();

	Authority create(Authority auth);

}
