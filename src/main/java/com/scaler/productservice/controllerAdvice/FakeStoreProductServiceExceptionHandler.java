package com.scaler.productservice.controllerAdvice;

import com.scaler.productservice.dto.ExceptionDTO;
import com.scaler.productservice.dto.ProductNotFoundExceptionDTO;
import com.scaler.productservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FakeStoreProductServiceExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> fakeStoreProductExceptionHandler(RuntimeException ex){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(ex.getMessage());
        exceptionDTO.setResolution("pls contact application team");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionDTO);

    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDTO> fakeStoreProductNotFoundExceptionHandler(ProductNotFoundException ex){
        ProductNotFoundExceptionDTO exceptionDTO = new ProductNotFoundExceptionDTO();
        exceptionDTO.setId(ex.getId());
        exceptionDTO.setMessage(ex.getMessage());
        exceptionDTO.setResolution("Pls try again with valid id");
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

}
