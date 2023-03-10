package bg.uni.fmi.lab02.streams;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Order> orderList;

    public User() {
        this.orderList = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    public User(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
