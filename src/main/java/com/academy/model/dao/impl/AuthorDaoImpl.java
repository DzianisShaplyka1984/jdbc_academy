package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.AuthorDao;
import com.academy.model.entity.Author;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class AuthorDaoImpl extends DefaultDaoImpl<Author> implements AuthorDao {

  @Override
  public List<Author> getAll() {
    Session session = DataSource.getInstance().getSession();

    Query query = session.createQuery("from Author");

    return query.getResultList();
  }

  @Override
  public Author getById(int id) {
    Session session = DataSource.getInstance().getSession();

    return session.get(Author.class, id);
  }

  @Override
  public Author getByName(String title) {
    Session session = DataSource.getInstance().getSession();

    Query query = session.createQuery("from Author where name = :name");
    query.setParameter("name", title);

    List<Author> authors = query.getResultList();

    if (!authors.isEmpty()) {
      return authors.get(0);
    }

    return null;
  }
}
