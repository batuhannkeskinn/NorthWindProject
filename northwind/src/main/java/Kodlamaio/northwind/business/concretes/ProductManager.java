package Kodlamaio.northwind.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.northwind.business.abstracts.ProductService;
import Kodlamaio.northwind.core.utilities.results.DataResult;
import Kodlamaio.northwind.core.utilities.results.Result;
import Kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import Kodlamaio.northwind.core.utilities.results.SuccessResult;
import Kodlamaio.northwind.dataAcces.abstracts.ProductDao;
import Kodlamaio.northwind.entities.concretes.Product;
import Kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {
	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	@Override
	public DataResult<List<Product>> getAll() {
			return new SuccessDataResult<List<Product>>
			(this.productDao.findAll(),"Data Listelendi");
				
				
	}
	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult<Product>("Ürün eklendi");
	}
	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductName(productName),"Data Listelendi");	
		
	}
	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>
		(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByCategoryIn(categories),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameContains(productName),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getAll(int pageno, int pageSize) {
		Pageable pageable = PageRequest.of(pageno, pageSize);
		return new SuccessDataResult<List<Product>> (this.productDao.findAll(pageable).getContent());
	}
	@Override
	public DataResult<List<Product>> getAllSortad() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>> 
		(this.productDao.findAll(sort),"Başarılı");
	}
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>
		(this.productDao.getProductWithCategoryDetails(),"Data Listelendi");
	}

}