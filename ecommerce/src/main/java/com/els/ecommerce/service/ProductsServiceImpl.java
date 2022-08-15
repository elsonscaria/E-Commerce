package com.els.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.els.ecommerce.dto.ProductsDto;
import com.els.ecommerce.entity.Products;
import com.els.ecommerce.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService{

	@Autowired
	ProductsRepository productsRepository;
	
	@Override
	public Products addProducts(ProductsDto productsDto) {
		
		Products products = new Products();
		BeanUtils.copyProperties(productsDto, products);
		return productsRepository.save(products);
	}

	@Override
	public Products getProducts(Long productId) {
		Optional<Products> products = productsRepository.findById(productId);
		if (products.isPresent()) {
			return products.get();
		}
		return null;
	}

	@Override
	public void deleteproducts(Long productId) {
		productsRepository.deleteById(productId);
		
	}

	@Override
	public Products updateProducts(Long productId, ProductsDto productsDto) {
		Products products = getProducts(productId);
		BeanUtils.copyProperties(productsDto, products);
		return productsRepository.save(products);
	}
	
	
	

}
