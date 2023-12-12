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

import poly.dn.hyundai.Entity.Category;
import poly.dn.hyundai.Repository.CategoryDao;
import poly.dn.hyundai.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
   CategoryDao categoryDao;

public CategoryServiceImpl(CategoryDao categoryDao) {

	this.categoryDao = categoryDao;
}

@Override
public <S extends Category> S save(S entity) {
	return categoryDao.save(entity);
}

@Override
public <S extends Category> List<S> saveAll(Iterable<S> entities) {
	return categoryDao.saveAll(entities);
}

@Override
public <S extends Category> Optional<S> findOne(Example<S> example) {
	return categoryDao.findOne(example);
}

@Override
public List<Category> findAll(Sort sort) {
	return categoryDao.findAll(sort);
}

@Override
public void flush() {
	categoryDao.flush();
}

@Override
public Page<Category> findAll(Pageable pageable) {
	return categoryDao.findAll(pageable);
}

@Override
public <S extends Category> S saveAndFlush(S entity) {
	return categoryDao.saveAndFlush(entity);
}

@Override
public <S extends Category> List<S> saveAllAndFlush(Iterable<S> entities) {
	return categoryDao.saveAllAndFlush(entities);
}

@Override
public List<Category> findAll() {
	return categoryDao.findAll();
}

@Override
public List<Category> findAllById(Iterable<String> ids) {
	return categoryDao.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<Category> entities) {
	categoryDao.deleteInBatch(entities);
}

@Override
public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
	return categoryDao.findAll(example, pageable);
}

@Override
public Optional<Category> findById(String id) {
	return categoryDao.findById(id);
}

@Override
public void deleteAllInBatch(Iterable<Category> entities) {
	categoryDao.deleteAllInBatch(entities);
}

@Override
public boolean existsById(String id) {
	return categoryDao.existsById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<String> ids) {
	categoryDao.deleteAllByIdInBatch(ids);
}

@Override
public <S extends Category> long count(Example<S> example) {
	return categoryDao.count(example);
}

@Override
public <S extends Category> boolean exists(Example<S> example) {
	return categoryDao.exists(example);
}

@Override
public void deleteAllInBatch() {
	categoryDao.deleteAllInBatch();
}

@Override
public Category getOne(String id) {
	return categoryDao.getOne(id);
}

@Override
public <S extends Category, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return categoryDao.findBy(example, queryFunction);
}

@Override
public long count() {
	return categoryDao.count();
}

@Override
public void deleteById(String id) {
	categoryDao.deleteById(id);
}

@Override
public Category getById(String id) {
	return categoryDao.getById(id);
}

@Override
public void delete(Category entity) {
	categoryDao.delete(entity);
}

@Override
public Category getReferenceById(String id) {
	return categoryDao.getReferenceById(id);
}

@Override
public void deleteAllById(Iterable<? extends String> ids) {
	categoryDao.deleteAllById(ids);
}

@Override
public void deleteAll(Iterable<? extends Category> entities) {
	categoryDao.deleteAll(entities);
}

@Override
public <S extends Category> List<S> findAll(Example<S> example) {
	return categoryDao.findAll(example);
}

@Override
public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
	return categoryDao.findAll(example, sort);
}

@Override
public void deleteAll() {
	categoryDao.deleteAll();
}

@Override
public Category update(Category cate) {
	// TODO Auto-generated method stub
	return categoryDao.save(cate);
}

@Override
public List<Category> findByNameContaining(String name) {
	return categoryDao.findByNameContaining(name);
}
@Override
public Page<Category> findByNameContaining(String name, Pageable pageable) {
	return categoryDao.findByNameContaining(name, pageable);
}
   
   
   
}
