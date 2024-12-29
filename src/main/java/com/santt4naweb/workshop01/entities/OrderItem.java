package com.santt4naweb.workshop01.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santt4naweb.workshop01.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
   private static final long serialVersionUID = 1L;

   @EmbeddedId // Informando que é um id de uma classe aux de chave primaria composta
   // Sempre que for uma chave desta maneira tem que instanciar ela
   private OrderItemPK id = new OrderItemPK();
   private Integer quatity;
   private Double price;

   public OrderItem() {

   }

   // Obs: O OrderItemPK id não entra nos Constructors/Getters/Setters
   // no entanto podemos comparar no HashCode Equal pois ele indentifica

   // Vamos passar no construtor o Order/Product Separados
   // Para Associar eles com o Id usamos:
   // id.setOrder(passando o order)
   // id.setProduct(passando o product)

   public OrderItem(Order order, Product product, Integer quatity, Double price) {
      id.setOrder(order);
      id.setProduct(product);
      this.quatity = quatity;
      this.price = price;
   }

   // Mas temos que fazer por fora os getters e setters do Order e Product.
   // Precisamos colocar o JsonIgnore Aqui pq o get order que fica chamando
   // infinito
   @JsonIgnore
   public Order getOrder() {
      return id.getOrder();
   }

   public void setOrder(Order order) {
      id.setOrder(order); // Entrando no id e adicionando no order de la
   }

   public Product getProduct() {
      return id.getProduct();
   }

   public void setProduct(Product product) {
      id.setProduct(product); // Entrando no id e adicionando no product de la
   }

   public Integer getQuatity() {
      return quatity;
   }

   public void setQuatity(Integer quatity) {
      this.quatity = quatity;
   }

   public Double getPrice() {
      return price;
   }

   public void setPrice(Double price) {
      this.price = price;
   }

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
      OrderItem other = (OrderItem) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      return true;
   }

}
