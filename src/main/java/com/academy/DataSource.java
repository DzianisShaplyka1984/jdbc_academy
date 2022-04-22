package com.academy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

public class DataSource {
  private static DataSource instance = new DataSource();
  private static EntityManagerFactory emFactory;

  private DataSource() {
    emFactory = Persistence.createEntityManagerFactory("by.it_academy");
  }

  public static DataSource getInstance() {
    return instance;
  }

  public EntityManager getEntityManager() {
    return emFactory.createEntityManager();
  }

  public Session getSession() {
    return getEntityManager().unwrap(Session.class);
  }
}
