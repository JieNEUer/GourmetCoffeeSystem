
public class OrderItem {
   
    private int quantity;
    private Product product;

    public OrderItem(Product product, int quantity) {
    
        this.product = product;
        this.quantity = quantity;
    }

    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }


    public Product getProduct() {
        return product;
    }

    public double getValue() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + " " + product.getCode() + " " + product.getPrice();
    }
}