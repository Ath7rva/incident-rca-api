package com.interview.incidentrca.dto;
import java.time.Instant; public record TimelineEventResponse(String type,String actor,String details,Instant timestamp) {}
