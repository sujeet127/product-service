package com.scaler.productservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BaseModel {
    Long id;
    Date createdAt;
    Date updatedAt;
}
