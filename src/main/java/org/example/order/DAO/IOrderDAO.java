package org.example.order.DAO;

import org.example.order.Entity.Order;

import java.util.List;

public interface IOrderDAO {

    List<Order> getAllList(int userNum);    //전체 리스트 반환
    List<Order> getPeriodList(int userNum, String startDate, String endDate);    // start - end 기간 리스트 반환
}
