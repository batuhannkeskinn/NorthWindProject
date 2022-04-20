package Kodlamaio.northwind.core.utilities.results;

public class Result {
 private String massage;
private boolean success;
 
 
 public Result(boolean success) {
	 this.success = success;
 }
 
 
public Result(String massage) {
	 this.massage= massage;
	
 }
public Result(boolean success,String massage) {
	this(success);
	this.massage = massage;
	  
}
public boolean isSuccess() {
	return this.success;
}
public String getMessage() {
	return this.massage;
}
}
