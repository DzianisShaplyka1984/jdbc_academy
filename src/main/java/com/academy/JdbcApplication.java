package com.academy;

import com.academy.model.dao.BookDao;
import com.academy.model.dao.RoleDao;
import com.academy.model.dao.UserDao;
import com.academy.model.dao.impl.BookDaoImpl;
import com.academy.model.dao.impl.RoleDaoImpl;
import com.academy.model.dao.impl.UserDaoImpl;
import com.academy.model.entity.Book;
import com.academy.model.entity.Role;
import com.academy.model.entity.User;
import java.sql.SQLException;
import java.util.List;

public class JdbcApplication {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    //Class.forName("com.mysql.cj.jdbc.Driver");

    BookDao bookDao = new BookDaoImpl();

    List<Book> books = bookDao.getAll();

//    Book book = new Book();
//    book.setTitle("Title33");
//    book.setYear(2000);
//
//    bookDao.createOrUpdate(book);
//    Book getBook = bookDao.getById(10);
//
//    getBook.setYear(20000);
//
//    bookDao.createOrUpdate(getBook);
//
//    List<Book> books = bookDao.getAll();
//
//    UserDao userDao = new UserDaoImpl();
//
//    List<User> users = userDao.getAll();
//
//    RoleDao roleDao = new RoleDaoImpl();
//
//    List<Role> roles = roleDao.getAll();
//
//    Role role = new Role();
//    role.setRole("MANAGER");
//
//    User user = new User();
//    user.setName("John");
//    user.setRole(role);
//
//   userDao.createOrUpdate(user);

    System.out.println("Hello Jdbc");
  }

}
