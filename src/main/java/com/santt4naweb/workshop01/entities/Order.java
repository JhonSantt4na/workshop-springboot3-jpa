package com.santt4naweb.workshop01.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order") // para não da conflito com o order palavra chave do sql
public class Order implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private Instant moment;

   @ManyToOne // Anotação para o Muitos para 1
   @JoinColumn(name = "client_id") // Anotação com o nome da chave estrangeira
   private User client;

   // Constructors
   public Order() {
   }

   public Order(Long id, Instant moment, User client) {
      this.id = id;
      this.moment = moment;
      this.client = client;
   }

   // Getters e Setters
   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Instant getMoment() {
      return moment;
   }

   public void setMoment(Instant moment) {
      this.moment = moment;
   }

   public User getClient() {
      return client;
   }

   public void setClient(User client) {
      this.client = client;
   }

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
      Order other = (Order) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      return true;
   }
}
// Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
// Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
// Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);