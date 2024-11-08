package com.airline.airline.dto;

import java.util.Set;

public record SingupRequest(String username,
                            String email,
                            String password,
                            Set<String> roles) {
}
