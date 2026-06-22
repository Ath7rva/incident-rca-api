package com.interview.incidentrca.dto;
import java.time.Instant; public record RootCauseSuggestionResponse(Long id,String category,int confidenceScore,String explanation,Instant createdAt) {}
