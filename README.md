# SecureDelivery: Advanced Java CI/CD Pipeline

This project demonstrates a production-grade CI/CD pipeline for a Spring Boot application using GitHub Actions.

## Features
- **Java 17 & Spring Boot 3**: Modern stack for high-performance microservices.
- **Full CI/CD Pipeline**: Automated builds, tests, and deployments.
- **Shift-Left Security**: Integrated SAST, SCA, and Container scanning.
- **Dockerized**: Multi-stage Docker builds for optimized image size.
- **Kubernetes Ready**: CD pipeline prepared for K8s deployment.

## Pipeline Architecture
1. **CI Pipeline (`ci.yml`)**:
   - `build-and-test`: Java setup, Maven build, Checkstyle, and Unit tests.
   - `security-scans`: File system scanning using Trivy.
   - `docker-build`: Builds image, scans it with Trivy, performs smoke tests, and pushes to DockerHub.
2. **CD Pipeline (`cd.yml`)**:
   - Triggers after successful CI.
   - Simulates deployment to a Kubernetes cluster.

## How to Run Locally
1. **Clone the repository.**
2. **Build the application:**
   ```bash
   mvn clean package
   ```
3. **Run the application:**
   ```bash
   java -jar target/*.jar
   ```
4. **Build Docker Image:**
   ```bash
   docker build -t secure-app .
   ```
5. **Run Docker Container:**
   ```bash
   docker run -p 8080:8080 secure-app
   ```

## Secrets Configuration
To run the full pipeline, configure the following secrets in your GitHub repository:
- `DOCKERHUB_USERNAME`: Your DockerHub username.
- `DOCKERHUB_TOKEN`: Your DockerHub Personal Access Token (PAT).

## Project Structure
- `.github/workflows/`: CI/CD workflow definitions.
- `src/`: Application source code and tests.
- `Dockerfile`: Multi-stage build for the application.
- `pom.xml`: Maven configuration with Checkstyle integration.
