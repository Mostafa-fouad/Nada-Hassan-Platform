package com.example.nadahassanplatform.orders.service;

import com.example.nadahassanplatform.orders.dto.ShippingDto;

import java.util.List;

public interface ShippingService {

    List<ShippingDto> getAllShippings();
    List<String> getAllShippingGovernments();
    void addShipping(ShippingDto shippingDto);
    void editShippingFees(ShippingDto shippingDto);
}