package com.jones.panorama.mapper;

import com.jones.panorama.model.Query;
import com.jones.panorama.model.Question;
import com.jones.panorama.util.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper {
    List<Question> findList(Query query);
    List<Question> findAll();
    Integer findCount(Query query);
    void insert(Question question);
    void update(Question question);
}