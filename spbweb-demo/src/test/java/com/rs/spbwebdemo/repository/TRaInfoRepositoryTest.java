package com.rs.spbwebdemo.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.querydsl.core.types.Predicate;
import com.rs.spbwebdemo.entity.QTRaInfo;
import com.rs.spbwebdemo.entity.TRaInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TRaInfoRepositoryTest {
	
	@Autowired
	TRaInfoRepository dao;
	
	@Test
	public void test_findByHomeridRa(){
		System.out.println(dao.findByHomeridRa("60160249"));
	}
	
	@Test
	public void test_findByNameDsmAndNameRa(){
		System.out.println("size=" + dao.findByNameDsmAndNameRa("顾旺", "李孟强").size());
	}
	
	@Test
	public void test_findByNameDsmOrderByHomeridRaDesc(){
		List<TRaInfo> list = dao.findByNameDsmOrderByHomeridRaDesc("黄晓萍");
		for(TRaInfo i : list)
			System.out.println(i);
	}
	
	@Test
	public void test_countByNameDsm(){
		long num = dao.countByNameDsm("黄晓萍");
		System.out.println("num=" + num);
	}
	
	@Test
	public void test_countByHomeridRaLessThan(){
		System.out.println("countByHomeridRaLessThan=" + dao.countByHomeridRaLessThan("60160218"));
	}
	
	@Test
	public void test_countByHomeridRaBetween(){
		System.out.println(
				"countByHomeridRaLessThanAndGreaterThan=" 
						+ dao.countByHomeridRaBetween("60160200", "60160218"));
	}
	
	@Test
	public void test_findByHomeridRaLessThan(){
		PageRequest pager = new PageRequest(0, 10);
		Page<TRaInfo> result = dao.findByHomeridRaLessThan("60160218", pager);
		System.out.println("page.size=" + result.getTotalPages());
		for(TRaInfo i : result ){
			System.out.println(i);
		}		
	}
	
	@Test
	public void  test_findByHomeridRaLessThan_sort(){
		
		Sort sort = new Sort(/*Direction.ASC, */"homeridRa");
		List<TRaInfo> list = dao.findByHomeridRaLessThan("60160218", sort);
		
		for(TRaInfo i : list)
			System.out.println(i);
	}
	
	@Test
	public void test_findFirst6ByHomeridRaLessThan(){
		Sort sort = new Sort(/*Direction.ASC, */"homeridRa");
		List<TRaInfo> list = dao.findFirst6ByHomeridRaLessThan("60160218", sort);
		
		for(TRaInfo i : list)
			System.out.println(i);
	}
	
	@Test
	public void test_findTop5ByHomeridRaLessThan(){
		Sort sort = new Sort(/*Direction.ASC, */"homeridRa");
		List<TRaInfo> list = dao.findTop5ByHomeridRaLessThan("60160218", sort);
		
		for(TRaInfo i : list)
			System.out.println(i);
	}
	
	@Test
	public void test_findOne_by_predicate(){
		QTRaInfo qraInfo = QTRaInfo.tRaInfo;
		Predicate predicate = qraInfo.homeridRa.eq("60160256");
		System.out.println(dao.findOne(predicate));
	}
	
	@Test
	public void test_findAll_by_predicate(){
		QTRaInfo qraInfo = QTRaInfo.tRaInfo;
		Predicate predicate = qraInfo.homeridRa.between("60160200", "60160218");
		
		System.out.println("result.size=" + dao.count(predicate));
	}
	
}
