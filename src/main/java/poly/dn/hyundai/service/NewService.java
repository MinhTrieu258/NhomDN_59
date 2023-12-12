package poly.dn.hyundai.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.hyundai.Entity.New;

public interface NewService {

    long count();

    <S extends New> long count(Example<S> example);

    void delete(New entity);

    void deleteAll();

    void deleteAll(Iterable<? extends New> entities);

    void deleteAllById(Iterable<? extends Long> ids);

    void deleteAllByIdInBatch(Iterable<Long> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<New> entities);

    void deleteById(Long id);

    void deleteInBatch(Iterable<New> entities);

    <S extends New> boolean exists(Example<S> example);

    boolean existsById(Long id);

    <S extends New> List<S> findAll(Example<S> example);

    <S extends New> List<S> findAll(Example<S> example, Sort sort);

    List<New> findAll();

    List<New> findAll(Sort sort);

    Page<New> findAll(Pageable pageable);

    <S extends New> Page<S> findAll(Example<S> example, Pageable pageable);

    List<New> findAllById(Iterable<Long> ids);

    <S extends New, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    Optional<New> findById(Long id);

    <S extends New> Optional<S> findOne(Example<S> example);

    void flush();

    New getById(Long arg0);

    New getOne(Long arg0);

    New getReferenceById(Long id);

    <S extends New> S save(S entity);

    <S extends New> List<S> saveAll(Iterable<S> entities);

    <S extends New> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends New> S saveAndFlush(S entity);

}