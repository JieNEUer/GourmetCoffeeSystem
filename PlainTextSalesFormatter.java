
import java.util.Iterator;

public class PlainTextSalesFormatter implements SalesFormatter {
    private static PlainTextSalesFormatter singletonInstance;

    private PlainTextSalesFormatter() {}

    public static PlainTextSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new PlainTextSalesFormatter();
        }
        return singletonInstance;
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder result = new StringBuilder();
        int orderNumber = 1;
        Iterator<Order> orderIterator = sales.iterator();
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            result.append("------------------------\n");
            result.append("Order ").append(orderNumber++).append("\n");
            Iterator<OrderItem> itemIterator = order.iterator();
            while (itemIterator.hasNext()) {
                OrderItem item = itemIterator.next();
                result.append(item.getQuantity()).append(" ")
                      .append(item.getProduct().getCode()).append(" ")
                      .append(item.getProduct().getPrice()).append("\n");
            }
            result.append("Total = ").append(order.getTotalCost()).append("\n");
        }
        return result.toString();
    }
}    