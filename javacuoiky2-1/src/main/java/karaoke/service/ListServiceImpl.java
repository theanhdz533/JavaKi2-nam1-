package karaoke.service;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import karaoke.domain.List;
import karaoke.repository.ListRepository;
@Service
public class ListServiceImpl implements ListService {
      ListRepository listRepository;

	public ListServiceImpl(ListRepository listRepository) {
		this.listRepository = listRepository;
	}
    
	@Override
	public long countByTheLoaiContaining(String theLoai) {
		return listRepository.countByTheLoaiContaining(theLoai);
	}
   
	@Override
	public java.util.List<List> findByTenBhContaining(String tenBh) {
		return listRepository.findByTenBhContaining(tenBh);
	}

	@Override
	public long countByTenBhContaining(String tenBh) {
		return listRepository.countByTenBhContaining(tenBh);
	}

	@Override
	public <S extends List> S save(S entity) {
		return listRepository.save(entity);
	}

	@Override
	public <S extends List> Optional<S> findOne(Example<S> example) {
		return listRepository.findOne(example);
	}

	@Override
	public java.util.List<List> findAll() {
		return listRepository.findAll();
	}

	@Override
	public Page<List> findAll(Pageable pageable) {
		return listRepository.findAll(pageable);
	}

	@Override
	public java.util.List<List> findAll(Sort sort) {
		return listRepository.findAll(sort);
	}

	@Override
	public java.util.List<List> findAllById(Iterable<Long> ids) {
		return listRepository.findAllById(ids);
	}

	@Override
	public Optional<List> findById(Long id) {
		return listRepository.findById(id);
	}

	@Override
	public <S extends List> java.util.List<S> saveAll(Iterable<S> entities) {
		return listRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		listRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return listRepository.existsById(id);
	}

	@Override
	public <S extends List> S saveAndFlush(S entity) {
		return listRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends List> java.util.List<S> saveAllAndFlush(Iterable<S> entities) {
		return listRepository.saveAllAndFlush(entities);
	}

	@Override
	public void deleteInBatch(Iterable<List> entities) {
		listRepository.deleteInBatch(entities);
	}

	@Override
	public void deleteAllInBatch(Iterable<List> entities) {
		listRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return listRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		listRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		listRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(List entity) {
		listRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		listRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		listRepository.deleteAllInBatch();
	}

	@Override
	public List getOne(Long id) {
		return listRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends List> entities) {
		listRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		listRepository.deleteAll();
	}

	@Override
	public List getById(Long id) {
		return listRepository.getById(id);
	}

	@Override
	public List getReferenceById(Long id) {
		return listRepository.getReferenceById(id);
	}
	
	
      
}
