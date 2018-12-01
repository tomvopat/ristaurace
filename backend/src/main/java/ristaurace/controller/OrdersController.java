// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(path="/order")
public class OrdersController {

    @GetMapping(path="/all")
    public @ResponseBody String getAllOrders() {
        return "All orders";
    }

    @GetMapping(path="/id/{id}")
    public @ResponseBody String getOrder(@PathVariable long id) {
        return "Exact order - by id";
    }

    @GetMapping(path="/date/{date}")
    public @ResponseBody String getOrdersDate(@PathVariable LocalDate date) {
        return "All orders on date.";
    }

    @GetMapping(path="/pending")
    public @ResponseBody String getOrdersPending() {
        return "Pending orders.";
    }

    @PostMapping(path="/setReady/{id}")
    public @ResponseBody String setOrderReady(@PathVariable long id) {
        return "Order set as ready";
    }

    @PostMapping(path="/setDone/{id}")
    public @ResponseBody String setOrderDone(@PathVariable long id) {
        return "Order se as done";
    }

}
