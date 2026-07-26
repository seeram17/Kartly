<!-- DAY 3 — COMMIT 44: project README -->

# Kartly — Frontend

React + Vite frontend for the Kartly e-commerce app. Talks to a Spring Boot
backend running at `http://localhost:8080`.

## Features
- Product catalog with category filter and live search
- Product detail page with add/update/delete
- Cart with quantity controls and running total
- Checkout modal
- Light / dark theme toggle

## Setup

```bash
cd Frontend
npm install
npm run dev
```

Make sure the Spring Boot backend (see `/src/main/java`) is running on
port 8080 first — the frontend expects the API at
`http://localhost:8080/api`.

## Tech
React, React Router, Bootstrap 5, Axios, Vite.
