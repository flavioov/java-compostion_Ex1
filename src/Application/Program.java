package Application;

import Entities.Order;
import Entities.OrderStatus;

import java.util.Date;

public class Program {

    public static void main(String[] args) {
        Order order = new Order(1080, new Date(), OrderStatus.PENDDING_PAYMENT);

        System.out.println(order);
    }
}
