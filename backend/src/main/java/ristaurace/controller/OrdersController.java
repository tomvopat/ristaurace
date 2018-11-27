// Tomáš Vopat - vopattom

package ristaurace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping(path="/order")
public class OrdersController {

    @GetMapping(path="/")
    public @ResponseBody String getAllOrders() {
        return "All orders";
    }

    @GetMapping(path="/")
    public @ResponseBody String getOrdersDate(@RequestParam LocalDate date) {
        return "All orders on date.";
    }

    @GetMapping(path="/pending")
    public @ResponseBody String getOrdersPending() {
        return "Pending orders.";
    }

    @GetMapping(path="/")
    public @ResponseBody String getOrder(@RequestParam long order_id) {
        return "Exact order - by id";
    }

    @PostMapping(path="/setReady")
    public @ResponseBody String setOrderReady(@RequestParam long order_id) {
        return "Order set as ready";
    }

    @PostMapping(path="/setDone")
    public @ResponseBody String setOrderDone(@RequestParam long order_id) {
        return "Order se as done";
    }

}
