package com.santt4naweb.workshop01.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;

   // @Transient // Para não interpetra isso
   @ManyToMany(mappedBy = "categories") // Mapeando com a colection do Products
   @JsonIgnore // Para não ficar no loop de chamada
   private Set<Product> products = new HashSet<>();

   // Associações Dpois da classe Product ser feita
   // Constructors
   public Category() {
   }

   public Category(Long id, String name) {
      this.id = id;
      this.name = name;
   }

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

   public Set<Product> getProducts() {
      return products;
   }
   // Lembrando que Collections so tem os Getters pois não mudamos a Coleção apenas
   // adicionamos/removemos itens
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
      Category other = (Category) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      return true;
   }

   private static final long serialVersionUID = 1l;
}
