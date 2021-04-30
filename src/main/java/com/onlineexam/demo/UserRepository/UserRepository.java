package com.onlineexam.demo.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

//import com.onlineexam.demo.Model.Questions;
import com.onlineexam.demo.Model.User;

@Component
public class UserRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	KeyHolder saveUserRoleKeyHolder = new GeneratedKeyHolder();
	KeyHolder keyHolderUserApp = new GeneratedKeyHolder();
	public int saveUser(User user) {
		long startTime = System.currentTimeMillis();
		List<User> user1 = findUser1(user);
		
		System.out.println("Total no.of Objects are " + user1.size());
		System.out.println("Time taken to read the records from user table " + (System.currentTimeMillis() - startTime)
				+ " milliseconds");
		System.out.println(user.getFirstname() + " " + user.getLastname());
		System.out.println(user1);
		for (User u : user1) {
			// System.out.println("inside loop");
			String firstName = u.getFirstname();
			String lastName = u.getLastname();
			if ((user.getFirstname().equalsIgnoreCase(firstName)) && (user.getLastname().equalsIgnoreCase(lastName))) {
				System.out.println("user already exists ");
				return 0;
			}
		}
		return jdbcTemplate.update(
				"insert into user (firstname,lastname,email,password,phone_number,gender) values (?,?,?,?,?,?)",
				new Object[] { user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(),user.getPhone_number(),
						 user.getGender() });
		// keyHolderUser.getKey().intValue();
	}
	public List<User> findUser1(User user) {
		//System.out.println("user details" + user);
		String QUERY_UserValid = "select firstname,lastname from user ";
		System.out.println(QUERY_UserValid);
		List<User> client = jdbcTemplate.query(QUERY_UserValid, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println(rs.getFetchSize());
				User userData = new User();
				userData.setFirstname((rs.getString("firstname")));
				userData.setLastname((rs.getString("lastname")));
				return userData;
			}
		});
		return client;
	}
	public Long saveUserAppDetails(final User user) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				 PreparedStatement statement = con.prepareStatement("insert into app_user (user_name,ENCRYTED_PASSWORD,ENABLED) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
				 statement.setString(1, user.getFirstname());
				 statement.setString(2, user.getPassword());
				 statement.setBoolean(3, user.getEnabled());
				return statement;
			}
		}, keyHolderUserApp);
		
		Long returnValue = keyHolderUserApp.getKey().longValue();
		
		return  returnValue;
	}
	/*
	 * public List<User> findUser(User user) { String sql =
	 * "select first_name,last_name from user where first_name = '"+user.
	 * getFirstname()+"'and last_name='"+user.getlastname()+"'";
	 *
	 *
	 * List<User> client = jdbcTemplate.query(sql, new RowMapper<User>() {
	 *
	 * public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	 * System.out.println(rs.getFetchSize());
	 * System.out.println("out put"+rs.getString("first_name")); User userData = new
	 * User(); userData.setFirstname((rs.getString("first_name")));
	 * userData.setLastame((rs.getString("last_name")));
	 *
	 * return userData; }
	 *
	 * }); System.out.println("db result"+client.size()); return client; }
	 */
	/*
	 * public Long saveUserAppDetails(final User user) { jdbcTemplate.update(new
	 * PreparedStatementCreator() {
	 *
	 * public PreparedStatement createPreparedStatement(Connection con) throws
	 * SQLException { PreparedStatement statement = con.
	 * prepareStatement("insert into app_user (user_name,ENCRYTED_PASSWORD,ENABLED) values(?,?,?)"
	 * , Statement.RETURN_GENERATED_KEYS); statement.setString(1,
	 * user.getFirstname()); statement.setString(2, user.getPassword());
	 * statement.setBoolean(3, user.isEnabled()); return statement; } },
	 * keyHolderUserApp);
	 *
	 * Long returnValue = keyHolderUserApp.getKey().longValue();
	 *
	 * return returnValue; }
	 *
	 * public Long saveUserRole(final int user_id,final int role_id) {
	 * jdbcTemplate.update(new PreparedStatementCreator() {
	 *
	 * public PreparedStatement createPreparedStatement(Connection con) throws
	 * SQLException { // TODO Auto-generated method stub PreparedStatement
	 * statement1 =
	 * con.prepareStatement("insert into user_role (user_id,role_id) values(?,?)",
	 * Statement.RETURN_GENERATED_KEYS); statement1.setInt(1, user_id);
	 * statement1.setInt(2, role_id); return statement1; } },
	 * saveUserRoleKeyHolder);
	 *
	 * return saveUserRoleKeyHolder.getKey().longValue(); }
	 */
	public List<String> getNames() {
		String sql = "select user_name from user";
		List<String> user = jdbcTemplate.query(sql, new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// User userData= new User();
				String name = rs.getString("user_name");
				/*
				 * userData.setPhone(rs.getString("phone_number"));
				 * userData.setEmail(rs.getString("email"));
				 * userData.setPassword(rs.getString("password"));
				 */
				return name;
			}
		});
		return user;
	}
//		public void getQuestions() {
//			String sql = "select questions.question_Id,questions.question_name,option_Id from questions,options JOIN option ON(options.option_Id=question.question_Id)";
//		}
		//List<String> questions = jdbcTemplate.query(sql, new RowMapper<String>() {
			//public String mapRow(ResultSet rs, int rowNum) throws SQLException {
			// User userData= new User();
//				String question = rs.getString("question");
//				/*
//				 * userData.setPhone(rs.getString("phone_number"));
//				 * userData.setEmail(rs.getString("email"));
//				 * userData.setPassword(rs.getString("password"));
//				 */
//				return question;
//			}
//		});
//		return questions;
//	}

}