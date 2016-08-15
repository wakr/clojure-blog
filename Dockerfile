FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/personal-blog.jar /personal-blog/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/personal-blog/app.jar"]
