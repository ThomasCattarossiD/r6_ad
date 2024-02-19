package org.example;

public class FeeCalculator {
    private static final double CHILD_PRICE_BASE = 100;
    private static final double ADULT_PRICE_BASE = 100;

    public static double calculateFee(Visitor visitor, TicketType ticketType) {
        double fee = 0;
        fee = calculateAdultFee(visitor, ticketType);
        fee = calculateChildFee(visitor, ticketType);
        return fee;
    }

    private static double calculateChildFee(Visitor visitor, TicketType ticketType) {
        // calculate price for children
        if (visitor.getAge() <= 14) {
            if (TicketType.HALF_DAY == ticketType) {
                return ADULT_PRICE_BASE * 0.2;
            } else if (TicketType.FULL_DAY == ticketType) {
                return ADULT_PRICE_BASE * 0.5;
            }
        }
        return 0;
    }

    private static double calculateAdultFee(Visitor visitor, TicketType ticketType) {
        // calculate price for adults
        if (visitor.getAge() > 14) {
            if (TicketType.HALF_DAY == ticketType) {
                return ADULT_PRICE_BASE * 0.6;
            } else if (TicketType.FULL_DAY == ticketType) {
                return ADULT_PRICE_BASE * 1.2;
            }
        }
        return 0;
    }
}

