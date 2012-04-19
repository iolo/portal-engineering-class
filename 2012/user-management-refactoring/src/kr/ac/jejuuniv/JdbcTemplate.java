package kr.ac.jejuuniv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JdbcTemplate {
	@Autowired
	private JdbcContext jdbcContext;

	public JdbcTemplate() {
	}

	public JdbcContext getJdbcContext() {
		return jdbcContext;
	}

	public void setJdbcContext(JdbcContext jdbcContext) {
		this.jdbcContext = jdbcContext;
	}

	public List<User> findAll(final String query) {
		StatementStrategy statementStrategy = new StatementStrategy() {
			public PreparedStatement findAll(Connection connection) throws SQLException {
				return connection.prepareStatement(query);
			}
		};
		return getJdbcContext().findAll(statementStrategy);
	}
}