package org.example;

public class AdultFeeStrategy {
    static final double ADULT_PRICE_BASE = 100;

    static double getAdultFee(Visitor visitor, TicketType ticketType, double fee) {
        // calculate price for adults
        if (visitor.getAge() > 14) {
            if (TicketType.HALF_DAY == ticketType) {
                fee = ADULT_PRICE_BASE * 0.6;
            } else if (TicketType.FULL_DAY == ticketType) {
                fee = ADULT_PRICE_BASE * 1.2;
            }
        }
        return fee;
    }
}