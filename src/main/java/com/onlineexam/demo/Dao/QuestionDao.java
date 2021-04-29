package com.onlineexam.demo.Dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineexam.demo.Model.Questions;

@Repository
@Transactional
public class QuestionDao extends JdbcDaoSupport{
	
	@Autowired
    public QuestionDao(DataSource dataSource) {
        this.setDataSource(dataSource);
    }
			
		
		public List<Questions> getAllQuestionsData(){
			
			String sql = "select * from questions";
			
			List<Questions> documentList = this.getJdbcTemplate().query(sql,
					BeanPropertyRowMapper.newInstance(Questions.class));
			
			return documentList;
			
		}
		
}
