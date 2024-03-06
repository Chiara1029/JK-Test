package com.chiarapuleio.jakalatest.payloads;

import com.chiarapuleio.jakalatest.enums.ContractType;

import java.time.LocalDate;
import java.util.UUID;

public record ContractDTO(
        ContractType contractType,
        LocalDate startingDate,
        UUID customerId
) {
}
