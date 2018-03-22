package com.rs.spbwebdemo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rs.spbwebdemo.entity.QTRaInfo;

/**
 * Test querydsl
 * 
 * @author ray.sun
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TRaInfoRepositoryTest2 {

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	private JPAQueryFactory queryFactory;
	private QTRaInfo qtraInfo = QTRaInfo.tRaInfo;
	
	@Before
	public void setUp(){
		queryFactory = new JPAQueryFactory(entityManager);
	}
	
	@Test
	public void test_findOne(){
		System.out.println(
				queryFactory.selectFrom(qtraInfo)
				.where(qtraInfo.homeridRa.eq("60160218"))
				.fetchOne());
	}
	
	

}
