package com.interview.incidentrca.dto;
import com.interview.incidentrca.enums.IncidentStatus;import jakarta.validation.constraints.NotNull;
public record StatusUpdateRequest(@NotNull IncidentStatus status,String note) {}
