package com.interview.incidentrca.mapper;
import com.interview.incidentrca.dto.*;import com.interview.incidentrca.entity.*;import com.interview.incidentrca.enums.SlaState;import org.springframework.stereotype.Component;import java.util.*;
@Component public class IncidentMapper{
 public UserResponse toUser(User u){return u==null?null:new UserResponse(u.getId(),u.getName(),u.getEmail(),u.getRole());}
 public IncidentResponse toIncident(Incident i,SlaState sla,List<Long> dupes){return new IncidentResponse(i.getId(),i.getTitle(),i.getDescription(),i.getSeverity(),i.getStatus(),i.getServiceComponent().getName(),toUser(i.getAssignedEngineer()),toUser(i.getCreatedBy()),i.getCreatedAt(),i.getUpdatedAt(),i.getResolvedAt(),sla,dupes);}
 public RootCauseSuggestionResponse toSuggestion(RootCauseSuggestion s){return new RootCauseSuggestionResponse(s.getId(),s.getCategory(),s.getConfidenceScore(),s.getExplanation(),s.getCreatedAt());}
 public AuditLogResponse toAudit(AuditLog a){return new AuditLogResponse(a.getId(),a.getActor()==null?"system":a.getActor().getEmail(),a.getAction(),a.getDetails(),a.getTimestamp());}
}
