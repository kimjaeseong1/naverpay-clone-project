import org.example.order.Service.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestExecutionListeners;

public class ORDERTEST {

    OrderService orderService = new OrderService();

    @AfterEach
    public void afterEach() {

    }


    @Test
    public void findAllList() {
        orderService.getAllList(1);
    }

    @Test
    public void findTermList() {
        orderService.getPeriodList(1, 7);
    }

    @Test
    public void findPeriodList() {
        orderService.getPeriodList(1, "2022-11-07", "2022-11-09");

    }


}
