package com.directory.movies.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;
import org.junit.Before;
import java.util.List;
import com.directory.movies.domain.Movie;

@DataMongoTest
@RunWith(SpringJUnit4ClassRunner.class)
public class MoviesDaoImplTest {
	
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Autowired
    MoviesDaoImpl dao;
    
    Movie m;
    static private String ROCKY = "Rocky";

    @Before
	public void setUp() {
    	m = new Movie("The godfather", 1972);

	}

    /**
     * Test to check empty database
     * @throws Exception
     */
	 @Test
	 public void testFindAllEmptyDatabase() throws Exception {
		 List<Movie> movies = dao.findAll();
		 Assert.assertEquals(movies.size(),0);
	 } 
	 
	 /**
	  * Test to insert a new movie
	  * @throws Exception
	  */
	 @Test
	 public void testInsertMovie() throws Exception {
		 
		 dao.save(m);
		 List<Movie> movies = dao.findAll();
		 Assert.assertTrue(movies.size() > 0);
	 }
	 
	 /**
	  * Test to insert an existing database, should not insert any data
	  * @throws Exception
	  */
	 @Test
	 public void testInsertExisingMovie() throws Exception {
		 
		dao.save(m);

	 }
	 
	 /**
	  * Test find by year
	  * @throws Exception
	  */
	 @Test
	 public void testGetMovieByYear() throws Exception {
		 List<Movie> movies = dao.findMoviesByYear(1972);
		 Assert.assertEquals(movies.get(0).getTitle(),m.getTitle());
		 Assert.assertEquals(movies.get(0).getYear(),m.getYear());
		 Assert.assertEquals(movies.size(),1);
	 }
	 
	 /**
	  * Test to find lot os movies inserted
	  * @throws Exception
	  */
	 @Test
	 public void testFindAllDatabase() throws Exception {
		 for (int i = 1; i<=35; i++) {
			 m = new Movie(ROCKY+" "+ i,1976+i); 
			 dao.save(m);
		 }
		 List<Movie> movies = dao.findAll();
		 Assert.assertTrue(movies.size()>=35);
	 } 
	 
}
