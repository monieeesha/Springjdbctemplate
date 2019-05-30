package com.stackroute.springJdbc.repository;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.mapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SpringJdbcRepository {

    private JdbcTemplate jdbcTemplate ;

    public SpringJdbcRepository(){}



    @Autowired
    public void  setDataSource(final DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAll() {

        return jdbcTemplate.query("SELECT * FROM moviedetail", new MovieRowMapper());
    }

    public int add(Movie movie) {
        return jdbcTemplate.update("INSERT INTO moviedetail VALUES (?,?,?,?)", movie.getMovieId(),movie.getMovieName(),movie.getReleaseYear(),movie.getRatings());
    }

    public Movie get(final int id) {
        final String query = "SELECT * FROM moviedetail WHERE movieid= ?";
        return jdbcTemplate.queryForObject(query, new Object[] { id }, new MovieRowMapper());
    }

    public int update(Movie entity) {
        return jdbcTemplate.update("UPDATE moviedetail SET ratings=? WHERE movieid=?",entity.getRatings(),entity.getMovieId());
    }


    public int delete(Movie entity) {
        return jdbcTemplate.update("DELETE FROM moviedetail WHERE movieid=?", entity.getMovieId());
    }

}
