package poly.dn.hyundai.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import poly.dn.hyundai.Entity.Role;
import poly.dn.hyundai.Repository.RoleDao;
import poly.dn.hyundai.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
  
	RoleDao roleDao;

	public RoleServiceImpl(RoleDao roleDao) {
		
		this.roleDao = roleDao;
	}

	@Override
	public <S extends Role> S save(S entity) {
		return roleDao.save(entity);
	}

	@Override
	public <S extends Role> List<S> saveAll(Iterable<S> entities) {
		return roleDao.saveAll(entities);
	}

	@Override
	public <S extends Role> Optional<S> findOne(Example<S> example) {
		return roleDao.findOne(example);
	}

	@Override
	public List<Role> findAll(Sort sort) {
		return roleDao.findAll(sort);
	}

	@Override
	public void flush() {
		roleDao.flush();
	}

	@Override
	public Page<Role> findAll(Pageable pageable) {
		return roleDao.findAll(pageable);
	}

	@Override
	public <S extends Role> S saveAndFlush(S entity) {
		return roleDao.saveAndFlush(entity);
	}

	@Override
	public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
		return roleDao.saveAllAndFlush(entities);
	}

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public List<Role> findAllById(Iterable<String> ids) {
		return roleDao.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Role> entities) {
		roleDao.deleteInBatch(entities);
	}

	@Override
	public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
		return roleDao.findAll(example, pageable);
	}

	@Override
	public Optional<Role> findById(String id) {
		return roleDao.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Role> entities) {
		roleDao.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return roleDao.existsById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		roleDao.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Role> long count(Example<S> example) {
		return roleDao.count(example);
	}

	@Override
	public <S extends Role> boolean exists(Example<S> example) {
		return roleDao.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		roleDao.deleteAllInBatch();
	}

	@Override
	public Role getOne(String id) {
		return roleDao.getOne(id);
	}

	@Override
	public <S extends Role, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return roleDao.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return roleDao.count();
	}

	@Override
	public void deleteById(String id) {
		roleDao.deleteById(id);
	}

	@Override
	public Role getById(String id) {
		return roleDao.getById(id);
	}

	@Override
	public void delete(Role entity) {
		roleDao.delete(entity);
	}

	@Override
	public Role getReferenceById(String id) {
		return roleDao.getReferenceById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		roleDao.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Role> entities) {
		roleDao.deleteAll(entities);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example) {
		return roleDao.findAll(example);
	}

	@Override
	public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
		return roleDao.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		roleDao.deleteAll();
	}
	
	
}
