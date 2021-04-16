package com.DBEample.SQLDBDemo.Service;

import com.DBEample.SQLDBDemo.Entity.News;

import java.util.List;

public interface NewsService {

    public List<News> GETAllNews();

    public void ADDnews(News news);



}
