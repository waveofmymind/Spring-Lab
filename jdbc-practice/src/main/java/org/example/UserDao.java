package org.example;

import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.*;

public class UserDao {


    public void create2(User user) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
        jdbcTemplate.executeUpdate(user, sql, new PreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement pstmt) throws SQLException {
                        pstmt.setString(1, user.getUserId());
                        pstmt.setString(2, user.getPassword());
                        pstmt.setString(3, user.getName());
                        pstmt.setString(4, user.getEmail());
                    }
                }
        );
    }

    public User findByUserId2(String userId) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        String sql = "SELECT userId, password, name, email FROM USERS WHERE userId = ?";

        return (User) jdbcTemplate.executeQuery(sql, pstmt -> pstmt.setString(1, userId), resultSet -> new User(
                resultSet.getString("userId"),
                resultSet.getString("password"),
                resultSet.getString("name"),
                resultSet.getString("email")

        ));

    }
}

