package com.interview.incidentrca.entity;
import com.interview.incidentrca.enums.IncidentStatus;import jakarta.persistence.*;import lombok.*;import java.time.Instant;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class IncidentStatusHistory { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(optional=false) private Incident incident; @Enumerated(EnumType.STRING) private IncidentStatus fromStatus; @Enumerated(EnumType.STRING) @Column(nullable=false) private IncidentStatus toStatus; @ManyToOne(optional=false) private User changedBy; private String note; @Column(nullable=false) private Instant changedAt; }
