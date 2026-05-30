package com.casapao.orders.app.util;

import com.casapao.orders.app.dto.OrderRequest;

public interface OrderValidator {
    void validate(OrderRequest request);
}