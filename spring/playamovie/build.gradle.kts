plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.luisjaramillo"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	gradlePluginPortal()
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	runtimeOnly("org.postgresql:postgresql")

	// LangChain4j
	implementation("dev.langchain4j:langchain4j-open-ai-spring-boot-starter:1.0.0-beta1")
	implementation("dev.langchain4j:langchain4j-spring-boot-starter:1.0.0-beta1")

	// Mapstruct
	implementation ("org.mapstruct:mapstruct:1.6.3")
	annotationProcessor ("org.mapstruct:mapstruct-processor:1.6.3")
    // Validator
    implementation ("org.springframework.boot:spring-boot-starter-validation")

}

tasks.withType<Test> {
	useJUnitPlatform()
}
