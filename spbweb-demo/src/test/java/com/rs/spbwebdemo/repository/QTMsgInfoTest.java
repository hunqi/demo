package com.rs.spbwebdemo.repository;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rs.spbwebdemo.entity.QTMsgInfo;

/**
 * test Querydsl
 * @author ray.sun
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class QTMsgInfoTest {

	@Autowired
	@PersistenceContext
	private EntityManager entityManager;

	private JPAQueryFactory queryFactory;
	
	private QTMsgInfo qtmsgInfo = QTMsgInfo.tMsgInfo;
	
	@Before
	public void setUp(){
		queryFactory = new JPAQueryFactory(entityManager);
	}
	
	@Test
	public void test_findByTemplateAndCdate(){
		long total = queryFactory.selectFrom(qtmsgInfo)
				.where(qtmsgInfo.TTemplateType.code.eq("ALERT_RA")
						.and(qtmsgInfo.cdate.before(new Date()))
						.and(qtmsgInfo.TStatus.statusCode.in(0, 4)))
				.fetchCount();
		
		System.out.println("total_count=" + total);
	}
	
}
