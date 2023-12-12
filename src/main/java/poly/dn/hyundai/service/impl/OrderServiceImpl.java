package poly.dn.hyundai.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import poly.dn.hyundai.Entity.Order;
import poly.dn.hyundai.Entity.OrderDetail;
import poly.dn.hyundai.Repository.OrderDao;
import poly.dn.hyundai.Repository.OrderDetailDao;
import poly.dn.hyundai.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
	OrderDao orderDao;
     
    @Autowired
    OrderDetailDao detailDao;
    
@Override
public Optional<Order> findById1(Long id) {
		return orderDao.findById(id);
	}

public OrderServiceImpl(OrderDao orderDao) {

	this.orderDao = orderDao;
}

@Override
public <S extends Order> S save(S entity) {
	return orderDao.save(entity);
}

@Override
public <S extends Order> List<S> saveAll(Iterable<S> entities) {
	return orderDao.saveAll(entities);
}

@Override
public <S extends Order> Optional<S> findOne(Example<S> example) {
	return orderDao.findOne(example);
}

@Override
public List<Order> findAll(Sort sort) {
	return orderDao.findAll(sort);
}

@Override
public void flush() {
	orderDao.flush();
}

@Override
public Page<Order> findAll(Pageable pageable) {
	return orderDao.findAll(pageable);
}

@Override
public <S extends Order> S saveAndFlush(S entity) {
	return orderDao.saveAndFlush(entity);
}

@Override
public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
	return orderDao.saveAllAndFlush(entities);
}

@Override
public List<Order> findAll() {
	return orderDao.findAll();
}

@Override
public List<Order> findAllById(Iterable<Long> ids) {
	return orderDao.findAllById(ids);
}

@Override
public void deleteInBatch(Iterable<Order> entities) {
	orderDao.deleteInBatch(entities);
}

@Override
public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
	return orderDao.findAll(example, pageable);
}

@Override
public Order findById(Long id) {
	return orderDao.findById(id).get();
}

@Override
public void deleteAllInBatch(Iterable<Order> entities) {
	orderDao.deleteAllInBatch(entities);
}

@Override
public boolean existsById(Long id) {
	return orderDao.existsById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<Long> ids) {
	orderDao.deleteAllByIdInBatch(ids);
}

@Override
public <S extends Order> long count(Example<S> example) {
	return orderDao.count(example);
}

@Override
public <S extends Order> boolean exists(Example<S> example) {
	return orderDao.exists(example);
}

@Override
public void deleteAllInBatch() {
	orderDao.deleteAllInBatch();
}

@Override
public Order getOne(Long id) {
	return orderDao.getOne(id);
}

@Override
public <S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
	return orderDao.findBy(example, queryFunction);
}

@Override
public long count() {
	return orderDao.count();
}

@Override
public void deleteById(Long id) {
	orderDao.deleteById(id);
}

@Override
public Order getById(Long id) {
	return orderDao.getById(id);
}

@Override
public void delete(Order entity) {
	orderDao.delete(entity);
}

@Override
public Order getReferenceById(Long id) {
	return orderDao.getReferenceById(id);
}

@Override
public void deleteAllById(Iterable<? extends Long> ids) {
	orderDao.deleteAllById(ids);
}

@Override
public void deleteAll(Iterable<? extends Order> entities) {
	orderDao.deleteAll(entities);
}

@Override
public <S extends Order> List<S> findAll(Example<S> example) {
	return orderDao.findAll(example);
}

@Override
public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
	return orderDao.findAll(example, sort);
}

@Override
public void deleteAll() {
	orderDao.deleteAll();
}


@Override
public Order create(JsonNode orderData) {
    ObjectMapper mapper = new ObjectMapper();
    Order order = mapper.convertValue(orderData, Order.class);
    orderDao.save(order);

    TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
    };

    List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
            .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
    detailDao.saveAll(details); // Thêm @Autowired trước OrderDetailDao detailDao;

    return order;
}

@Override
public List<Order> findByUsername(String username) {
	
	return orderDao.findByUsername(username);
}

@Override
public void deleteOrderById(Long id) {
	orderDao.deleteById(id);
	
}
  
}
