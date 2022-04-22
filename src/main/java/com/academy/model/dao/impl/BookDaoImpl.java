package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.BookDao;
import com.academy.model.entity.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

public class BookDaoImpl extends DefaultDaoImpl<Book> implements BookDao {

  @Override
  public List<Book> getAll() {
//    Session session = DataSource.getInstance().getSession();
//
//    Query query = session.createQuery("from Book b");

    EntityManager entityManager = DataSource.getInstance().getEntityManager();
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
    Root<Book> bookRoot = criteriaQuery.from(Book.class);
    Predicate predicate = criteriaBuilder.or(
        criteriaBuilder.isNotNull(bookRoot.get("year")),
        criteriaBuilder.isNotEmpty(bookRoot.get("authors"))
    );

    criteriaQuery.select(bookRoot).orderBy(criteriaBuilder.desc(bookRoot.get("id"))).where(predicate);

    EntityManager em = DataSource.getInstance().getEntityManager();

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Integer> criteria = cb.createQuery(Integer.class);
    criteria.select(cb.max(criteria.from(Book.class).get("year")));
    int count = em.createQuery(criteria).getSingleResult();


    return entityManager.createQuery(criteriaQuery).getResultList();
  }

  @Override
  public Book getById(int id) {
    Session session = DataSource.getInstance().getSession();

    return session.get(Book.class, id);
  }

  public Book loadById(int id) {
    Session session = DataSource.getInstance().getSession();

    return session.load(Book.class, id);
  }

  @Override
  public Book getByTitle(String title) {
    Session session = DataSource.getInstance().getSession();

    Query query = session.createQuery("from Book where title = ?");
    query.setParameter(0, title);

    List<Book> books = query.getResultList();

    if (!books.isEmpty()) {
      return books.get(0);
    }

    return null;
  }
}
