package com.santt4naweb.workshop01.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private Double price;
   private String imgUrl;

   // 1 pra muitos set para não repetir a categoria
   @Transient // Para não interpetra isso
   private Set<Category> categories = new HashSet<>(); // Hash pois tem que usar uma classe e o Set é uma interterface

   // Constructors
   public Product() {
   }

   public Product(Long id, String name, String description, Double price, String imgUrl) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.price = price;
      this.imgUrl = imgUrl;
   }
   // Colections não vai no Constructor pois esta sendo estanciado por fora

   // Getters e Setters

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

   public String getImgUrl() {
      return imgUrl;
   }

   public void setImgUrl(String imgUrl) {
      this.imgUrl = imgUrl;
   }

   public Set<Category> getCategories() {
      return categories;
   }
   // Colections não tem o Setters

   // HashCode e Equals
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Product other = (Product) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      return true;
   }

   // Serialização do Product
   private static final long serialVersionUID = 1l;
}
