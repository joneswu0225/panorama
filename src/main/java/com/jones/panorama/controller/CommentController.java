package com.jones.panorama.controller;

import com.jones.panorama.model.Comment;
import com.jones.panorama.model.GeneralResponse;
import com.jones.panorama.model.User;
import com.jones.panorama.service.CommentService;
import com.jones.panorama.service.UserService;
import com.jones.panorama.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by jones on 18-1-16.
 */
@Controller
@RequestMapping( "/comment" )
public class CommentController extends BaseController{
    @Autowired
    private CommentService commentService;


    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page list(@RequestParam(value = "hotspotCode") String hotspotCode,
                       @RequestParam(value = "size", required = false, defaultValue = "10") int size,
                       @RequestParam(value = "page", required = false, defaultValue = "0") int page){
        return commentService.findByPage(getQuery(page, size));
    }


    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    GeneralResponse addComment(Comment comment) {
        comment.setUser(getLoginUser());
        commentService.saveComment(comment);
        return new GeneralResponse(true, "success");
    }

    @ResponseBody
    @RequestMapping(value = "/thumbUp", method = RequestMethod.POST)
    GeneralResponse changeLikeFlag(@RequestParam(value = "hotspotCode") String hotspotCode,
                               @RequestParam(value = "thumbUp") boolean thumbUp) {
        Comment comment = new Comment();
        comment.setHotspotCode(hotspotCode);
        comment.setThumbUp(thumbUp);
        commentService.saveComment(comment);
        return new GeneralResponse(true, "success");
    }



}
