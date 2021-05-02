
public class Factory {
	public Factory(ProductType productType,Channel channel) {
		
	}
	
	public static Order order(ProductType productType, Channel channel) {
		// TODO Auto-generated method stub
		switch(channel) {
		case ECOMMERCE:
			return new ECommerceFactory().createOrder(productType);
		case TELECALLER:
			return new TeleCallerFactory().createOrder(productType);
		}
		return null;
	}

}
