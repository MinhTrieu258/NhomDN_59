package poly.dn.hyundai.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import poly.dn.hyundai.Entity.Comment;

public interface CommentService {

    long count();

    <S extends Comment> long count(Example<S> example);

    void delete(Comment entity);
    List<Comment> getAllComments();
    void deleteAll();
    void addComment(String username, String commentDescription);
    void deleteAll(Iterable<? extends Comment> entities);

    void deleteAllById(Iterable<? extends Long> ids);

    void deleteAllByIdInBatch(Iterable<Long> ids);

    void deleteAllInBatch();

    void deleteAllInBatch(Iterable<Comment> entities);

    void deleteById(Long id);

    void deleteInBatch(Iterable<Comment> entities);

    <S extends Comment> boolean exists(Example<S> example);

    boolean existsById(Long id);

    <S extends Comment> List<S> findAll(Example<S> example);

    <S extends Comment> List<S> findAll(Example<S> example, Sort sort);

    List<Comment> findAll();

    List<Comment> findAll(Sort sort);

    Page<Comment> findAll(Pageable pageable);

    <S extends Comment> Page<S> findAll(Example<S> example, Pageable pageable);

    List<Comment> findAllById(Iterable<Long> ids);

    <S extends Comment, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

    Optional<Comment> findById(Long id);

    <S extends Comment> Optional<S> findOne(Example<S> example);

    void flush();

    Comment getById(Long arg0);

    Comment getOne(Long arg0);

    Comment getReferenceById(Long id);

    <S extends Comment> S save(S entity);

    <S extends Comment> List<S> saveAll(Iterable<S> entities);

    <S extends Comment> List<S> saveAllAndFlush(Iterable<S> entities);

    <S extends Comment> S saveAndFlush(S entity);

	Page<Comment> pagecomment(String username, Pageable pageable);

}