package com.academy.model.dao;

import com.academy.model.entity.Book;

public interface BookDao extends DefaultDao<Book>{
  Book getByTitle(String title);
  Book loadById(int id);
}
