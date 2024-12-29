package com.santt4naweb.workshop01.entities.enums;

public enum OrderStatus {

   // Forma Facil de Adicionar.

   // WAITING_PAYMENT,
   // PAID,
   // SHIPPED,
   // DELIERED,
   // CANCELED;

   // ( o Java por padrão atribui um tipo numerico automaticamente comerçando com 0
   // Porem se agente adicionar posteriomente um novo valor na lista
   // ele vai quebra pq sempre muda os anterior ex: adicionou o 3 item
   // fica 0,1,2,3 porem os outros 2 que sobra serao o 3, 4 causando um erro na
   // aplicação)

   // Forma Declarativa explicitamente

   WAITING_PAYMENT(1),
   PAID(2),
   SHIPPED(3),
   DELIERED(4),
   CANCELED(5);

   // Porem com isso o java pede que implementamos :

   // Um Construtor *Private
   private int code;

   private OrderStatus(int code) {
      this.code = code;
   }

   // Expondo o code com o getter
   public int getCode() {
      return code;
   }

   // Precisamos tmb de um method Static para
   // Converter um valor numerico > Enum
   // Static pq ele vai funcionar sem instaciar

   public static OrderStatus valueOf(int code) {
      // Percorendo todos os OrderStatus
      for (OrderStatus value : OrderStatus.values()) {
         // Se for igual ao que agente passou retornamos ele
         if (value.getCode() == code) {
            return value;
         }
      }
      // Caso Contrario mandamos uma exception padrão com uma msg
      throw new IllegalArgumentException("Invalid OrderStatus Code");
   }

}
