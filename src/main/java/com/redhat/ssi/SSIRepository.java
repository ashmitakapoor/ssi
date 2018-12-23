package com.redhat.ssi;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface SSIRepository extends MongoRepository<SSI, String> {
	
	 List<SSI> findAll(Sort sortByCreatedAtDesc);
    
     @Query("{_id:'?0'}")
	 SSI findOneById(String id);

	 @Query("{'ssiName': {$regex: ?0, $options:'i' }})")
	 List<SSI> findBySsiName(String ssiName);

	 void delete(String ssi);
}
