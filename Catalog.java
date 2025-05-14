
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Catalog implements Iterable<Product>{
    public List<Product> products=new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct(String code) {
        for(Product p:products){
            if(p.getCode().equals(code))return p;
        }
        return null;
}
    @Override
    public Iterator<Product>iterator(){
        return products.iterator();
    }

    public int getNumberOfProducts(){
        return products.size();
    }


}