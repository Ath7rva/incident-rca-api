package com.interview.incidentrca.dto;
import java.time.Instant; public record AuditLogResponse(Long id,String actor,String action,String details,Instant timestamp) {}
