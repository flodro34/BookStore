# Étape 1 : Build stage
FROM node:18 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build --prod

# Étape 2 : Serve stage
FROM nginx:alpine
COPY --from=build /app/dist/bookstore-frontend/browser /usr/share/nginx/html

EXPOSE 80
