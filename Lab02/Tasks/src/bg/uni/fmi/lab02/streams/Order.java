package bg.uni.fmi.lab02.streams;

import bg.uni.fmi.lab02.streams.vo.OrderStatus;
import bg.uni.fmi.lab02.streams.vo.PaymentMethod;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Order {

    private static int ID = 1;

    private long id;
    private OrderStatus orderStatus;
    private List<OrderLine> orderLineList;
    private LocalDate creationDate;
    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;
    private LocalDate deliveryDueDate;
    private User user;
    private String description;

    public Order(long id, List<OrderLine> orderLineList, LocalDate creationDate, BigDecimal totalPrice,
                 PaymentMethod paymentMethod, LocalDate deliveryDueDate, User user, String description) {
        this.id = id;
        this.orderLineList = orderLineList;
        this.creationDate = creationDate;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.deliveryDueDate = deliveryDueDate;
        this.user = user;
        this.description = description;
        this.orderStatus = OrderStatus.INACTIVE;
    }

    public Order(OrderStatus orderStatus, List<OrderLine> orderLineList, LocalDate creationDate, BigDecimal totalPrice,
                 PaymentMethod paymentMethod, LocalDate deliveryDueDate, User user, String description) {
        this.id = ID++;
        this.orderStatus = orderStatus;
        this.orderLineList = orderLineList;
        this.creationDate = creationDate;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.deliveryDueDate = deliveryDueDate;
        this.user = user;
        this.description = description;
    }

    public Order(long id, OrderStatus orderStatus, LocalDate creationDate, BigDecimal totalPrice,
                 PaymentMethod paymentMethod, LocalDate deliveryDueDate, User user, String description,
                 OrderLine ... orderLineList) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.orderLineList = Arrays.stream(orderLineList).toList();
        this.creationDate = creationDate;
        this.totalPrice = totalPrice;
        this.paymentMethod = paymentMethod;
        this.deliveryDueDate = deliveryDueDate;
        this.user = user;
        this.description = description;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Order.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDeliveryDueDate() {
        return deliveryDueDate;
    }

    public void setDeliveryDueDate(LocalDate deliveryDueDate) {
        this.deliveryDueDate = deliveryDueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {

        return this.orderStatus == OrderStatus.ACTIVE;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", orderStatus=" + orderStatus +
            ", orderLineList=" + orderLineList +
            ", creationDate=" + creationDate +
            ", totalPrice=" + totalPrice +
            ", paymentMethod=" + paymentMethod +
            ", deliveryDueDate=" + deliveryDueDate +
            ", user=" + user +
            ", description='" + description + '\'' +
            '}';
    }
}
