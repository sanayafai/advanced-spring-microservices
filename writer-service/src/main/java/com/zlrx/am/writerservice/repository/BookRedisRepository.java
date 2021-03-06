package com.zlrx.am.writerservice.repository;

import com.zlrx.am.writerservice.model.Book;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BookRedisRepository {

    void save(Book book);

    void delete(Long authorId);

    Book findFirst(Long authorId);

}
