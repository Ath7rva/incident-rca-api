package com.interview.incidentrca.entity;
import jakarta.persistence.*;import lombok.*;import java.time.Instant;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AuditLog { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne private User actor; @Column(nullable=false) private String action; @Column(nullable=false,length=2000) private String details; @Column(nullable=false) private Instant timestamp; }
