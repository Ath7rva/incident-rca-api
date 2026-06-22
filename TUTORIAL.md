# Tutorial: How To Understand And Present This Project

## 1. One-Line Explanation

This project is a Spring Boot backend API for managing production incidents, tracking SLA, assigning engineers, suggesting root causes, detecting duplicates, and showing analytics.

Simple version:

> If something breaks in a company application, this API helps the IT team track the issue from creation to resolution.

## 2. Demo URL

Open:

```text
https://incident-rca-api.onrender.com
```

This opens a simple dashboard. Use this first. Use Swagger only if the interviewer wants to inspect raw APIs.

Swagger:

```text
https://incident-rca-api.onrender.com/swagger-ui/index.html
```

## 3. What To Show First

Start with the dashboard.

Explain:

> This page is reading live data from the Spring Boot API deployed on Render. The database is PostgreSQL on Supabase.

Point to:

- Total incidents
- Critical incidents
- Top affected service
- Incident list
- Selected incident details

## 4. Explain Incident

Say:

> An incident is a production issue. For example, Payment API returning 503 means users may not be able to complete payment.

Each incident has:

- title
- description
- severity
- status
- service name
- assigned engineer
- SLA state

## 5. Explain SLA

Say:

> SLA means how quickly the team should fix the issue. Critical incidents have 1 hour, High has 4 hours, Medium has 12 hours, and Low has 24 hours.

The project shows:

- WITHIN_SLA
- NEAR_BREACH
- BREACHED

## 6. Explain Timeline

Say:

> Timeline shows the full journey of the incident: created, assigned, status changed, comment added, and resolved.

This is useful because enterprise teams need traceability.

## 7. Explain Root Cause Suggestions

Say:

> This is the AI-assisted part. I did not use a paid AI API. I built an explainable rule-based engine. It checks incident title, description, service name, severity, and keywords, then suggests possible root causes with confidence score and explanation.

Examples:

- database, sql, connection, timeout -> Database connection issue
- login, jwt, token, unauthorized -> Authentication failure
- deploy, release, rollback -> Deployment regression
- api, gateway, 502, 503 -> External API failure

## 8. Explain Duplicate Detection

Say:

> Duplicate detection compares incident keywords with open incidents. This prevents two engineers from working on the same production issue separately.

## 9. Explain Analytics

Say:

> Analytics APIs help managers understand incident trends. We can count incidents by severity, status, top affected services, and SLA breaches.

## 10. Explain Security

Say:

> For interview demo, read-only APIs are public so reviewers can test easily. Write and admin APIs are protected using JWT and roles.

Roles:

- ADMIN: full access
- ENGINEER: can work on incidents
- VIEWER: read-only

## 11. Architecture Explanation

Say:

> I followed layered architecture.

Layers:

- Controller receives HTTP requests
- Service contains business logic
- Repository talks to PostgreSQL
- Entity represents database tables
- DTO represents request and response data
- Mapper converts entity to DTO
- Security handles JWT and roles
- Exception handler gives clean API errors

Request flow:

```text
Browser or Postman
  -> Controller
  -> Service
  -> Repository
  -> PostgreSQL
  -> DTO response
```

## 12. How It Relates To BMC Helix

Say:

> BMC Helix is used for IT service management, incident operations, SLA tracking, and root cause analysis. This project is a smaller backend module inspired by those enterprise workflows.

## 13. Five-Minute Video Script

Use this script if you want to record a video.

```text
Hi, this is my AI-Assisted Incident Management and Root Cause Analysis API.

This project is built using Java 17, Spring Boot 3, Spring Security with JWT, Spring Data JPA, PostgreSQL, Swagger, Docker, and JUnit tests.

The idea is inspired by enterprise tools like BMC Helix. In real companies, when a production issue happens, teams need to create an incident, assign severity, assign an engineer, track status, add comments, monitor SLA, and find the root cause.

On this dashboard, we can see total incidents, critical incidents, and the top affected service.

Here is an incident: Payment API returning 503 after release. It has severity CRITICAL, status INVESTIGATING, service Payment Gateway, and SLA state.

The timeline shows the full journey of the incident. It helps teams understand what happened and when.

The root cause suggestion section is the AI-assisted part. I implemented it as an explainable rule-based engine. It checks keywords like deployment, gateway, timeout, authentication, database, and gives root cause suggestions with confidence score and explanation.

Duplicate detection checks whether similar open incidents already exist.

Analytics APIs show counts by severity and top affected services, which can support dashboards for managers.

For security, read-only APIs are public for demo convenience, but write and admin APIs are protected using JWT and roles like ADMIN, ENGINEER, and VIEWER.

The backend follows layered architecture: controller, service, repository, DTO, entity, mapper, security, config, and exception handling.

This is not a simple CRUD project. It represents a real enterprise backend module for incident lifecycle, SLA, RCA, auditability, and analytics.
```

## 14. If Interviewer Asks Why Read APIs Are Public

Say:

> In a real production system, we can protect every endpoint. For this interview deployment, I made read-only demo APIs public so the interviewer can test quickly without JWT setup. Write and admin actions are still secured.

## 15. Best Closing Line

Say:

> This project shows that I understand backend architecture, enterprise workflows, security, database design, API design, and business logic beyond normal CRUD.
