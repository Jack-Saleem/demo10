package com.student.microserv.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.student.microserv.controller.model.Student;

@Repository
public class StudentDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*Getting all students from table*/
    public List<Student> getAllStuds(){
        List<Student> students = jdbcTemplate.query("select * from oneforall.student",(result,rowNum)->new Student(result.getInt("studentId"),
                result.getString("studentName"),result.getInt("studentAge"),result.getString("studentMailid")));
    	
    	/*List<Student> students  = jdbcTemplate.query("select s.studentId as stdId,s.studentName as stdName,"
    			+ "s.studentAge as stdAge,s.studentMailid as stdMail from oneforall.student s",new BeanPropertyRowMapper(Student.class));*/
    	//Above Column Names and Java DataType Names SHOULD MATCH
    	
        /*String sql = "SELECT * FROM oneforall.student";
        List<Map<String, Object>> retList = jdbcTemplate.queryForList(sql);
        List<Student> students =new ArrayList();
        for(Map<String,Object> row:retList){
    		Student student = new Student();
    		student.setStdId((Integer)(row.get("studentId")));
    		student.setStdName((String)row.get("studentName"));
    		student.setStdAge((Integer)row.get("studentAge"));
    		student.setStdMail((String)row.get("studentMailid"));
    		students.add(student);
    	}*/
        return students;
    }
    
    /*Getting a specific student by student id from table*/
    public Student getStudentById(int stdId){
        String query = "SELECT s.studentId as stdId,s.studentName as stdName,s.studentAge as stdAge,s.studentMailid as stdMail FROM oneforall.student as s WHERE s.studentId=?";
        //Student std = jdbcTemplate.queryForObject(query, Student.class);
        //Student std = (Student)jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<Student>(Student.class), studentId);
        Student std = jdbcTemplate.queryForObject(query,new Object[]{stdId},new BeanPropertyRowMapper<Student>(Student.class));
        return std;
    }
    
    /*Adding a student into database table*/
    public int addStudent(int id,String name,int age,String mailid){
        String query = "INSERT INTO oneforall.student VALUES(?,?,?,?)";
        return jdbcTemplate.update(query,id,name,age,mailid);
    }
    
    public int addStudentFrmObj(Student stu){
        String query = "INSERT INTO oneforall.student VALUES(?,?,?,?)";
        return jdbcTemplate.update(query,stu.getStdId(),stu.getStdName(),stu.getStdAge(),stu.getStdMail());
    }
    
    /*delete a student from database*/
    public int deleteStudent(int id){
        String query = "DELETE FROM oneforall.student WHERE studentId =?";
        return jdbcTemplate.update(query,id);
    }
}
