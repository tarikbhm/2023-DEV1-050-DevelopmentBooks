package com.bnp.kata.infra.db.repository;

import com.bnp.kata.infra.db.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    List<BookEntity> findAll();
}
