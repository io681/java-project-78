plugins {
    id("java")
    id("checkstyle")
    application
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

application { mainClass.set("hexlet.code.App") }

tasks.compileJava {
    options.release = 20
}

tasks.jacocoTestReport { reports { xml.required.set(true) } }