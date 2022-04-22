package com.academy.model.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SelectBeforeUpdate;

@Data
@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column
  private String title;
  @Column
  private Integer year;
  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "author_book",
      joinColumns = {@JoinColumn(name = "id_book")},
      inverseJoinColumns = {@JoinColumn(name = "id_author")}
  )
  private List<Author> authors;
}
