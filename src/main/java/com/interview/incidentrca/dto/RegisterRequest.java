package com.interview.incidentrca.dto;
import com.interview.incidentrca.enums.Role;import jakarta.validation.constraints.*;
public record RegisterRequest(@NotBlank String name,@Email @NotBlank String email,@Size(min=6) String password,@NotNull Role role) {}
