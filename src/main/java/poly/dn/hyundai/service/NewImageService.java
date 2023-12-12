package poly.dn.hyundai.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.hyundai.Entity.NewsImage;

public interface NewImageService {

    long count();

    <S extends NewsImage> long count(Example<S> example);

    void delete(NewsImage entity);

    void deleteAll();

    void deleteAll(Iterable<? extends NewsImage> entities);

    void deleteAllById(Iterable<? extends Long> ids);

    void deleteAllByIdInBatch(Iterable<Long> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<NewsImage> entities);

    void deleteById(Long id);

    void deleteInBatch(Iterable<NewsImage> entities);

    <S extends NewsImage> boolean exists(Example<S> example);

    boolean existsById(Long id);

    <S extends NewsImage> List<S> findAll(Example<S> example);

    <S extends NewsImage> List<S> findAll(Example<S> example, Sort sort);

    List<NewsImage> findAll();

    List<NewsImage> findAll(Sort sort);

    Page<NewsImage> findAll(Pageable pageable);

    <S extends NewsImage> Page<S> findAll(Example<S> example, Pageable pageable);

    List<NewsImage> findAllById(Iterable<Long> ids);

    <S extends NewsImage, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    Optional<NewsImage> findById(Long id);

    <S extends NewsImage> Optional<S> findOne(Example<S> example);

    void flush();

    NewsImage getById(Long arg0);

    NewsImage getOne(Long arg0);

    NewsImage getReferenceById(Long id);

    <S extends NewsImage> S save(S entity);

    <S extends NewsImage> List<S> saveAll(Iterable<S> entities);

    <S extends NewsImage> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends NewsImage> S saveAndFlush(S entity);

	Page<NewsImage> findByTitle(Integer id, Pageable pageable);

}