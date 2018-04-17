package com.jones.panorama.repository;

import com.jones.panorama.mapper.QuestionMapper;
import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Question;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jones on 18-1-17.
 */
@Repository
public class QuestionRepository {
    @Autowired
    private QuestionMapper questionMapper;

    public Page<Question> findByPage(Query<Question> query){
        Integer count = findCount(query);
        return new Page<>(query, count, findList(query));
    }

    public List<Question> findList(Query<Question> query){
        return questionMapper.findList(query);
    }

    public Integer findCount(Query<Question> query){
        return questionMapper.findCount(query);
    }

    public void save(Question question){
        if(question.getQuestionId() == null){
            questionMapper.insert(question);
        } else {
            questionMapper.update(question);
        }
    }
}
