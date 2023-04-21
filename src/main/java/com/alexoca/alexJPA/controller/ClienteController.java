package com.alexoca.alexJPA.controller;

import com.alexoca.alexJPA.exception.ModelNotFoundException;
import com.alexoca.alexJPA.exception.ModelNotFoundException;
import com.alexoca.alexJPA.model.Cliente;
import com.alexoca.alexJPA.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);

    }
@PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){

        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.OK);
    }
    @PutMapping
public ResponseEntity<Object> update(@RequestBody Cliente cliente){
        clienteService.update(cliente);
        return new ResponseEntity<>( HttpStatus.OK);
}
@GetMapping("/{id}")
public ResponseEntity<Cliente> findbyId(@PathVariable("id") Integer idCliente) throws Exception {
    Cliente cliente = clienteService.findById(idCliente);
    if(cliente == null){

        throw new ModelNotFoundException("cliente no encontrado");
    }

        return new ResponseEntity<>(cliente,HttpStatus.OK);
}
@DeleteMapping("/{id}")
public ResponseEntity<Object> delete(@PathVariable("id") Integer idCliente) throws Exception {
       Cliente cliente = clienteService.findById(idCliente);
        if(cliente == null){
            throw new ModelNotFoundException("el cliente no existe");
        }
        clienteService.delete(idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
}
}
