package com.author.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.author.Model.Reader;

@Repository
public interface ReaderRepository  extends JpaRepository<Reader, Integer>{

@Query(value = "select * from reader where reader.email=?1 and reader.b_id=?2 and reader.purchase_time > DATE_SUB(CURDATE(),INTERVAL 1 DAY)" ,nativeQuery =true)
public List<Reader> findByPurchaseTimeWithEmailAndBookId(String email ,Integer bId);
	
	
	
}
