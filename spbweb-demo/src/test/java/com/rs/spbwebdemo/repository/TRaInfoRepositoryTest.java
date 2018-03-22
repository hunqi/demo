package com.rs.spbwebdemo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
	
}
