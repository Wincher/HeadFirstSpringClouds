package io.wincher.cloud.Controller;

import io.wincher.cloud.Entity.Product;
import io.wincher.cloud.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> list() {
		return this.productService.findAll();
	}
	
	@RequestMapping(value = "/{itemCode}", method = RequestMethod.GET)
	public Product detail(@PathVariable String itemCode) {
		return this.productService.loadByItemCode(itemCode);
	}
}
