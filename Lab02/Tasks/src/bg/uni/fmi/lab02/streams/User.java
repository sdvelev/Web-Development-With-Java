package bg.uni.fmi.lab02.streams;

import java.util.List;

public class User {

    private List<Order> orderList;

    public User(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
