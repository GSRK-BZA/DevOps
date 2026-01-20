# SecureDelivery: Advanced DevOps CI/CD Project - Final Report

**Student Name:** GSRK
**Course:** Advanced DevOps
**Project Title:** Production-Grade Java CI/CD Pipeline with Shift-Left Security

---

## 1. Problem Background & Motivation
In modern software delivery, speed often comes at the cost of security. Most CI/CD pipelines are designed to verify that "code works" (Build & Test) but fail to verify that "code is safe" (Security). This project, **SecureDelivery**, implements a **DevSecOps** philosophy. By shifting security to the left—integrating it into the early stages of the pipeline—we identify vulnerabilities before they ever reach a container registry or a production cluster. This approach reduces the cost of fixing bugs and prevents high-profile security breaches.

## 2. Application Overview
The core of this project is a **Spring Boot 3** REST API built using Java 17. The application follows a microservices architecture pattern, providing a lightweight and high-performance backend.
- **Language:** Java 17
- **Framework:** Spring Boot 3.4.2
- **Build Tool:** Maven
- **Containerization:** Multi-stage Docker build using Eclipse Temurin JRE.

## 3. CI/CD Architecture
The pipeline is divided into two distinct workflows:

### Continuous Integration (CI)
Automated on every push to `main`.
1. **Quality Gate:** Maven Checkstyle enforcing strict Google/Sun coding standards.
2. **Logic Gate:** JUnit 5 tests to prevent functional regressions.
3. **Security Gate (SCA):** **Trivy** scan of the filesystem and `pom.xml` to detect vulnerable dependencies.
4. **Artifact Stage:** Generation of a production-ready JAR file.
5. **Containerization:** Building an optimized Docker image.
6. **Container Security:** Trivy scan of the final Docker image.
7. **Runtime Validation:** Smoke tests running the container and verifying the `/` endpoint.
8. **Registry Stage:** Pushing the "trusted image" to DockerHub.

### Continuous Delivery (CD)
Triggered upon successful completion of the CI pipeline.
1. **Deployment:** Simulated deployment to a Kubernetes cluster via manifest application.
2. **Dynamic Analysis:** Automated DAST (Dynamic Application Security Testing) placeholder to verify the running endpoint.

## 4. Security & Quality Controls - Deep Dive
### Shift-Left Security with Trivy
We integrated **Trivy** to perform Software Composition Analysis (SCA). During the project, the scan identified a **CRITICAL** vulnerability in the default Tomcat version (CVE-2025-24813).
- **Remediation:** We didn't just ignore the scan. We aggressively upgraded the `pom.xml` properties to force **Tomcat 11.0.11**, which resolved the critical path and ensured a compliant build.

### Coding Standards (Linting)
We utilized the `maven-checkstyle-plugin` with the `sun_checks.xml` ruleset. This ensured that every line of code followed industry-standard Javadoc, spacing, and design patterns, reducing technical debt.

## 5. Results & Observations
The pipeline successfully automated the entire lifecycle. Key findings include:
- **Immediate Feedback:** Developers are notified within 2 minutes if their code violates security or quality standards.
- **Dependency Transparency:** The SCA scan provides a clear bill of materials and vulnerability report.
- **Repeatability:** The Docker multi-stage build ensures that the environment in CI is identical to the one in production.

## 6. Limitations & Improvements
While the current pipeline is robust, future enhancements include:
- **Infrastructure as Code (IaC):** Integrating Terraform to manage the underlying AWS/GCP resources.
- **Service Mesh:** Implementing Istio for advanced traffic management in Kubernetes.
- **Observability:** Integrating Prometheus and Grafana for post-deployment monitoring.

## 7. Conclusion
The **SecureDelivery** project demonstrates that a CI/CD pipeline is more than just a build script—it is a security framework. By enforcing quality and security gates automatically, we ensure that only high-quality, secure, and validated code reaches our users.

---
**End of Report**
