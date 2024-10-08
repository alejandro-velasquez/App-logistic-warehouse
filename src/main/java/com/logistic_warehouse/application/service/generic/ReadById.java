package com.logistic_warehouse.application.service.generic;

public interface ReadById <ID,Entity>{
    Entity readById(ID id);
}
