package com.interview.incidentrca.entity;
import jakarta.persistence.*;import lombok.*;import java.time.Instant;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class RootCauseSuggestion { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(optional=false) private Incident incident; @Column(nullable=false) private String category; @Column(nullable=false) private int confidenceScore; @Column(nullable=false,length=2000) private String explanation; @Column(nullable=false) private Instant createdAt; }
