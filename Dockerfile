FROM postgres:14-alpine
LABEL maintainer="Saifutdiyarov_Askar"
COPY build/libs/learning-course.jar ./
WORKDIR /opt/learning-course
RUN java -jar accounting-self.jar extract