FROM postgres:10.9-alpine
LABEL maintainer="martinhuacho@hotmail.com"
ENV POSTGRES_PASSWORD=123
ENV POSTGRES_DB=sisacse
ENV POSTGRES_USER=postgres
EXPOSE 5432
#COPY ./scripts/ /docker-entrypoint-initdb.d/
CMD ["postgres"]
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar cineapp-backend.jar