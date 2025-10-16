# Experiment 7: Docker

## How I went forward with containerizing the app
- Downloaded gradle image from Docker Hub

### Created Dockerfile
- specified correct version of gradle for my project
- copied source files
- compiled with gradle
- received a jar file which is moved and is used to run
- specified port 8080
- starting the spring boot application

### Create image
- run in project dir terminal command: 
```docker build -t demo-app .```

- Verified that it is created by looking in the Docker desktop app and finding this in the image section:
![docker_image.png](assignment_assets/docker_image.png)

### Run container
``` docker run -p 8080:8080 demo-app```
- Can verify that it is running both in the terminal as well as the Docker desktop app.