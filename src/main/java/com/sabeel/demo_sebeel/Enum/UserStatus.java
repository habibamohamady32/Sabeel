package com.sabeel.demo_sebeel.Enum;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "User account status")
public enum UserStatus {

    ENROLLED_ACTIVE,          // مقيد / نشط
    ENROLLED,                 // تم الالتحاق
    OVER_SIXTY,                  // فوق الـ 60
    TEMPORARILY_EXCLUDED,     // مستبعد مؤقت
    PENDING,                  // قيد الانتظار
    PERMANENTLY_EXCLUDED,     // مستبعد نهائي
    SUSPENDED
}
