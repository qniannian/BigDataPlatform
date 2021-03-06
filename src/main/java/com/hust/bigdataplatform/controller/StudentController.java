package com.hust.bigdataplatform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.service.StudentService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * 查询所有的学生
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectAllStudents")
	public Object selectAllStudents(@RequestParam(value = "start", required = true) int start,
			@RequestParam(value = "limit", required = true) int limit, HttpServletRequest request) {
		List<Student> students = studentService.selectAllStudents(start,limit);
		if (null == students || students.size() == 0) {
			return ResultUtil.errorWithMsg("查询所有学生失败，查询为空");
		}
		return ResultUtil.success(students);
	}
	
	
}
