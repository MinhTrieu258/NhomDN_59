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

import jakarta.transaction.Transactional;
import poly.dn.hyundai.Entity.Account;
import poly.dn.hyundai.Entity.Comment;
import poly.dn.hyundai.Repository.AccountDao;
import poly.dn.hyundai.Repository.CommentRepository;
import poly.dn.hyundai.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
     @Autowired
     AccountDao accountDao;
    @Override
	public Page<Comment> pagecomment(String username, Pageable pageable) {
		return commentRepository.pagecomment(username, pageable);
	}

	CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
 public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
 
    @Override
    public long count() {
        return commentRepository.count();
    }

    @Override
    public <S extends Comment> long count(Example<S> example) {
        return commentRepository.count(example);
    }

    @Override
    public void delete(Comment entity) {
        commentRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        commentRepository.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends Comment> entities) {
        commentRepository.deleteAll(entities);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        commentRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        commentRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        commentRepository.deleteAllInBatch();
    }

    @Override
    public void deleteAllInBatch(Iterable<Comment> entities) {
        commentRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(Iterable<Comment> entities) {
        commentRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends Comment> boolean exists(Example<S> example) {
        return commentRepository.exists(example);
    }

    @Override
    public boolean existsById(Long id) {
        return commentRepository.existsById(id);
    }

    @Override
    public <S extends Comment> List<S> findAll(Example<S> example) {
        return commentRepository.findAll(example);
    }

    @Override
    public <S extends Comment> List<S> findAll(Example<S> example, Sort sort) {
        return commentRepository.findAll(example, sort);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> findAll(Sort sort) {
        return commentRepository.findAll(sort);
    }

    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public <S extends Comment> Page<S> findAll(Example<S> example, Pageable pageable) {
        return commentRepository.findAll(example, pageable);
    }

    @Override
    public List<Comment> findAllById(Iterable<Long> ids) {
        return commentRepository.findAllById(ids);
    }

    @Override
    public <S extends Comment, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return commentRepository.findBy(example, queryFunction);
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public <S extends Comment> Optional<S> findOne(Example<S> example) {
        return commentRepository.findOne(example);
    }

    @Override
    public void flush() {
        commentRepository.flush();
    }

    @Override
    public Comment getById(Long arg0) {
        return commentRepository.getById(arg0);
    }

    @Override
    public Comment getOne(Long arg0) {
        return commentRepository.getOne(arg0);
    }

    @Override
    public Comment getReferenceById(Long id) {
        return commentRepository.getReferenceById(id);
    }

    @Override
    public <S extends Comment> S save(S entity) {
        return commentRepository.save(entity);
    }

    @Override
    public <S extends Comment> List<S> saveAll(Iterable<S> entities) {
        return commentRepository.saveAll(entities);
    }

    @Override
    public <S extends Comment> List<S> saveAllAndFlush(Iterable<S> entities) {
        return commentRepository.saveAllAndFlush(entities);
    }

    @Override
    public <S extends Comment> S saveAndFlush(S entity) {
        return commentRepository.saveAndFlush(entity);
    }
	@Override
	public void addComment(String username, String commentDescription) {
		// TODO Auto-generated method stub
		
	}

    
}
