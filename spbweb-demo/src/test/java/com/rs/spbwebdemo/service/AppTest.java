package com.rs.spbwebdemo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.rs.spbwebdemo.reverser.Reverser;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
	
	@MockBean
	IRemoteService remoteService;
	
	@Autowired
	Reverser reverser;
	
	@Test
	public void test1(){
		given(this.remoteService.someCall()).willReturn("mock");
		String reverse = reverser.reverseSomeCall();
		assertThat(reverse).isEqualTo("kcom");
	}
	
}
