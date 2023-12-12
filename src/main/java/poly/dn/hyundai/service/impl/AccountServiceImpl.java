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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Repository.AccountDao;
import poly.dn.hyundai.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
  AccountDao accountDao;
  @Autowired
   PasswordEncoder passwordEncoder;

@Override
public Account findByUsername1(String name) {
	return accountDao.findByUsername1(name);
}

public AccountServiceImpl(AccountDao accountDao) {
	
	this.accountDao = accountDao;
}

@Override
public List<Account> findByUsername(String name) {
	return accountDao.findByUsername(name);
}

@Override
public Page<Account> findByUsername(String name, Pageable pageable) {
	return accountDao.findByUsername(name, pageable);
}

@Override
public <S extends Account> S save(S entity) {
	entity.setPassword(passwordEncoder.encode(entity.getPassword()));
	return accountDao.save(entity);
}
@Override
public List<Account> findByFullname(String name) {
	return accountDao.findByFullname(name);
}

@Override
public Page<Account> findByFullname(String name, Pageable pageable) {
	return accountDao.findByFullname(name, pageable);
}

@Override
public Long countUser() {
	return accountDao.countUser();
}
@Override
public <S extends Account> List<S> saveAll(Iterable<S> entities) {
	return accountDao.saveAll(entities);
}

@Override
public <S extends Account> Optional<S> findOne(Example<S> example) {
	return accountDao.findOne(example);
}

@Override
public List<Account> findAll(Sort sort) {
	return accountDao.findAll(sort);
}

@Override
public void flush() {
	accountDao.flush();
}

@Override
public Page<Account> findAll(Pageable pageable) {
	return accountDao.findAll(pageable);
}

@Override
public <S extends Account> S saveAndFlush(S entity) {
	return accountDao.saveAndFlush(entity);
}

@Override
public <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities) {
	return accountDao.saveAllAndFlush(entities);
}

@Override
public List<Account> findAll() {
	return accountDao.findAll();
}

@Override
public List<Account> findAllById(Iterable<String> ids) {
	return accountDao.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<Account> entities) {
	accountDao.deleteInBatch(entities);
}

@Override
public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
	return accountDao.findAll(example, pageable);
}

@Override
public Optional<Account> findById(String id) {
	return accountDao.findById(id);
}

@Override
public void deleteAllInBatch(Iterable<Account> entities) {
	accountDao.deleteAllInBatch(entities);
}

@Override
public boolean existsById(String id) {
	return accountDao.existsById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<String> ids) {
	accountDao.deleteAllByIdInBatch(ids);
}

@Override
public <S extends Account> long count(Example<S> example) {
	return accountDao.count(example);
}

@Override
public <S extends Account> boolean exists(Example<S> example) {
	return accountDao.exists(example);
}

@Override
public void deleteAllInBatch() {
	accountDao.deleteAllInBatch();
}

@Override
public Account getOne(String id) {
	return accountDao.getOne(id);
}

@Override
public <S extends Account, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return accountDao.findBy(example, queryFunction);
}

@Override
public long count() {
	return accountDao.count();
}

@Override
public void deleteById(String id) {
	accountDao.deleteById(id);
}

@Override
public Account getById(String id) {
	return accountDao.getById(id);
}

@Override
public void delete(Account entity) {
	accountDao.delete(entity);
}

@Override
public Account getReferenceById(String id) {
	return accountDao.getReferenceById(id);
}

@Override
public void deleteAllById(Iterable<? extends String> ids) {
	accountDao.deleteAllById(ids);
}

@Override
public void deleteAll(Iterable<? extends Account> entities) {
	accountDao.deleteAll(entities);
}

@Override
public <S extends Account> List<S> findAll(Example<S> example) {
	return accountDao.findAll(example);
}

@Override
public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
	return accountDao.findAll(example, sort);
}

@Override
public void deleteAll() {
	accountDao.deleteAll();
}

@Override
public List<Account> getAdministrators() {
	// TODO Auto-generated method stub
	return accountDao.getAdministrators();
}

@Override
public void saveUser(UserDetails user) {
    // Assuming that AccountDao has an EntityManager or a JpaRepository
    // with the method to save the UserDetails entity.
    // If using JpaRepository, it will have a save() method.
    accountDao.save(user);
}

@Override
public Account findByEmail(String email) {
    // Assuming that AccountDao has an EntityManager or a JpaRepository
    // with a method to find the Account entity by email.
    // If using JpaRepository, it will have a findByEmail() method.
    return accountDao.findByEmail(email);
}

@Override
public Account update(Account account) {
	// TODO Auto-generated method stub
	return accountDao.save(account);
}

@Override
public List<Account> findByNameContaining(String name) {
	// TODO Auto-generated method stub
	throw new UnsupportedOperationException("Unimplemented method 'findByNameContaining'");
}


  
}
