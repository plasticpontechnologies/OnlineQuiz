package com.onlineexam.demo.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.demo.Model.Question;
import com.onlineexam.demo.Model.option;

@Repository
@Transactional
public class QuestionDao extends JdbcDaoSupport{
	
	@Autowired
    public QuestionDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
	
		
		
		
	/*
	 * public List<option> getAllDocumentData(){
	 * 
	 * String sql =
	 * "SELECT Question.question1,options.options FROM Question,options Where Question.question_id=options.optionID"
	 * ;
	 * 
	 * List<option> documentList = this.getJdbcTemplate().query(sql,
	 * BeanPropertyRowMapper.newInstance(option.class));
	 * 
	 * return documentList;
	 * 
	 * }
	 */
	public List<Question> getAllDocumentData(String name){
		
		String sql = "select * from questions where course_name = '"+name+"'";
		
		/*
		 * Object[] param = new Object[] {name}; List<Question> questionsList =
		 * this.getJdbcTemplate().queryForList(sql, param, Question.class);
		 */
		List<Question> questionsList = this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<Question>(Question.class));
		return questionsList;
		
	}

	public List<option> getOptionsById(int questionId){
		String sql = "select option_Id,option_name,question_Id from options where question_Id= '"+questionId+"'";
		List<option> optionList = this.getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<option>(option.class));
		return optionList;
	}
}
