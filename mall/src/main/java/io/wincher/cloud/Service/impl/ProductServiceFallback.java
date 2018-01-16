package io.wincher.cloud.Service.impl;

import io.wincher.cloud.Entity.Product;
import io.wincher.cloud.Service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class ProductServiceFallback implements ProductService {
	@Override
	public List<Product> findAll() {
		return Collections.emptyList();
	}
	
	@Override
	public Product loadByItemCode(String itemCode) {
		return new Product("error", "unknown", "Wincher-Fallback", 0);
	}
}
