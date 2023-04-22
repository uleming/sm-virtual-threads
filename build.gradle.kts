plugins {
    id("java")
    id("org.springframework.boot") version "3.0.6"
}

group = "org.example"
version = "1.0-SNAPSHOT"

apply(plugin = "io.spring.dependency-management")

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
tasks.withType<JavaCompile>{
    options.compilerArgs.add("--enable-preview")
}
tasks.withType<JavaExec> {
    jvmArgs("--enable-preview")
    args("--enable-preview")
}