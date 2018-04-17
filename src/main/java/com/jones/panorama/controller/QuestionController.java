package com.jones.panorama.controller;

import com.jones.panorama.model.*;
import com.jones.panorama.service.CommentService;
import com.jones.panorama.service.QuestionService;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by jones on 18-1-16.
 */
@Controller
@RequestMapping( "/question" )
public class QuestionController extends BaseController{
    @Autowired
    private QuestionService questionService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page list(@RequestParam(value = "size", required = false, defaultValue = "10") int size,
                       @RequestParam(value = "page", required = false, defaultValue = "0") int page){
        return questionService.findByPage(getQuery(page, size, new Question()));
    }

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Question> findAll(){
        return questionService.findList(new Query<>());
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    GeneralResponse addComment(Question question) {
        questionService.saveQuestion(question);
        return new GeneralResponse(true, "success");
    }


}
