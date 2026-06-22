package com.interview.incidentrca.entity;
import jakarta.persistence.*;import lombok.*;import java.time.Instant;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class IncidentComment { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(optional=false) private Incident incident; @ManyToOne(optional=false) private User author; @Column(nullable=false,length=2000) private String message; @Column(nullable=false) private Instant createdAt; }
