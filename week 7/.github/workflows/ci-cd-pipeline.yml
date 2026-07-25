name: CI/CD Pipeline Demo

# Triggers: CI runs on every push/PR; CD (deploy job) only runs on pushes to main -
# this is the Continuous Integration vs Continuous Delivery distinction in practice.
on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  # ---------------- CONTINUOUS INTEGRATION ----------------
  build-and-test:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v4

      - name: Setup Node.js
        uses: actions/setup-node@v4
        with:
          node-version: "20"
          cache: "npm"

      - name: Install dependencies
        run: npm ci

      - name: Lint
        run: npm run lint --if-present

      - name: Run unit tests
        run: npm test -- --watch=false --browsers=ChromeHeadless

      - name: Build production bundle
        run: npm run build -- --configuration production

      - name: Upload build artifact
        uses: actions/upload-artifact@v4
        with:
          name: dist
          path: dist/

  # ---------------- CONTINUOUS DELIVERY/DEPLOYMENT ----------------
  # Only runs after build-and-test succeeds, and only on pushes to main -
  # PRs get CI feedback but never trigger a deployment.
  deploy:
    needs: build-and-test
    if: github.ref == 'refs/heads/main' && github.event_name == 'push'
    runs-on: ubuntu-latest
    environment: production
    steps:
      - name: Download build artifact
        uses: actions/download-artifact@v4
        with:
          name: dist
          path: dist/

      - name: Build & push Docker image
        run: |
          echo "docker build -t yourrepo/app:${{ github.sha }} ."
          echo "docker push yourrepo/app:${{ github.sha }}"
          # Replace the echoed commands above with real docker/login-action +
          # docker/build-push-action steps once a registry is configured.

      - name: Deploy to production
        run: |
          echo "Deploying image yourrepo/app:${{ github.sha }} to production..."
          # e.g. kubectl set image deployment/app app=yourrepo/app:${{ github.sha }}
          # or a cloud provider's CLI (az webapp deploy, aws ecs update-service, etc.)
