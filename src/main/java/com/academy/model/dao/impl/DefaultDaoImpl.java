package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.DefaultDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class DefaultDaoImpl<T> implements DefaultDao<T> {
  @Override
  public void createOrUpdate(T entity) {
    Session session = DataSource.getInstance().getSession();
    Transaction transaction = session.beginTransaction();
    session.saveOrUpdate(entity);
    transaction.commit();
  }

  @Override
  public void delete(T entity) {
    Session session = DataSource.getInstance().getSession();
    Transaction transaction = session.beginTransaction();
    session.delete(entity);
    transaction.commit();
  }
}
