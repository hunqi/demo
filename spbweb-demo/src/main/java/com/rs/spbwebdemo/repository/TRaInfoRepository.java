package com.rs.spbwebdemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.spbwebdemo.entity.TRaInfo;

@Repository
public interface TRaInfoRepository extends CrudRepository<TRaInfo, Long>{
	
	TRaInfo findByHomeridRa(String homeridRa);
	
	List<TRaInfo> findByNameDsmAndNameRa(String nameDsm, String nameRa);
	
}
