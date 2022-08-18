package com.esl.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esl.ecommerce.repository.ProductsRepository;

import lombok.Getter;
import lombok.Setter;

import com.esl.ecommerce.dto.ProductsDto;
import com.esl.ecommerce.entity.Products;

@Service
@Setter
@Getter
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	ProductsRepository productsRepository;
	
	@Override
	public Products addProducts(ProductsDto productsDto) {
		Products products = new Products();
		BeanUtils.copyProperties(productsDto, products);
		return productsRepository.save(products);
	}


	public Products getProducts(Long productId) {
		Optional<Products> products = productsRepository.findById(productId);
		if (products.isPresent()) {
			return products.get();
		}
		return null;
		
	}
	
	
	@Override
	public Products updateProducts(Long productId, ProductsDto productsDto) {
		
		Products product = getProducts(productId);
		BeanUtils.copyProperties(productsDto, product);
		return productsRepository.save(product);
	}



	@Override
	public void deleteproducts(Long productId) {
		productsRepository.deleteById(productId);		
	}



	@Override
	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

}
