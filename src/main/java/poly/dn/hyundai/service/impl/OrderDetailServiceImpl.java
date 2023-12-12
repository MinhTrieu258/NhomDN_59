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

import poly.dn.hyundai.Entity.OrderDetail;
import poly.dn.hyundai.Repository.OrderDetailDao;
import poly.dn.hyundai.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
  OrderDetailDao orderDetailDao;

public OrderDetailServiceImpl(OrderDetailDao orderDetailDao) {
	
	this.orderDetailDao = orderDetailDao;
}


@Override
public <S extends OrderDetail> S save(S entity) {
	return orderDetailDao.save(entity);
}

@Override
public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
	return orderDetailDao.saveAll(entities);
}

@Override
public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
	return orderDetailDao.findOne(example);
}

@Override
public List<OrderDetail> findAll(Sort sort) {
	return orderDetailDao.findAll(sort);
}

@Override
public void flush() {
	orderDetailDao.flush();
}

@Override
public Page<OrderDetail> findAll(Pageable pageable) {
	return orderDetailDao.findAll(pageable);
}

@Override
public <S extends OrderDetail> S saveAndFlush(S entity) {
	return orderDetailDao.saveAndFlush(entity);
}

@Override
public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
	return orderDetailDao.saveAllAndFlush(entities);
}

@Override
public List<OrderDetail> findAll() {
	return orderDetailDao.findAll();
}

@Override
public List<OrderDetail> findAllById(Iterable<Long> ids) {
	return orderDetailDao.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<OrderDetail> entities) {
	orderDetailDao.deleteInBatch(entities);
}

@Override
public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
	return orderDetailDao.findAll(example, pageable);
}

@Override
public Optional<OrderDetail> findById(Long id) {
	return orderDetailDao.findById(id);
}

@Override
public void deleteAllInBatch(Iterable<OrderDetail> entities) {
	orderDetailDao.deleteAllInBatch(entities);
}

@Override
public boolean existsById(Long id) {
	return orderDetailDao.existsById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<Long> ids) {
	orderDetailDao.deleteAllByIdInBatch(ids);
}

@Override
public <S extends OrderDetail> long count(Example<S> example) {
	return orderDetailDao.count(example);
}

@Override
public <S extends OrderDetail> boolean exists(Example<S> example) {
	return orderDetailDao.exists(example);
}

@Override
public void deleteAllInBatch() {
	orderDetailDao.deleteAllInBatch();
}

@Override
public OrderDetail getOne(Long id) {
	return orderDetailDao.getOne(id);
}

@Override
public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return orderDetailDao.findBy(example, queryFunction);
}

@Override
public long count() {
	return orderDetailDao.count();
}

@Override
public void deleteById(Long id) {
	orderDetailDao.deleteById(id);
}

@Override
public OrderDetail getById(Long id) {
	return orderDetailDao.getById(id);
}

@Override
public void delete(OrderDetail entity) {
	orderDetailDao.delete(entity);
}

@Override
public OrderDetail getReferenceById(Long id) {
	return orderDetailDao.getReferenceById(id);
}

@Override
public void deleteAllById(Iterable<? extends Long> ids) {
	orderDetailDao.deleteAllById(ids);
}

@Override
public void deleteAll(Iterable<? extends OrderDetail> entities) {
	orderDetailDao.deleteAll(entities);
}

@Override
public <S extends OrderDetail> List<S> findAll(Example<S> example) {
	return orderDetailDao.findAll(example);
}

@Override
public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
	return orderDetailDao.findAll(example, sort);
}

@Override
public void deleteAll() {
	orderDetailDao.deleteAll();
}
  
  
}
