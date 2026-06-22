package com.interview.incidentrca.dto;
import com.interview.incidentrca.enums.*;import jakarta.validation.constraints.*;
public record IncidentCreateRequest(@NotBlank @Size(min=1,max=180) String title,@NotBlank @Size(min=1,max=4000) String description,@NotNull Severity severity,@NotBlank @Size(min=1,max=120) String serviceName,Long assignedEngineerId) {}
