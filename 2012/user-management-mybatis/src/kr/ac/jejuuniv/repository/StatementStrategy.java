package kr.ac.jejuuniv.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface StatementStrategy {

	PreparedStatement findAll(Connection connection) throws SQLException;

}
