package com.DBEample.SQLDBDemo.RestController;

import com.DBEample.SQLDBDemo.DAO.NewsDao;
import com.DBEample.SQLDBDemo.Entity.News;
import com.DBEample.SQLDBDemo.Service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NewsRestController {

    @Autowired
    private NewsService newsService;

    @Autowired
    private NewsDao newsDao;

    public NewsRestController(NewsService newsService, NewsDao newsDao) {
        this.newsService = newsService;
        this.newsDao = newsDao;
    }

    @GetMapping("/news")
    public List<News> getAllEmp(){

        List<News> newsList = newsService.GETAllNews();

        return newsList;
    }

    @GetMapping("/newNews")
    public String addnews(


            @RequestParam(name = "source", defaultValue = "0") String source,
            @RequestParam(name = "imageurl", defaultValue = "0") String imageurl,
            @RequestParam(name = "title", defaultValue = "0") String title,
            @RequestParam(name = "description", defaultValue = "0") String descripton,
            Model theModel){

        News news = new News(0, source.toString(), imageurl.toString(), title.toString(), descripton.toString(), "0","0","0");
        newsDao.save(news);

        return "index";
    }



}
