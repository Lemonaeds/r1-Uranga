package com.r1.spring.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.r1.spring.models.CuentaModel;
import com.r1.spring.repositories.CuentaRepository;

@Service
public class CuentaService {
    @Autowired
    CuentaRepository cuentaRepository;

    public ArrayList<CuentaModel> obtenerUsuarios(){
        return (ArrayList<CuentaModel>) cuentaRepository.findAll();
    }

    public CuentaModel guardarCuenta (CuentaModel cuenta){
        return cuentaRepository.save(cuenta);
    }

    public Optional<CuentaModel> obtenerPorId(Long id){
        return cuentaRepository.findById(id);        
    }

    public ArrayList<CuentaModel> obtenerPorPrioridad(Integer priority){
        return cuentaRepository.findByPriority(priority);
    }

    public Optional <CuentaModel> modSaldo(Long id) {
        return cuentaRepository.findById(id);
    }

    public boolean eliminarCuenta(Long id){
        try{
            cuentaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }

    }
}
