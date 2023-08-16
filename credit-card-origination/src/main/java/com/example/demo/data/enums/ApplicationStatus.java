package com.example.demo.data.enums;

public enum ApplicationStatus {
    CreditScoreFetchPending,
    ConsultingCustomer,
    Declined,
    Completed;

    public static ApplicationStatus getValue(String key){
        return switch (key){
            case("CreditScoreFetchPending") -> ApplicationStatus.CreditScoreFetchPending;
            case("ConsultingCustomer") -> ApplicationStatus.ConsultingCustomer;
            case ("Declined") -> ApplicationStatus.Declined;
            case ("Completed") -> ApplicationStatus.Completed;
            default -> throw new IllegalArgumentException();
        };
    }
}
