
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Order {
    public List<OrderItem>items=new ArrayList<>();

    public void addItem(OrderItem orderItem){
        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem){
        items.remove(orderItem);
    }

    public OrderItem getItem(Product product){
        for(OrderItem item:items){
            if(item.getProduct().equals(product))return item;
        }
        return null;
    }

    public Iterator<OrderItem> iterator(){
        return items.iterator();
    }

    public int getNumberOfItems(){
        return items.size();
    }

    public double getTotalCost(){
        double total=0;
        for(OrderItem item:items){
            total+=item.getValue();
        }
        return total;
    }

}
