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

import poly.dn.hyundai.Entity.NewsImage;
import poly.dn.hyundai.Repository.NewImageRepository;
import poly.dn.hyundai.service.NewImageService;

@Service
public class NewImageServiceImpl implements NewImageService {
    
    NewImageRepository newImageRepository;

   
    public NewImageServiceImpl(NewImageRepository newImageRepository) {
        this.newImageRepository = newImageRepository;
    }

    @Override
	public Page<NewsImage> findByTitle(Integer id, Pageable pageable) {
		return newImageRepository.findByTitle(id, pageable);
	}

	@Override
    public long count() {
        return newImageRepository.count();
    }

    @Override
    public <S extends NewsImage> long count(Example<S> example) {
        return newImageRepository.count(example);
    }

    @Override
    public void delete(NewsImage entity) {
        newImageRepository.delete(entity);
    }

    @Override
    public void deleteAll() {
        newImageRepository.deleteAll();
    }

    @Override
    public void deleteAll(Iterable<? extends NewsImage> entities) {
        newImageRepository.deleteAll(entities);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        newImageRepository.deleteAllById(ids);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        newImageRepository.deleteAllByIdInBatch(ids);
    }

    @Override
    public void deleteAllInBatch() {
        newImageRepository.deleteAllInBatch();
    }

    @Override
    public void deleteAllInBatch(Iterable<NewsImage> entities) {
        newImageRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteById(Long id) {
        newImageRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(Iterable<NewsImage> entities) {
        newImageRepository.deleteInBatch(entities);
    }

    @Override
    public <S extends NewsImage> boolean exists(Example<S> example) {
        return newImageRepository.exists(example);
    }

    @Override
    public boolean existsById(Long id) {
        return newImageRepository.existsById(id);
    }

    @Override
    public <S extends NewsImage> List<S> findAll(Example<S> example) {
        return newImageRepository.findAll(example);
    }

    @Override
    public <S extends NewsImage> List<S> findAll(Example<S> example, Sort sort) {
        return newImageRepository.findAll(example, sort);
    }

    @Override
    public List<NewsImage> findAll() {
        return newImageRepository.findAll();
    }

    @Override
    public List<NewsImage> findAll(Sort sort) {
        return newImageRepository.findAll(sort);
    }

    @Override
    public Page<NewsImage> findAll(Pageable pageable) {
        return newImageRepository.findAll(pageable);
    }

    @Override
    public <S extends NewsImage> Page<S> findAll(Example<S> example, Pageable pageable) {
        return newImageRepository.findAll(example, pageable);
    }

    @Override
    public List<NewsImage> findAllById(Iterable<Long> ids) {
        return newImageRepository.findAllById(ids);
    }

    @Override
    public <S extends NewsImage, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return newImageRepository.findBy(example, queryFunction);
    }

    @Override
    public Optional<NewsImage> findById(Long id) {
        return newImageRepository.findById(id);
    }

    @Override
    public <S extends NewsImage> Optional<S> findOne(Example<S> example) {
        return newImageRepository.findOne(example);
    }

    @Override
    public void flush() {
        newImageRepository.flush();
    }

    @Override
    public NewsImage getById(Long arg0) {
        return newImageRepository.getById(arg0);
    }

    @Override
    public NewsImage getOne(Long arg0) {
        return newImageRepository.getOne(arg0);
    }

    @Override
    public NewsImage getReferenceById(Long id) {
        return newImageRepository.getReferenceById(id);
    }

    @Override
    public <S extends NewsImage> S save(S entity) {
        return newImageRepository.save(entity);
    }

    @Override
    public <S extends NewsImage> List<S> saveAll(Iterable<S> entities) {
        return newImageRepository.saveAll(entities);
    }

    @Override
    public <S extends NewsImage> List<S> saveAllAndFlush(Iterable<S> entities) {
        return newImageRepository.saveAllAndFlush(entities);
    }

    @Override
    public <S extends NewsImage> S saveAndFlush(S entity) {
        return newImageRepository.saveAndFlush(entity);
    }

    
}
