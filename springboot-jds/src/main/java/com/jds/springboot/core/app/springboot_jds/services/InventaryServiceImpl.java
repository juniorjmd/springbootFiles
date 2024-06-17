package com.jds.springboot.core.app.springboot_jds.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jds.springboot.core.app.springboot_jds.entities.Product;

@Service
public class InventaryServiceImpl implements InventaryService {

    @Override
    public List<Product> findAll() {
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Product> findById(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Product save(Product product) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public Optional<Product> delete(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
