package org.example.order.Service;

import org.example.order.DAO.OrderDAO;
import org.example.order.Entity.Order;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderService implements IOrderService{
    @Override
    public List<Order> getAllList(int userNum) {
        return OrderDAO.getInstance().getAllList(userNum);
    }

    @Override
    public List<Order> getPeriodList(int userNum, int period) {
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar2.setTime(new Date());
        calendar2.add(calendar2.DATE, period);
        String startDate = calendar1.get(Calendar.YEAR) + " - " + calendar1.get(Calendar.MONTH) + " - " + calendar1.get(Calendar.DATE);
        String endDate = calendar2.get(Calendar.YEAR) + " - " + calendar2.get(Calendar.MONTH) + " - " + calendar2.get(Calendar.DATE);;
        return OrderDAO.getInstance().getPeriodList(userNum, startDate, endDate);
    }

    @Override
    public List<Order> getPeriodList(int userNum, String startDate, String endDate) {
        return OrderDAO.getInstance().getPeriodList(userNum, startDate, endDate);
    }
}
