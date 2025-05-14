
import java.util.Iterator;

public class HTMLSalesFormatter implements SalesFormatter {
    private static HTMLSalesFormatter singletonInstance;

    private HTMLSalesFormatter() {}

    public static HTMLSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new HTMLSalesFormatter();
        }
        return singletonInstance;
    }

    @Override
    public String formatSales(Sales sales) {
        StringBuilder result = new StringBuilder("<html>\n  <body>\n    <center><h2>Orders</h2></center>\n");
        Iterator<Order> orderIterator = sales.iterator();
        while (orderIterator.hasNext()) {
            Order order = orderIterator.next();
            result.append("    <hr>\n    <h4>Total = ").append(order.getTotalCost()).append("</h4>\n      <p>\n");
            Iterator<OrderItem> itemIterator = order.iterator();
            while (itemIterator.hasNext()) {
                OrderItem item = itemIterator.next();
                result.append("        <b>code:</b> ").append(item.getProduct().getCode()).append("<br>\n")
                      .append("        <b>quantity:</b> ").append(item.getQuantity()).append("<br>\n")
                      .append("        <b>price:</b> ").append(item.getProduct().getPrice()).append("\n      </p>\n");
            }
        }
        result.append("  </body>\n</html>");
        return result.toString();
    }
}    