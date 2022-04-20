package Kodlamaio.northwind.business.abstracts;

import java.util.List;


import Kodlamaio.northwind.core.utilities.results.DataResult;
import Kodlamaio.northwind.core.utilities.results.Result;
import Kodlamaio.northwind.entities.concretes.Product;
import Kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
 DataResult<List<Product>> getAll();
 DataResult<List<Product>> getAll(int pageno , int pageSize);
 DataResult<List<Product>> getAllSortad();

 Result add(Product product);
 
 DataResult<Product> getByProductName(String productName);
	
 DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
	
 DataResult<List<Product>>getByProductNameOrCategoryId(String productName, int categoryId);

	
 DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	
 DataResult<List<Product>> getByProductNameContains(String productName);//harfine göre sıralar
	
 DataResult<List<Product>> getByProductNameStartsWith(String productName);//(bu isimle başlayanları getirir)
	
 DataResult<List<Product>> getByNameAndCategory(String productName ,int categoryId);
 
 DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
