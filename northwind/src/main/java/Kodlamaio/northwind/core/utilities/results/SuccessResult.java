package Kodlamaio.northwind.core.utilities.results;

public class SuccessResult<T> extends Result{
	public SuccessResult() {
		super(true);
	}

	public SuccessResult(String message) {
		
		super(true,message);
		
	}
}
