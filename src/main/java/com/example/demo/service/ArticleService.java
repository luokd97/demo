package com.example.demo.service;

import com.example.demo.domain.Article;
import com.example.demo.domain.ArticleRepository;
import com.example.demo.domain.Comment;
import com.example.demo.domain.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//@Slf4j
@Service

public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Transactional
    public void postArticle(String title, String content) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        articleRepository.save(article);
    }
}
