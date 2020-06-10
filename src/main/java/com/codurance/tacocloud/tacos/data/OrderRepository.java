package com.codurance.tacocloud.tacos.data;

import com.codurance.tacocloud.tacos.Order;

public interface OrderRepository {
  Order save(Order order);
}
