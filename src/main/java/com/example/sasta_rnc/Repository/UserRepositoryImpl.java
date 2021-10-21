package com.example.sasta_rnc.Repository;

import com.example.sasta_rnc.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
class UserRepositoryImpl implements UserRepository {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getString("email"), rs.getString("password"), rs.getString("role"), rs.getInt("id"));
        }
    };

    @Override
    public User findByEmail(String email) {
        String sqlQuery = "select * from users where email=" + email;
        User user = jdbcTemplate.queryForObject(sqlQuery,userRowMapper);
        return user;
    }

    @Override
    public void save(User user) {
        System.out.println(user);
        String sqlQuery = "insert into user(email,password,role) values(?,?,?)";
        jdbcTemplate.update(sqlQuery,user.getEmail(),user.getPassword(),user.getRole());
    }
}