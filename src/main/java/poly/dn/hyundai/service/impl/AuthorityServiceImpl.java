package poly.dn.hyundai.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.Authority;
import poly.dn.hyundai.Repository.AccountDao;
import poly.dn.hyundai.Repository.AuthorityDao;
import poly.dn.hyundai.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {
AuthorityDao authorityDao;

@Autowired
AccountDao acdao;
public AuthorityServiceImpl(AuthorityDao authorityDao) {

	this.authorityDao = authorityDao;
}

@Override
public <S extends Authority> S save(S entity) {
	return authorityDao.save(entity);
}

@Override
public <S extends Authority> List<S> saveAll(Iterable<S> entities) {
	return authorityDao.saveAll(entities);
}

@Override
public <S extends Authority> Optional<S> findOne(Example<S> example) {
	return authorityDao.findOne(example);
}

@Override
public List<Authority> findAll(Sort sort) {
	return authorityDao.findAll(sort);
}

@Override
public void flush() {
	authorityDao.flush();
}

@Override
public Page<Authority> findAll(Pageable pageable) {
	return authorityDao.findAll(pageable);
}

@Override
public <S extends Authority> S saveAndFlush(S entity) {
	return authorityDao.saveAndFlush(entity);
}

@Override
public <S extends Authority> List<S> saveAllAndFlush(Iterable<S> entities) {
	return authorityDao.saveAllAndFlush(entities);
}

@Override
public List<Authority> findAll() {
	return authorityDao.findAll();
}

@Override
public List<Authority> findAllById(Iterable<Integer> ids) {
	return authorityDao.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<Authority> entities) {
	authorityDao.deleteInBatch(entities);
}

@Override
public <S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable) {
	return authorityDao.findAll(example, pageable);
}

@Override
public Optional<Authority> findById(Integer id) {
	return authorityDao.findById(id);
}

@Override
public void deleteAllInBatch(Iterable<Authority> entities) {
	authorityDao.deleteAllInBatch(entities);
}

@Override
public boolean existsById(Integer id) {
	return authorityDao.existsById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	authorityDao.deleteAllByIdInBatch(ids);
}

@Override
public <S extends Authority> long count(Example<S> example) {
	return authorityDao.count(example);
}

@Override
public <S extends Authority> boolean exists(Example<S> example) {
	return authorityDao.exists(example);
}

@Override
public void deleteAllInBatch() {
	authorityDao.deleteAllInBatch();
}

@Override
public Authority getOne(Integer id) {
	return authorityDao.getOne(id);
}

@Override
public <S extends Authority, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return authorityDao.findBy(example, queryFunction);
}

@Override
public long count() {
	return authorityDao.count();
}

@Override
public void deleteById(Integer id) {
	authorityDao.deleteById(id);
}

@Override
public Authority getById(Integer id) {
	return authorityDao.getById(id);
}

@Override
public void delete(Authority entity) {
	authorityDao.delete(entity);
}

@Override
public Authority getReferenceById(Integer id) {
	return authorityDao.getReferenceById(id);
}

@Override
public void deleteAllById(Iterable<? extends Integer> ids) {
	authorityDao.deleteAllById(ids);
}

@Override
public void deleteAll(Iterable<? extends Authority> entities) {
	authorityDao.deleteAll(entities);
}

@Override
public <S extends Authority> List<S> findAll(Example<S> example) {
	return authorityDao.findAll(example);
}

@Override
public <S extends Authority> List<S> findAll(Example<S> example, Sort sort) {
	return authorityDao.findAll(example, sort);
}

@Override
public void deleteAll() {
	authorityDao.deleteAll();
}

@Override
public List<Authority> findAuthoritiesOfAdministrators() {
	List<Account> accounts = acdao.getAdministrators();
	return authorityDao.authoritiesOf(accounts);
}

@Override
public Authority create(Authority auth) {
	// TODO Auto-generated method stub
	return authorityDao.save(auth);
}


}
