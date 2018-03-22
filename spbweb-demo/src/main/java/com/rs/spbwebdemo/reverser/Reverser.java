package com.rs.spbwebdemo.reverser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.rs.spbwebdemo.service.IRemoteService;

@Component
public class Reverser {

	private IRemoteService remoteService;

	@Autowired
	public Reverser(IRemoteService remoteService) {
		this.remoteService = remoteService;
	}

	public String reverseSomeCall() {
		String resp = remoteService.someCall();
		if(StringUtils.isEmpty(resp)) return resp;
		
		StringBuilder sb = new StringBuilder();
		for(int i=resp.length() - 1; i>=0; i--){
			sb.append(resp.charAt(i));
		}
		
		return sb.toString();
	}

}
