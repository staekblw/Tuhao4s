package com.tuhao;

import com.tuhao.command.order.TakeOrderCommand;
import com.tuhao.command.order.CancelOrderCommand;
import com.tuhao.command.order.CreateOrderCommand;
import com.tuhao.commandhandler.order.OrderCommandHandler;
import com.tuhao.common.id.CarOwnerIdentifier;
import com.tuhao.common.id.OrderIdentifier;
import com.tuhao.domain.order.Location;
import com.tuhao.domain.order.Order;
import com.tuhao.events.order.OrderTakenEvent;
import com.tuhao.events.order.OrderCancelledEvent;
import com.tuhao.events.order.OrderCreatedEvent;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static com.tuhao.domain.order.OrderException.*;
import static org.hamcrest.core.Is.is;

public class OrderTest {
    private FixtureConfiguration fixture;
    private String driver = "王林波";
    private OrderIdentifier orderId = new OrderIdentifier(UUID.randomUUID().toString());
    private CarOwnerIdentifier carOwner = new CarOwnerIdentifier("王思聪");
    private Location location = new Location("软件园e区大门");

    //events
    private OrderCreatedEvent a_car_owner_created_an_order = new OrderCreatedEvent(carOwner, orderId, location);
    private OrderTakenEvent a_driver_taken_the_order = new OrderTakenEvent(driver, orderId);
    private OrderCancelledEvent car_owner_cancelled_the_order = new OrderCancelledEvent(orderId);

    //commands
    private TakeOrderCommand a_driver_take_the_order = new TakeOrderCommand(orderId, driver);


    @Before
    public void setUp() throws Exception {
        fixture = Fixtures.newGivenWhenThenFixture(Order.class);
        fixture.registerAnnotatedCommandHandler(new OrderCommandHandler(fixture.getRepository()));
    }

    @Test
    public void order_will_be_created() {
        CreateOrderCommand car_owner_create_an_order = new CreateOrderCommand(orderId, carOwner, location);
        OrderCreatedEvent an_order_created = new OrderCreatedEvent(carOwner, orderId, location);
        fixture.given()
                .when(car_owner_create_an_order)
                .expectEvents(an_order_created);
    }

    @Test
    public void order_taken_by_a_driver() {
        fixture.given(a_car_owner_created_an_order)
                .when(a_driver_take_the_order)
                .expectEvents(a_driver_taken_the_order);

    }

    @Test
    public void can_not_take_order_if_owner_cancelled_it() {
        fixture.given(
                a_car_owner_created_an_order,
                car_owner_cancelled_the_order)
                .when(a_driver_take_the_order)
                .expectException(is(CAN_NOT_TAKEN_ORDER));

    }

    @Test
    public void can_not_cancel_order_if_a_driver_already_taken_it() {
        CancelOrderCommand owner_cancel_the_order = new CancelOrderCommand(orderId, driver);

        fixture.given(a_car_owner_created_an_order, a_driver_taken_the_order)
                .when(owner_cancel_the_order)
                .expectException(is(CAN_NOT_CANCEL_ORDER));
    }

    @Test
    public void can_not_take_an_order_which_already_taken() {
        fixture.given(a_car_owner_created_an_order, a_driver_taken_the_order)
                .when(a_driver_take_the_order)
                .expectException(is(CAN_NOT_TAKEN_ORDER));
    }
}
