package com.sbgql.SBGraphQL.repositories;

import com.sbgql.SBGraphQL.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
