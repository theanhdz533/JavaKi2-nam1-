package karaoke.service;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import karaoke.domain.List;

public interface ListService {

	List getReferenceById(Long id);

	List getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends List> entities);

	List getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(List entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<List> entities);

	void deleteInBatch(Iterable<List> entities);

	<S extends List> java.util.List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends List> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends List> java.util.List<S> saveAll(Iterable<S> entities);

	Optional<List> findById(Long id);

	java.util.List<List> findAllById(Iterable<Long> ids);

	java.util.List<List> findAll(Sort sort);

	Page<List> findAll(Pageable pageable);

	java.util.List<List> findAll();

	<S extends List> Optional<S> findOne(Example<S> example);

	<S extends List> S save(S entity);

	java.util.List<List> findByTenBhContaining(String tenBh);

	long countByTenBhContaining(String tenBh);

	long countByTheLoaiContaining(String theLoai);

}
