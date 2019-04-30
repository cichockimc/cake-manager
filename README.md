Cake Manager Micro Service (fictitious)
=======================================

# changes
- bootifed
- separate web and rest endpoints
- added basic tests (like loading context, respond with 200)
- jetty -> default spring boot tomcat
- added thymeleaf
- continous integration: https://hub.docker.com/r/cichockimc/cake-manager/builds

*note* some of image links are broken

# Build
`mvn clean install`

# Run
`mvn spring-boot:run`

# Docker & CI
Repository (automatic builds triggered by push to master branch) 
`https://hub.docker.com/r/cichockimc/cake-manager`

# Cloud deployment 
TBA

# Model
```json
{
	"title": "new title2",
	"desc": "some description2",
	"image": "some url"
}
```

# Endpoints

- GET /
- GET /cakes
- PUT /cakes 


