package com.jones.panorama.service;

import com.jones.panorama.model.Comment;
import com.jones.panorama.model.Query;
import com.jones.panorama.model.Question;
import com.jones.panorama.model.Thumbup;
import com.jones.panorama.repository.CommentRepository;
import com.jones.panorama.repository.HotspotRepository;
import com.jones.panorama.repository.QuestionRepository;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jones on 18-1-16.
 */
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Page<Question> findByPage(Query<Question> query){
        return questionRepository.findByPage(query);
    }

    public void saveQuestion(Question question){
        questionRepository.save(question);
    }

    public List<Question> findList(Query<Question> query){
        return questionRepository.findList(query);
    }
}
