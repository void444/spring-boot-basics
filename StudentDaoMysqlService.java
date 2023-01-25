package com.example.democlass.dao.mysql;

import org.springframework.stereotype.Service;

import com.example.democlass.dao.StudentDAO;
@Service
public class StudentDaoMysqlService implements StudentDAO{

	public String getData() {
		return "mysql data";
	}

}
