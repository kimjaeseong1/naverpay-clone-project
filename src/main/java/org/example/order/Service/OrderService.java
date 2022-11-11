package org.example.order.Service;

import org.example.order.DAO.OrderDAO;
import org.example.order.Entity.Order;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService{
    @Override
    // 해당 유저의 모든 쇼핑 리스트를 가져옴
    public List<Order> getAllList(int userNum) {
        return OrderDAO.getInstance().getAllList(userNum);
    }

    @Override
    // 해당 유저의 n일 간의 쇼핑 리스트를 가져옴
    public List<Order> getPeriodList(int userNum, int period) {
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(new Date());
        calendar2.setTime(new Date());
        calendar2.add(calendar2.DATE, period);
        String startDate = calendar1.get(Calendar.YEAR) + "-" + (int)(calendar1.get(Calendar.MONTH) + 1) + "-" + calendar1.get(Calendar.DATE);
        String endDate = calendar2.get(Calendar.YEAR) + "-" + (int)(calendar2.get(Calendar.MONTH) + 1) + "-" + calendar2.get(Calendar.DATE);;
        return OrderDAO.getInstance().getPeriodList(userNum, startDate, endDate);
    }

    @Override
    // 해당 유저의 startdate부터 enddate까지의 쇼핑 리스트를 가져옴
    public List<Order> getPeriodList(int userNum, String startDate, String endDate) {
        return OrderDAO.getInstance().getPeriodList(userNum, startDate, endDate);
    }
}
