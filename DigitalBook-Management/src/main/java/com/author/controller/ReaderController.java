package com.author.controller;



import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.author.Model.Reader;
import com.author.exception.BookNotFoundException;
import com.author.service.ReaderService;

@RestController
@RequestMapping("/api/v1/digitalbooks/")
public class ReaderController {
	
	
	@Autowired
	private ReaderService readerService;
	
	//reader can buy book
	@PostMapping("books/{bId}/buy")
	public Integer addReader(@PathVariable Integer bId, @RequestBody Reader reader)throws NullPointerException, SQLException,BookNotFoundException {
		return readerService.addReader(reader, bId);
	}
	
	//reader can refund the book
	@GetMapping("readers/{email}/books/{bId}/refund")
	public ResponseEntity<String> findRefundWithEmailAndBid(@PathVariable String email, @PathVariable Integer bId)
	{
		
		List<Reader> findRefund = readerService.findRefund(email, bId);
		boolean result= findRefund.isEmpty();
		if(result!=true)
		{
			return new ResponseEntity<>("your refund will be processed ..!" ,HttpStatus.OK);
		}
		return new ResponseEntity<>("Sorry your request can not be processed...!",HttpStatus.BAD_REQUEST);
	}

}
	
	
	
	  
