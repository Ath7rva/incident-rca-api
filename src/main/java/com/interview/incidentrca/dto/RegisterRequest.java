package com.interview.incidentrca.dto;
import com.interview.incidentrca.enums.Role;import jakarta.validation.constraints.*;
public record RegisterRequest(@NotBlank @Size(min=1,max=120) String name,@Email @NotBlank String email,@NotBlank @Size(min=6,max=120) String password,@NotNull Role role) {}
