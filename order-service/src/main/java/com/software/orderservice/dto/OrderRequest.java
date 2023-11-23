package com.software.orderservice.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDTO> orderLineItems;
}
