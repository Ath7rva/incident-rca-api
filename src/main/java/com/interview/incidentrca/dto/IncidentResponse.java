package com.interview.incidentrca.dto;
import com.interview.incidentrca.enums.*;import java.time.Instant;import java.util.List;
public record IncidentResponse(Long id,String title,String description,Severity severity,IncidentStatus status,String serviceName,UserResponse assignedEngineer,UserResponse createdBy,Instant createdAt,Instant updatedAt,Instant resolvedAt,SlaState slaState,List<Long> possibleDuplicateIds) {}
