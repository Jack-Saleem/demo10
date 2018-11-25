package com.student.microserv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.microserv.controller.model.Student;
import com.student.microserv.dao.StudentDAO;

@RestController
public class StudentController {

	@Autowired
	private StudentDAO stddao;
	
	@RequestMapping(value="/getAllStuds", method = RequestMethod.GET)
	public List<Student> getAllStudents(){
		System.out.println("Getting ALl Student details");
		return stddao.getAllStuds();
	}
	
	@RequestMapping(value="/getStud", method = RequestMethod.POST)
    @ResponseBody
    public Student getStudentById(@RequestParam("stdId") int stdId){
        return stddao.getStudentById(stdId);
    }
	
	//@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping(value="/addStudAsObj", method = RequestMethod.POST)
    @ResponseBody
    public String addItem(@RequestBody Student student){
		System.out.println(student.toString());
        if(stddao.addStudentFrmObj(student) >= 1){
            return "Student Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
	
	@RequestMapping(value="/addStud", method = RequestMethod.POST)
    @ResponseBody
    public String addItem(@RequestParam("id") int id,@RequestParam("name") String name,
    					@RequestParam("age") int age,@RequestParam("mail") String mail){
        if(stddao.addStudent(id,name,age,mail) >= 1){
            return "Student Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
	
	@RequestMapping(value="/deleteStud", method = RequestMethod.POST)
    @ResponseBody
    public String deteteItem(@RequestParam("stdId") int stdId){
        if(stddao.deleteStudent(stdId) >= 1){
            return "Student Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
}
