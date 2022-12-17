package com.r1.spring.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.r1.spring.models.CuentaModel;

@Repository
public interface CuentaRepository extends CrudRepository<CuentaModel, Long>{
    public abstract ArrayList<CuentaModel> findByPriority(Integer priority);
}
