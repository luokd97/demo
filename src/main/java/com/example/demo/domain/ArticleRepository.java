package com.example.demo.domain;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.Optional;

@Transactional
public interface ArticleRepository extends CrudRepository<Article, Long> {
    //    @Query(value = "select * from article where id = ?1 for update",nativeQuery=true)
    @Query(value = "select * from article a where a.id = :id for update", nativeQuery = true)
    Optional<Article> findArticleForUpdate(Long id);

//    // @Query("select a from Article a where a.id = :id")
//    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
//    @Query("select a from article a where a.id= ?1")
//    Optional<Article> findByIdWithPessimisticLock(Long id);


    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select a from Article a where a.id = :id")
    Optional<Article> findArticleWithPessimisticLock(Long id);
}
