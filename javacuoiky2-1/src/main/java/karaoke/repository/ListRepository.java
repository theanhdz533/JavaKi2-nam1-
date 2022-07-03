package karaoke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import karaoke.domain.List;
@Repository
public interface ListRepository extends JpaRepository<List, Long> {
      
	java.util.List<List> findByTenBhContaining(String tenBh);
	long countByTenBhContaining(String tenBh);
	long countByTheLoaiContaining(String theLoai);
	
}
 