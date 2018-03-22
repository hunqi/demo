package com.rs.spbwebdemo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rs.spbwebdemo.entity.TRaInfo;

@Repository
public interface TRaInfoRepository extends CrudRepository<TRaInfo, Long>, QueryDslPredicateExecutor<TRaInfo> {

	TRaInfo findByHomeridRa(String homeridRa);

	Page<TRaInfo> findByHomeridRaLessThan(String homeridRa, Pageable pageable);

	List<TRaInfo> findByHomeridRaLessThan(String homeridRa, Sort sort);

	List<TRaInfo> findFirst6ByHomeridRaLessThan(String homeridRa, Sort sort);

	List<TRaInfo> findTop5ByHomeridRaLessThan(String homeridRa, Sort sort);

	List<TRaInfo> findByNameDsmAndNameRa(String nameDsm, String nameRa);

	List<TRaInfo> findByNameDsmOrderByHomeridRaDesc(String nameDsm);

	long countByHomeridRaLessThan(String homeridRa);

	long countByHomeridRaBetween(String start, String end);

	long countByNameDsm(String nameDsm);

}
