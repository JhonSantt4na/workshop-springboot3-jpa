package com.santt4naweb.workshop01.entities;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santt4naweb.workshop01.entities.enums.OrderStatus;

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

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
   // JsonFormat = Formatando a String da Hora
   private Instant moment;

   // private OrderStatus orderStatus;
   // Vamos fazer o seguinte ou inves de usar o tipo OrderStatus
   // iremos ultilizar o Integer dentro da nossa classe para salvarmos um num int
   // no banco
   // mas fora da nossa classe ele continuara sendo OrderStatus :
   private Integer orderStatus;

   @ManyToOne // Anotação para o Muitos para 1
   @JoinColumn(name = "client_id") // Anotação com o nome da chave estrangeira
   private User client;

   // Constructors
   public Order() {
   }

   // Adicionado o OrderStatus ao Contructors
   public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
      this.id = id;
      this.moment = moment;
      // this.orderStatus = orderStatus;  >> para o caso padrão
      setOrderStatus(orderStatus); 
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

   // Getters e Setters adicionados do OrderStatus

   public OrderStatus getOrderStatus() {
      // return orderStatus; >> para o caso padrão
      return OrderStatus.valueOf(orderStatus); // convertendo o numero inteiro da classe para OrderStatus
   }

   public void setOrderStatus(OrderStatus orderStatus) {
      // this.orderStatus = orderStatus; >> para o caso padrão
      if (orderStatus != null) { // Para não aceitar null
         this.orderStatus = orderStatus.getCode();
      }
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