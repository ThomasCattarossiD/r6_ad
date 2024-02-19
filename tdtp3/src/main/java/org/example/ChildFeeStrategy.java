package org.example;

public class ChildFeeStrategy {
    static final double CHILD_PRICE_BASE = 100;

    static double getChildFee(Visitor visitor, TicketType ticketType, double fee) {
        // calculate price for children
        if ((visitor.getAge() <= 14) && (TicketType.HALF_DAY == ticketType)) {
            fee = CHILD_PRICE_BASE * 0.2;
        } else if ((visitor.getAge() <= 14) && (TicketType.FULL_DAY == ticketType)) {
            fee = CHILD_PRICE_BASE * 0.5;
        }
        return fee;
    }
}