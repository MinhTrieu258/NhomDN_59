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

import poly.dn.hyundai.Entity.Product;
import poly.dn.hyundai.Repository.ProductDao;
import poly.dn.hyundai.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
   ProductDao productDao;

public ProductServiceImpl(ProductDao productDao) {

	this.productDao = productDao;
}
@Override
public  List<Product> findByPriceBetween(double minPrice, double maxPrice ) {
	return productDao.findByPriceBetween(minPrice, maxPrice);
}




@Override
public Page<Product> findByNameContaining(String name, Pageable pageable) {
	return productDao.findByNameContaining(name, pageable);
}
@Override
public List<Product> findByNameContaining(String name) {
	return productDao.findByNameContaining(name);
}

@Override
public <S extends Product> S save(S entity) {
	return productDao.save(entity);
}

@Override
public <S extends Product> List<S> saveAll(Iterable<S> entities) {
	return productDao.saveAll(entities);
}

@Override
public <S extends Product> Optional<S> findOne(Example<S> example) {
	return productDao.findOne(example);
}

@Override
public List<Product> findAll(Sort sort) {
	return productDao.findAll(sort);
}

@Override
public void flush() {
	productDao.flush();
}

@Override
public Page<Product> findAll(Pageable pageable) {
	return productDao.findAll(pageable);
}

@Override
public <S extends Product> S saveAndFlush(S entity) {
	return productDao.saveAndFlush(entity);
}

@Override
public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
	return productDao.saveAllAndFlush(entities);
}

@Override
public List<Product> findAll() {
	return productDao.findAll();
}

@Override
public List<Product> findAllById(Iterable<Integer> ids) {
	return productDao.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<Product> entities) {
	productDao.deleteInBatch(entities);
}

@Override
public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
	return productDao.findAll(example, pageable);
}

@Override
public Optional<Product> findById(Integer id) {
	return productDao.findById(id);
}

@Override
public void deleteAllInBatch(Iterable<Product> entities) {
	productDao.deleteAllInBatch(entities);
}

@Override
public boolean existsById(Integer id) {
	return productDao.existsById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	productDao.deleteAllByIdInBatch(ids);
}

@Override
public <S extends Product> long count(Example<S> example) {
	return productDao.count(example);
}

@Override
public <S extends Product> boolean exists(Example<S> example) {
	return productDao.exists(example);
}

@Override
public void deleteAllInBatch() {
	productDao.deleteAllInBatch();
}

@Override
public Product getOne(Integer id) {
	return productDao.getOne(id);
}

@Override
public <S extends Product, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return productDao.findBy(example, queryFunction);
}

@Override
public long count() {
	return productDao.count();
}

@Override
public void deleteById(Integer id) {
	productDao.deleteById(id);
}

@Override
public Product getById(Integer id) {
	return productDao.getById(id);
}

@Override
public void delete(Product entity) {
	productDao.delete(entity);
}

@Override
public Product getReferenceById(Integer id) {
	return productDao.getReferenceById(id);
}

@Override
public void deleteAllById(Iterable<? extends Integer> ids) {
	productDao.deleteAllById(ids);
}

@Override
public void deleteAll(Iterable<? extends Product> entities) {
	productDao.deleteAll(entities);
}

@Override
public <S extends Product> List<S> findAll(Example<S> example) {
	return productDao.findAll(example);
}

@Override
public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
	return productDao.findAll(example, sort);
}

@Override
public void deleteAll() {
	productDao.deleteAll();
}

@Override
public List<Product> findByCategoryId(String cid) {
	
	return productDao.findByCategoryId(cid);
}

@Override
public Product create(Product product) {
	// TODO Auto-generated method stub
	return productDao.save(product);
}

@Override
public Product update(Product product) {
	// TODO Auto-generated method stub
	return productDao.save(product);
}


   
   
}
