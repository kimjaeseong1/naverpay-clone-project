package org.example.order.Service;

import org.example.order.Entity.Order;

import java.util.List;

public interface IOrderService {

    List<Order> getAllList(int userNum);    //전체 리스트 반환
    List<Order> getPeriodList(int userNum, int period);  //현재 날짜 기준 n일의 리스트 반환
    List<Order> getPeriodList(int userNum, String startDate, String endDate);    // start - end 기간 리스트 반환
}
