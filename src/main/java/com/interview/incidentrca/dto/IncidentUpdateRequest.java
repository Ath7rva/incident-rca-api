package com.interview.incidentrca.dto;
import com.interview.incidentrca.enums.*;import jakarta.validation.constraints.*;
public record IncidentUpdateRequest(@NotBlank @Size(max=180) String title,@NotBlank @Size(max=4000) String description,@NotNull Severity severity,@NotBlank String serviceName) {}
