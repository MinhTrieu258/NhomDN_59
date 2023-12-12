package poly.dn.hyundai.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.hyundai.Entity.Role;

public interface RoleService {

	void deleteAll();

	<S extends Role> List<S> findAll(Example<S> example, Sort sort);

	<S extends Role> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Role> entities);

	void deleteAllById(Iterable<? extends String> ids);

	Role getReferenceById(String id);

	void delete(Role entity);

	Role getById(String id);

	void deleteById(String id);

	long count();

	<S extends Role, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Role getOne(String id);

	void deleteAllInBatch();

	<S extends Role> boolean exists(Example<S> example);

	<S extends Role> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<String> ids);

	boolean existsById(String id);

	void deleteAllInBatch(Iterable<Role> entities);

	Optional<Role> findById(String id);

	<S extends Role> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Role> entities);

	List<Role> findAllById(Iterable<String> ids);

	List<Role> findAll();

	<S extends Role> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Role> S saveAndFlush(S entity);

	Page<Role> findAll(Pageable pageable);

	void flush();

	List<Role> findAll(Sort sort);

	<S extends Role> Optional<S> findOne(Example<S> example);

	<S extends Role> List<S> saveAll(Iterable<S> entities);

	<S extends Role> S save(S entity);

}
