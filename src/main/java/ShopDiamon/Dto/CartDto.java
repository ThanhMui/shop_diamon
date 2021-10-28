package ShopDiamon.Dto;

public class CartDto {
	private int quanty;
	private double totalPrice;
	//thong tin san pham
	private ProductDto productDto;
	public CartDto() {
		super();
	}
	
	public CartDto(int quanty, double totalPrice, ProductDto productDto) {
		super();
		this.quanty = quanty;
		this.totalPrice = totalPrice;
		this.productDto = productDto;
	}

	public int getQuanty() {
		return quanty;
	}
	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ProductDto getProductDto() {
		return productDto;
	}
	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}
	
	
}
