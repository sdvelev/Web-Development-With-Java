package bg.uni.fmi.lab02.streams.service;

import bg.uni.fmi.lab02.streams.Order;
import bg.uni.fmi.lab02.streams.OrderLine;
import bg.uni.fmi.lab02.streams.User;
import bg.uni.fmi.lab02.streams.entity.Item;
import bg.uni.fmi.lab02.streams.vo.OrderLineStatus;
import bg.uni.fmi.lab02.streams.vo.OrderStatus;
import bg.uni.fmi.lab02.streams.vo.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Order getOrderById(List<Order> orders, long orderId) {
        return orders.stream()
            .filter(order -> order.getId() == orderId)
            .findFirst()
            .orElse(null);
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
            .filter(order -> order.getOrderLineList().contains(new OrderLine(new Item(description, new BigDecimal(0)),
                OrderLineStatus.IN_STOCK, false, 1)))
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

    public static void main(String[] args) {

        SearchExercise searchExercise = new SearchExercise();

        User user = new User();

        List<Order> orderList = new ArrayList<>();

        OrderLine orderLineFirst = new OrderLine(new Item("desc1", new BigDecimal(12)), OrderLineStatus.IN_STOCK,
            false, 17);

        Order orderFirst = new Order(12, List.of(orderLineFirst), LocalDate.now(), new BigDecimal(8), PaymentMethod.CASH_ON_DELIVERY,
            LocalDate.now().plusDays(3), user, "no description");

        OrderLine orderLineSecond = new OrderLine(new Item("desc2", new BigDecimal(3)), OrderLineStatus.OUT_OF_STOCK,
            true, 1);

        Order orderSecond = new Order(6, List.of(orderLineSecond), LocalDate.now(), new BigDecimal(10), PaymentMethod.CARD,
            LocalDate.now().plusDays(4), user, "some description");

        orderList.add(orderFirst);
        orderList.add(orderSecond);

        user.addOrder(orderFirst);
        user.addOrder(orderSecond);

        orderSecond.setOrderStatus(OrderStatus.ACTIVE);

        System.out.println(searchExercise.getActiveOrders(user));
        System.out.println(searchExercise.getActiveOrdersByIteration(user));
        System.out.println(searchExercise.getOrderById(orderList, 6));
        System.out.println(searchExercise.getOrderByIdIteration(orderList, 12));
        System.out.println(searchExercise.getOrdersThatHaveItemDescription(user, "desc2"));
        System.out.println(searchExercise.hasActiveOrders(user));
        System.out.println(searchExercise.canBeReturned(orderFirst));
        System.out.println(searchExercise.canBeReturned(orderSecond));
        System.out.println(searchExercise.getMaxPriceOrder(user));
    }
}
