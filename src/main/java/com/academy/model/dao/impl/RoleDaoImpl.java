package com.academy.model.dao.impl;

import com.academy.DataSource;
import com.academy.model.dao.DefaultDao;
import com.academy.model.dao.RoleDao;
import com.academy.model.entity.Role;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class RoleDaoImpl extends DefaultDaoImpl<Role> implements RoleDao {

  @Override
  public List<Role> getAll() {
    Session session = DataSource.getInstance().getSession();

    Query query = session.createQuery("from Role");

    return query.getResultList();
  }

  @Override
  public Role getById(int id) {
    return null;
  }
}
