package com.DBEample.SQLDBDemo.Repository;

import com.DBEample.SQLDBDemo.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News,Integer> {

}
