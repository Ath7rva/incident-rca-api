# AI-Assisted Incident Management & Root Cause Analysis API

Enterprise-style Spring Boot REST API inspired by BMC Helix. It handles incident lifecycle, assignment, comments, timeline, SLA tracking, audit logs, analytics, duplicate detection, and explainable rule-based root cause suggestions.

## Live URLs

Fill these after cloud deployment:

- API Base URL: `https://incident-rca-api.onrender.com`
- Swagger UI: `https://incident-rca-api.onrender.com/swagger-ui/index.html`
- OpenAPI JSON: `https://incident-rca-api.onrender.com/v3/api-docs`

## Demo Credentials

Seeded users:

| Role | Email | Password |
|---|---|---|
| ADMIN | `admin@incidentrca.dev` | `Admin@123` |
| ENGINEER | `engineer@incidentrca.dev` | `Engineer@123` |
| VIEWER | `viewer@incidentrca.dev` | `Viewer@123` |

## Tech Stack

Java 17, Spring Boot 3, Spring Web, Spring Data JPA, PostgreSQL, Spring Security JWT, Spring Validation, Swagger/OpenAPI, Lombok, Maven, Docker, JUnit, Mockito.

## Main Features

- JWT auth with `ADMIN`, `ENGINEER`, `VIEWER`
- Incident CRUD with pagination, sorting and filters
- Lifecycle statuses: `OPEN`, `INVESTIGATING`, `ROOT_CAUSE_FOUND`, `RESOLVED`, `CLOSED`
- Severity and SLA tracking: `CRITICAL`, `HIGH`, `MEDIUM`, `LOW`
- Assignment and reassignment to engineers
- Comments and full incident timeline
- Rule-based root cause suggestion engine with confidence score
- Duplicate incident detection using keyword similarity
- Analytics by severity, status, service, SLA breach and average resolution time
- Audit logging for important business actions

## Cloud Deployment

Use a managed PostgreSQL database such as Supabase and deploy the app from this GitHub repo to Koyeb, Render, Railway, Fly.io, or any Docker-compatible host.

Required environment variables:

```bash
DATABASE_URL=jdbc:postgresql://host:5432/database?sslmode=require
DATABASE_USERNAME=your_db_user
DATABASE_PASSWORD=your_db_password
JWT_SECRET=use-a-long-random-secret-at-least-32-characters
SPRING_PROFILES_ACTIVE=prod
PORT=8080
```

For Koyeb:

1. Create a Supabase PostgreSQL project.
2. Copy host, database, username and password from Supabase connection settings.
3. In Koyeb, create a Web Service from this GitHub repo.
4. Select Dockerfile deployment.
5. Add the environment variables above.
6. Deploy and open `/swagger-ui/index.html`.

## Local Docker Option

This is optional. The project is cloud-first, but Docker support is included for portability.

```bash
docker compose up --build
```

## Important Endpoints

### Auth

```http
POST /api/auth/register
POST /api/auth/login
```

Login body:

```json
{
  "email": "admin@incidentrca.dev",
  "password": "Admin@123"
}
```

### Incidents

```http
POST /api/incidents
GET /api/incidents?page=0&size=10&sort=createdAt,desc
GET /api/incidents/{id}
PUT /api/incidents/{id}
DELETE /api/incidents/{id}
PATCH /api/incidents/{id}/status
PATCH /api/incidents/{id}/assign
POST /api/incidents/{id}/comments
GET /api/incidents/{id}/timeline
GET /api/incidents/{id}/root-cause-suggestions
GET /api/incidents/{id}/duplicates
```

Create incident example:

```json
{
  "title": "Payment API returning 503 after release",
  "description": "External gateway calls timing out after deployment. Users see checkout failure.",
  "severity": "CRITICAL",
  "serviceName": "Payment Gateway",
  "assignedEngineerId": 2
}
```

### Analytics and Audit

```http
GET /api/analytics/severity
GET /api/analytics/status
GET /api/analytics/top-services
GET /api/analytics/sla-breaches
GET /api/audit-logs
```

## Architecture

The API follows layered architecture:

- Controller: HTTP endpoints and role checks
- Service: business logic for incident lifecycle, SLA, RCA, duplicate detection, analytics
- Repository: Spring Data JPA database access
- DTO: request and response contracts
- Entity: database model
- Mapper: entity to DTO conversion
- Security: JWT authentication and Spring Security config
- Exception: global API error handling
- Config: Swagger and seed data

## ER Diagram Explanation

- `User` creates incidents, comments, status changes and audit logs.
- `Incident` belongs to one `ServiceComponent` and can be assigned to one engineer.
- `IncidentComment` stores discussion against an incident.
- `IncidentStatusHistory` stores every status transition.
- `RootCauseSuggestion` stores generated RCA recommendations for an incident.
- `AuditLog` stores important actions with actor, action, details and timestamp.

## How This Relates To BMC Helix

BMC Helix is used by IT teams to manage incidents, service health, operations, and root cause analysis. This project mirrors the backend thinking behind that kind of enterprise product: incident lifecycle, ownership, SLA, auditability, analytics, and assisted RCA. It is not a clone, but it shows the same product engineering concepts in a smaller interview-ready API.

## Interview Talking Points

- "I built this as an enterprise backend module, not a simple CRUD app."
- "Every incident has lifecycle tracking, assignment, SLA state and audit logs."
- "The RCA engine is explainable. It uses rules and keywords, so the confidence score can be justified."
- "Duplicate detection prevents multiple engineers from working on the same outage separately."
- "I used DTOs, validation, global exceptions, JWT security and role-based authorization."
- "The API is deployable using Docker and environment variables, so it is cloud-ready."

## Simple Indian Interview English

"This project is an incident management backend API. Suppose an enterprise application has a production issue, then support or operations team can create an incident, assign severity, assign engineer, add comments, change status and track SLA. I also added a rule-based RCA engine which checks title, description, service name and error keywords to suggest possible root causes like database issue, authentication failure or deployment regression. I added audit logs and analytics also, so it looks like a real enterprise product module similar to tools like BMC Helix."

## Run Tests

Cloud CI runs:

```bash
mvn -B test
```
