plugins {
    kotlin("jvm") version "1.7.20"
}

group = "ru.geracimov.otus.algo.hw06-simple-sort"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}