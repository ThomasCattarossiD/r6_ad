package org.example;

public class FeeCalculator {

    public static double calculateFee(Visitor visitor, TicketType ticketType) {
        double fee = 0;
        fee = AdultFeeStrategy.getAdultFee(visitor, ticketType, fee);
        fee = ChildFeeStrategy.getChildFee(visitor, ticketType, fee);
        return fee;
    }

}
