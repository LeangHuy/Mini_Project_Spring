package org.example.btb_group_01_spring_mini_project.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OtpRequest {

    private String otpCode;
    private LocalDateTime issuedAt;
    private LocalDateTime expiration;
    private Boolean verify;
    private UUID userId;
}
