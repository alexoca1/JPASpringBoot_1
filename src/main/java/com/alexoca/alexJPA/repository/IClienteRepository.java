package com.alexoca.alexJPA.repository;

import com.alexoca.alexJPA.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {


}
