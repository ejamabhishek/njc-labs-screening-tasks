package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.SuburbDao;
import com.example.demo.model.Suburb;

@RestController
@RequestMapping("/suburbs")
public class SuburbController {
	@Autowired
	private SuburbDao dao;
	
	@GetMapping("/getSuburbs")
	public List<Suburb> getSuburbs() {
		return (List<Suburb>) dao.findAll();
	}

}
