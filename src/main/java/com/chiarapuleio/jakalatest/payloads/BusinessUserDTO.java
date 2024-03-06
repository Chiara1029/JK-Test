package com.chiarapuleio.jakalatest.payloads;

public record BusinessUserDTO(
        String businessName,
        Long vatNumber,
        String address
) {
}
