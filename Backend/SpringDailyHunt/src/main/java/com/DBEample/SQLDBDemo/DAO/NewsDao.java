package com.DBEample.SQLDBDemo.DAO;

import com.DBEample.SQLDBDemo.Entity.News;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NewsDao extends CrudRepository<News, Integer> {


    @Query("SELECT n FROM News n")
    public List<News> GetAllNews();




}
