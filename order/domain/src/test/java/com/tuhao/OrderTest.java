package com.tuhao;

import com.tuhao.domain.order.Order;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;

/**
 * Created by apple on 3/1/16.
 */
public class OrderTest {
    private FixtureConfiguration fixture;
    private String driverId = "wang shi fu";

    @Before
    public void setUp() throws Exception {
//        fixture = Fixtures.newGivenWhenThenFixture();
    }

//    @Test
//    public void order_will_be_created() {
//        OrderIdentifier id = new OrderIdentifier();
//        fixture.given()
//                .when(new CreateOrderCommand(id))
//                .expectEvents(new OrderCreatedEvent(id));
//    }
//
//    @Test
//    public void order_will_be_accepted() {
//        OrderIdentifier id = new OrderIdentifier();
//        fixture.given(new OrderCreatedEvent(id))
//                .when(new AcceptOrderCommand(id, driverId))
//                .expectEvents(new OrderAcceptedEvent(driverId));
//
//    }
//
//    @Test
//    public void can_not_accept_an_order_which_already_accepted() {
//        OrderIdentifier id = new OrderIdentifier();
//        fixture.given(new OrderCreatedEvent(id), new OrderAcceptedEvent(driverId))
//                .when(new AcceptOrderCommand(id, driverId))
//                .expectException(RuntimeException.class);
//    }
}
