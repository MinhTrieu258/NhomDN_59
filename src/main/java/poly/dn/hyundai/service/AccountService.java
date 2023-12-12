package poly.dn.hyundai.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.core.userdetails.UserDetails;

import poly.dn.hyundai.Entity.Account;

public interface AccountService {
  
	void deleteAll();

	<S extends Account> List<S> findAll(Example<S> example, Sort sort);

	<S extends Account> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends Account> entities);

	void deleteAllById(Iterable<? extends String> ids);

	Account getReferenceById(String id);

	void delete(Account entity);

	Account getById(String id);

	void deleteById(String id);

	long count();

	<S extends Account, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	Account getOne(String id);

	void deleteAllInBatch();

	<S extends Account> boolean exists(Example<S> example);

	<S extends Account> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<String> ids);

	boolean existsById(String id);

	void deleteAllInBatch(Iterable<Account> entities);

	Optional<Account> findById(String username);

	<S extends Account> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<Account> entities);

	List<Account> findAllById(Iterable<String> ids);

	List<Account> findAll();

	<S extends Account> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Account> S saveAndFlush(S entity);

	Page<Account> findAll(Pageable pageable);

	void flush();

	List<Account> findAll(Sort sort);

	<S extends Account> Optional<S> findOne(Example<S> example);

	<S extends Account> List<S> saveAll(Iterable<S> entities);



	List<Account> getAdministrators();

	<S extends Account> S save(S entity);

	void saveUser(UserDetails user);

	Account findByEmail(String email);

	Account update(Account account);

    List<Account> findByNameContaining(String name);

	Long countUser();

	Page<Account> findByFullname(String name, Pageable pageable);

	List<Account> findByFullname(String name);

	Page<Account> findByUsername(String name, Pageable pageable);

	List<Account> findByUsername(String name);

	Account findByUsername1(String name);



}
