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

import poly.dn.hyundai.Entity.New;
import poly.dn.hyundai.Repository.NewRepository;
import poly.dn.hyundai.service.NewService;

@Service
public class NewServiceImpl implements NewService {
    
    NewRepository newRepository;


    public NewServiceImpl(NewRepository newRepository) {
        this.newRepository = newRepository;
    }

    @Override
    public long count() {
        return newRepository.count();
    }

    @Override
    public <S extends New> long count(Example<S> example) {
        return newRepository.count(example);
    }

    @Override
    public void delete(New entity) {
        newRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        newRepository.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends New> entities) {
        newRepository.deleteAll(entities);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        newRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        newRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        newRepository.deleteAllInBatch();
    }

    @Override
    public void deleteAllInBatch(Iterable<New> entities) {
        newRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteById(Long id) {
        newRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(Iterable<New> entities) {
        newRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends New> boolean exists(Example<S> example) {
        return newRepository.exists(example);
    }

    @Override
    public boolean existsById(Long id) {
        return newRepository.existsById(id);
    }

    @Override
    public <S extends New> List<S> findAll(Example<S> example) {
        return newRepository.findAll(example);
    }

    @Override
    public <S extends New> List<S> findAll(Example<S> example, Sort sort) {
        return newRepository.findAll(example, sort);
    }

    @Override
    public List<New> findAll() {
        return newRepository.findAll();
    }

    @Override
    public List<New> findAll(Sort sort) {
        return newRepository.findAll(sort);
    }

    @Override
    public Page<New> findAll(Pageable pageable) {
        return newRepository.findAll(pageable);
    }

    @Override
    public <S extends New> Page<S> findAll(Example<S> example, Pageable pageable) {
        return newRepository.findAll(example, pageable);
    }

    @Override
    public List<New> findAllById(Iterable<Long> ids) {
        return newRepository.findAllById(ids);
    }

    @Override
    public <S extends New, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return newRepository.findBy(example, queryFunction);
    }

    @Override
    public Optional<New> findById(Long id) {
        return newRepository.findById(id);
    }

    @Override
    public <S extends New> Optional<S> findOne(Example<S> example) {
        return newRepository.findOne(example);
    }

    @Override
    public void flush() {
        newRepository.flush();
    }

    @Override
    public New getById(Long arg0) {
        return newRepository.getById(arg0);
    }

    @Override
    public New getOne(Long arg0) {
        return newRepository.getOne(arg0);
    }

    @Override
    public New getReferenceById(Long id) {
        return newRepository.getReferenceById(id);
    }

    @Override
    public <S extends New> S save(S entity) {
        return newRepository.save(entity);
    }

    @Override
    public <S extends New> List<S> saveAll(Iterable<S> entities) {
        return newRepository.saveAll(entities);
    }

    @Override
    public <S extends New> List<S> saveAllAndFlush(Iterable<S> entities) {
        return newRepository.saveAllAndFlush(entities);
    }

    @Override
    public <S extends New> S saveAndFlush(S entity) {
        return newRepository.saveAndFlush(entity);
    }

    
}
