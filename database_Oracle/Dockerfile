FROM oracle/database:11.2.0.2-xe
LABEL maintainer="martinhuacho@hotmail.com"
ENV ORACLE_PWD=password
ENV POSTGRES_DB=cineapp
ENV POSTGRES_USER=postgres
EXPOSE 8080
EXPOSE 1521
#COPY ./images/ /docker-entrypoint-initdb.d/
COPY ./scripts/ /docker-entrypoint-initdb.d/
CMD ["postgres"]
#insert into public.comida values (1,pg_read_binary_file('gaseosa.jpeg'),'nombre',5);
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar cineapp-backend.jar