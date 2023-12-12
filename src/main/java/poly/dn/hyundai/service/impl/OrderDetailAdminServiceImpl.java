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
import poly.dn.hyundai.Model.DashboardModel;
import poly.dn.hyundai.Repository.OrderDetailAdminRepository;
import poly.dn.hyundai.service.OrderDetailAdminService;

@Service
public class OrderDetailAdminServiceImpl implements OrderDetailAdminService {
	@Autowired
	OrderDetailAdminRepository adminRepository;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return adminRepository.save(entity);
	}
	
	@Override
	public Long countTotalPrice() {
		return adminRepository.countTotalPrice();
	}
	
	@Override
	public Long countTotalQuantity() {
		return adminRepository.countTotalQuantity();
	}

	
	

	@Override
	public List<DashboardModel> listProductSell() {
		return adminRepository.listProductSell();
	}

	@Override
	public Page<OrderDetail> findByOrderDetail(Integer quantity, Pageable pageable) {
		return adminRepository.findByOrderDetail(quantity, pageable);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAll(Iterable<S> entities) {
		return adminRepository.saveAll(entities);
	}

	@Override
	public <S extends OrderDetail> Optional<S> findOne(Example<S> example) {
		return adminRepository.findOne(example);
	}

	@Override
	public List<OrderDetail> findAll(Sort sort) {
		return adminRepository.findAll(sort);
	}

	@Override
	public void flush() {
		adminRepository.flush();
	}

	@Override
	public Page<OrderDetail> findAll(Pageable pageable) {
		return adminRepository.findAll(pageable);
	}

	@Override
	public <S extends OrderDetail> S saveAndFlush(S entity) {
		return adminRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends OrderDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return adminRepository.saveAllAndFlush(entities);
	}

	@Override
	public List<OrderDetail> findAll() {
		return adminRepository.findAll();
	}

	@Override
	public List<OrderDetail> findAllById(Iterable<Long> ids) {
		return adminRepository.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<OrderDetail> entities) {
		adminRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return adminRepository.findAll(example, pageable);
	}

	@Override
	public Optional<OrderDetail> findById(Long id) {
		return adminRepository.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<OrderDetail> entities) {
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
	public <S extends OrderDetail> long count(Example<S> example) {
		return adminRepository.count(example);
	}

	@Override
	public <S extends OrderDetail> boolean exists(Example<S> example) {
		return adminRepository.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		adminRepository.deleteAllInBatch();
	}

	@Override
	public OrderDetail getOne(Long id) {
		return adminRepository.getOne(id);
	}

	@Override
	public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
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
	public OrderDetail getById(Long id) {
		return adminRepository.getById(id);
	}

	@Override
	public void delete(OrderDetail entity) {
		adminRepository.delete(entity);
	}

	@Override
	public OrderDetail getReferenceById(Long id) {
		return adminRepository.getReferenceById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		adminRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends OrderDetail> entities) {
		adminRepository.deleteAll(entities);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example) {
		return adminRepository.findAll(example);
	}

	@Override
	public <S extends OrderDetail> List<S> findAll(Example<S> example, Sort sort) {
		return adminRepository.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		adminRepository.deleteAll();
	}
	
}
