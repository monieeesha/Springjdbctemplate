package com.stackroute.springJdbc.controller;


import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Component
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository springJdbcRepository;

    public ResponseEntity<String> executeShow()
    {
        Movie entity = springJdbcRepository.get(101);
        return new ResponseEntity("Movie: " + entity.getMovieId()+","+entity.getMovieName()+","+entity.getReleaseYear()+","+entity.getRatings(), HttpStatus.OK);

    }

    public ResponseEntity<String> insert()
    {
        Movie entity = new Movie(114,"sahu",2011,3.8);
        springJdbcRepository.add(entity);
        return new ResponseEntity("Student Add: " + entity.getMovieId()+","+entity.getMovieName()+","+entity.getReleaseYear()+","+entity.getRatings(), HttpStatus.OK);
    }

    public ResponseEntity<String> read()
    {
        Movie entity = springJdbcRepository.get(103);
        return new ResponseEntity("Student Get: " + entity.getMovieId()+","+entity.getMovieName()+","+entity.getReleaseYear()+","+entity.getRatings(), HttpStatus.OK);
    }

    public ResponseEntity<String> update()
    {
        Movie entity = new Movie(103,"heroine",2016,4.8);
        springJdbcRepository.update(entity);
        return new ResponseEntity("Movie Update: " +  entity.getMovieId()+","+entity.getMovieName()+","+entity.getReleaseYear()+","+entity.getRatings(), HttpStatus.OK);
    }

    public ResponseEntity<String> delete()
    {
        Movie entity = new Movie(105,"sulthan",2014,4.3);
        springJdbcRepository.delete(entity);
        return new ResponseEntity("Student Delete: " +  entity.getMovieId()+","+entity.getMovieName()+","+entity.getReleaseYear()+","+entity.getRatings(), HttpStatus.OK);
    }
    public ResponseEntity<?> getAll()
    {
        List<Movie> studentList =springJdbcRepository.getAll();
        return new ResponseEntity<List<Movie>>(studentList,HttpStatus.OK);
    }
}