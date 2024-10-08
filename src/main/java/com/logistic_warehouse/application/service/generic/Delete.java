package com.logistic_warehouse.application.service.generic;

public interface Delete <ID,T>{
    T delete(ID id);
}
