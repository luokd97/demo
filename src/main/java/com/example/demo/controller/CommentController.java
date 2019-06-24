package com.example.demo.controller;

import com.example.demo.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("comment")
    @ResponseBody
    public String comment(Long articleId, String content) {
        try {
            log.info("##################"+articleId+"###################"+content);
            commentService.postComment(articleId, content);
        } catch (Exception e) {
            log.error("{}", e);
            return "error: " + e.getMessage();
        }
        return "success";
    }

    @RequestMapping("createComment")
    public String createComment(){
        return "create_comment";
    }
}
