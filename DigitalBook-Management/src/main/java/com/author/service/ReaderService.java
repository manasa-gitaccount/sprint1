package com.author.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.author.Model.Reader;

@Service
public interface ReaderService {

	
	public Integer addReader(Reader reader, Integer bId);
	
	public List<Reader> findRefund(String email, Integer bId);
	
	
}
