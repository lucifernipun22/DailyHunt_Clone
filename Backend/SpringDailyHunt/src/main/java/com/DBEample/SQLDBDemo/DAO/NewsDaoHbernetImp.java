package com.DBEample.SQLDBDemo.DAO;

import com.DBEample.SQLDBDemo.Entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NewsDaoHbernetImp implements NewsDao {
    @Override
    public <S extends News> S save(S s) {
        return null;
    }

    @Override
    public <S extends News> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<News> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<News> findAll() {
        return null;
    }

    @Override
    public Iterable<News> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(News news) {

    }

    @Override
    public void deleteAll(Iterable<? extends News> iterable) {

    }

    @Override
    public void deleteAll() {

    }


    @Override
    public List<News> GetAllNews() {
        return null;
    }
}
