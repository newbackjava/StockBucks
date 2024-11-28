package com.ssginc.orders.service;

import com.ssginc.orders.model.dto.OrderDetailsDTO;

import java.util.ArrayList;

public interface dongOrdersService {
    // 주문 내역 조회

    // 1. 전체 조회
    ArrayList<OrderDetailsDTO> selectOrderDetailsList();
    // 2. 기간별 조회
    ArrayList<OrderDetailsDTO> selectOrderDetailsListByPeriod(String period, String date);
    // 3. 유저별 조회
    ArrayList<OrderDetailsDTO> selectOrderDetailsList(String user);
    // 4. 사용자 정의 조회
    ArrayList<OrderDetailsDTO> selectOrderDetailsList(String startDate, String endDate);
}
