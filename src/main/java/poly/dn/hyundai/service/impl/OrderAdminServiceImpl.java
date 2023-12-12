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

import poly.dn.hyundai.Entity.Order;
import poly.dn.hyundai.Repository.OrderAdminRepository;
import poly.dn.hyundai.service.OrderAdminService;

@Service
public class OrderAdminServiceImpl implements OrderAdminService{
	@Autowired
	OrderAdminRepository adminRepository;

	@Override
	public List<Order> findByUsername(String username) {
		return adminRepository.findByUsername(username);
	}

	@Override
	public Page<Order> findByUsername(String username, Pageable pageable) {
		return adminRepository.findByUsername(username, pageable);
	}

	@Override
	public <S extends Order> S save(S entity) {
		return adminRepository.save(entity);
	}
	
	@Override
	public Long countTotalOrder() {
		return adminRepository.countTotalOrder();
	}
	
	@Override
	public Long countTotalUserByProduct() {
		return adminRepository.countTotalUserByProduct();
	}

	@Override
	public <S extends Order> List<S> saveAll(Iterable<S> entities) {
		return adminRepository.saveAll(entities);
	}

	@Override
	public <S extends Order> Optional<S> findOne(Example<S> example) {
		return adminRepository.findOne(example);
	}

	@Override
	public List<Order> findAll(Sort sort) {
		return adminRepository.findAll(sort);
	}

	@Override
	public void flush() {
		adminRepository.flush();
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return adminRepository.findAll(pageable);
	}

	@Override
	public Page<Order> findAllOrderPaginated(Pageable pageable) {
		return adminRepository.findAllOrderPaginated(pageable);
	}

	@Override
	public <S extends Order> S saveAndFlush(S entity) {
		return adminRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
		return adminRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<Order> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public List<Order> findAllById(Iterable<Long> ids) {
		return adminRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<Order> entities) {
		adminRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
		return adminRepository.findAll(example, pageable);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return adminRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<Order> entities) {
		adminRepository.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(Long id) {
		return adminRepository.existsById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		adminRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends Order> long count(Example<S> example) {
		return adminRepository.count(example);
	}

	@Override
	public <S extends Order> boolean exists(Example<S> example) {
		return adminRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		adminRepository.deleteAllInBatch();
	}

	@Override
	public Order getOne(Long id) {
		return adminRepository.getOne(id);
	}

	@Override
	public <S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return adminRepository.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return adminRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		adminRepository.deleteById(id);
	}

	@Override
	public Order getById(Long id) {
		return adminRepository.getById(id);
	}

	@Override
	public void delete(Order entity) {
		adminRepository.delete(entity);
	}

	@Override
	public Order getReferenceById(Long id) {
		return adminRepository.getReferenceById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		adminRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		adminRepository.deleteAll(entities);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example) {
		return adminRepository.findAll(example);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
		return adminRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		adminRepository.deleteAll();
	}
}
