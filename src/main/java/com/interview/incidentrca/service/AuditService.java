package com.interview.incidentrca.service;
import com.interview.incidentrca.entity.*;import com.interview.incidentrca.repository.AuditLogRepository;import lombok.RequiredArgsConstructor;import org.springframework.stereotype.Service;import java.time.Instant;
@Service @RequiredArgsConstructor public class AuditService{private final AuditLogRepository logs; public void record(User actor,String action,String details){logs.save(AuditLog.builder().actor(actor).action(action).details(details).timestamp(Instant.now()).build());}}
