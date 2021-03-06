package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.StudentDao;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Student> selectAllStudents(int start, int limit) {
		// TODO Auto-generated method stub
		List<Student> stus = studentDao.selectStudents(start, limit);
		if(stus.isEmpty()){
			logger.info("未查找到学生");
		}
		return stus;
	}

}
