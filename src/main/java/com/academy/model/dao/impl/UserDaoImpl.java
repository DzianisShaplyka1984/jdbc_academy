package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.UserDao;
import com.academy.model.entity.Book;
import com.academy.model.entity.User;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class UserDaoImpl extends DefaultDaoImpl<User> implements UserDao {

  @Override
  public List<User> getAll() {
    Session session = DataSource.getInstance().getSession();

    Query query = session.createQuery("from User");

    return query.getResultList();
  }

  @Override
  public User getById(int id) {
    Session session = DataSource.getInstance().getSession();

    return session.get(User.class, id);
  }
}
