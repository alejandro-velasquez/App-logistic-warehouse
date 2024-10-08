package com.logistic_warehouse.application.service.generic;

public interface Create <EntityRequest,Entity>{
    Entity create(EntityRequest entityRequest);
}
