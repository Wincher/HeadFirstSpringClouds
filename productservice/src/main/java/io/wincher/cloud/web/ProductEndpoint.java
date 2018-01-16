package io.wincher.cloud.web;

import io.wincher.cloud.Entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {
	
	protected Logger logger = LoggerFactory.getLogger(ProductEndpoint.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> list() {
		return this.buildProducts();
	}
	
	@RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
	public Product detail(@PathVariable String itemCode) {
		List<Product> products = this.buildProducts();
		for (Product product : products) {
			if (product.getItemCode().equalsIgnoreCase(itemCode)) {
				return product;
			}
		}
		return null;
	}
	
	protected List<Product> buildProducts() {
		List<Product> products = new ArrayList<>();
		for (int i = 1; i < 7; i++) {
			products.add(new Product("item-" + i, "测试商品-" + i, "Wincher", i*100));
		}
		return products;
	}
}
