package com.interview.incidentrca.entity;
import jakarta.persistence.*;import lombok.*;import java.time.Instant;
@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ServiceComponent { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,unique=true) private String name; private String ownerTeam; private String businessCriticality; @Column(nullable=false) private Instant createdAt; }
