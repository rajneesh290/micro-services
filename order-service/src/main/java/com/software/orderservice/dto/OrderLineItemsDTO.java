package com.software.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDTO {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
