package com.sabeel.demo_sebeel.Enum;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User account status")
public enum UserStatus {
    ACTIVE,
    SUSPENDED,
    INACTIVE
}
