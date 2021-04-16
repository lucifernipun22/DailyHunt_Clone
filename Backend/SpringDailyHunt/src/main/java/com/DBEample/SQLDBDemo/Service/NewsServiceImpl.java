package com.DBEample.SQLDBDemo.Service;

import com.DBEample.SQLDBDemo.DAO.NewsDao;
import com.DBEample.SQLDBDemo.Entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;


    @Override
    @Transactional
    public List<News> GETAllNews() {
        return newsDao.GetAllNews();
    }

    @Override
    public void ADDnews(News news) {

    }
}
