package com.interview.incidentrca.entity;
import com.interview.incidentrca.enums.Role;import jakarta.persistence.*;import lombok.*;import java.time.Instant;
@Entity @Table(name="users") @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @Column(nullable=false,unique=true) private String email; @Column(nullable=false) private String name; @Column(nullable=false) private String password; @Enumerated(EnumType.STRING) @Column(nullable=false) private Role role; @Column(nullable=false) private Instant createdAt; }
