package com.academy.model.dao;

import com.academy.model.entity.Author;

public interface AuthorDao extends DefaultDao<Author>{
  Author getByName(String name);
}
