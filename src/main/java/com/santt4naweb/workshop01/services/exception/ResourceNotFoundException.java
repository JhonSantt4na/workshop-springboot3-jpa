package com.santt4naweb.workshop01.services.exception;

public class ResourceNotFoundException extends RuntimeException {
   // RuntimeException = Não Obriga a Tratar
   private static final long serialVersionUID = 1L;

   // Criando a Exception Personalizada
   // Recebe o Id e Lança uma mensagem personalizada
   public ResourceNotFoundException(Object id) {
      super("Resouce not found. ID" + id);
   }

}