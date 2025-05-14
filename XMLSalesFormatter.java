
import java.util.Iterator;

public class XMLSalesFormatter implements SalesFormatter {
    private static XMLSalesFormatter singletonInstance;

    private XMLSalesFormatter() {}

    public static XMLSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new XMLSalesFormatter();
        }
        return singletonInstance;
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder result = new StringBuilder("<Sales>\n");
        Iterator<Order> orderIterator = sales.iterator();
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            result.append("  <Order total=\"").append(order.getTotalCost()).append("\">\n");
            Iterator<OrderItem> itemIterator = order.iterator();
            while (itemIterator.hasNext()) {
                OrderItem item = itemIterator.next();
                result.append("    <OrderItem quantity=\"").append(item.getQuantity()).append("\" price=\"")
                      .append(item.getProduct().getPrice()).append("\">").append(item.getProduct().getCode())
                      .append("</OrderItem>\n");
            }
            result.append("  </Order>\n");
        }
        result.append("</Sales>");
        return result.toString();
    }
}    