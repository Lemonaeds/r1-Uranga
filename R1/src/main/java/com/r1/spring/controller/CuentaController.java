package com.r1.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.r1.spring.exception.ResourceNotFoundException;
import com.r1.spring.models.CuentaModel;
import com.r1.spring.repositories.CuentaRepository;
import com.r1.spring.services.CuentaService;



@RestController
@RequestMapping("/api/v1/accounts")
public class CuentaController {
    @Autowired
    CuentaService cuentaService;
    

    static List<CuentaModel> cuenta = new ArrayList<CuentaModel>();

    @GetMapping()
    public ArrayList<CuentaModel> obtenerUsuarios(){
        return cuentaService.obtenerUsuarios();
    }

    @PostMapping()
    public CuentaModel guardarCuenta(@RequestBody CuentaModel accounts){
        return this.cuentaService.guardarCuenta(accounts);
    }

    @GetMapping(path = "/{id}")
    public Optional<CuentaModel> obtenerCuentaPorId(@PathVariable("id") Long id){
        return this.cuentaService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public CuentaModel actualizar (@PathVariable("id") Long id, @RequestBody CuentaModel cuenta){
        CuentaModel account = cuentaService.obtenerPorId(id).get();
              
        
        account.setSaldo(cuenta.getSaldo());
        cuentaService.guardarCuenta(account);

        return this.cuentaService.guardarCuenta(account);
    }

    @DeleteMapping(path = "/{id}")
    public void borrarCuentaPorId(@PathVariable("id") Long id){
       this.cuentaService.eliminarCuenta(id);
    }



}
