package bg.uni.fmi.lab02.streams.service;

import bg.uni.fmi.lab02.streams.Order;
import bg.uni.fmi.lab02.streams.OrderLine;
import bg.uni.fmi.lab02.streams.User;
import bg.uni.fmi.lab02.streams.vo.OrderStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchExercise {

    /**
     * extract all active orders
     * @param user
     * @return List<Order>
     */
    public List<Order> getActiveOrders(User user) {
        return user.getOrderList().stream()
            .filter(Order::isActive)
            .collect(Collectors.toList());
    }

    public List<Order> getActiveOrdersByIteration(User user) {

        List<Order> activeOrdersList = new ArrayList<>();

        for (Order currentOrder : user.getOrderList()) {

            if (currentOrder.getOrderStatus() == OrderStatus.ACTIVE) {
                activeOrdersList.add(currentOrder);
            }
        }

        return activeOrdersList;
    }

    /**
     * Return order by a specific id
     * @param orders
     * @param orderId
     * @return Order
     */
    public Stream<Order> getOrderById(List<Order> orders, long orderId) {
        return orders.stream()
            .filter(order -> order.getId() == orderId);
    }

    public Order getOrderByIdIteration(List<Order> orders, long orderId) {

        for (Order currentOrder : orders) {

            if (currentOrder.getId() == orderId) {

                return currentOrder;
            }
        }

        return null;
    }

    /**
     * Return orders that have specific description for item
     * @param user
     * @param description
     * @return List<Order>
     */
    public List<Order> getOrdersThatHaveItemDescription(User user, String description) {
        return user.getOrderList().stream()
            .filter(order -> order.getDescription().equals(description))
            .collect(Collectors.toList());
    }

    /**
     * @return true if customer has at least one order with status ACTIVE
     */
    public boolean hasActiveOrders(User user) {

        return user.getOrderList().stream()
            .anyMatch(Order::isActive);
    }

    /**
     * Return true if inside the Order we don't have OrderLine with special offer
     */
    public boolean canBeReturned(Order order) {
        return order.getOrderLineList()
            .stream()
            .noneMatch(OrderLine::isSpecialOffer);
    }

    /**
     * Return the order with maximum total price
     * @param user
     * @return
     */
    public Optional<Order> getMaxPriceOrder(User user) {
        return user.getOrderList()
            .stream()
            .max((o1, o2) -> o2.getTotalPrice().compareTo(o1.getTotalPrice()));
    }
}
