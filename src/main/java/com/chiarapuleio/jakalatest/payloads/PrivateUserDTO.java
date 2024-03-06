package com.chiarapuleio.jakalatest.payloads;

public record PrivateUserDTO(
        String name,
        String lastName,
        String taxCode,
        String address
) {
}
