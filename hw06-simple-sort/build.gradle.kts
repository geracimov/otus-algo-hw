plugins {
    kotlin("jvm") version "1.7.20"
}

group = "ru.geracimov.otus.algo.hw06-simple-sort"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.20")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.2")
    testImplementation("com.willowtreeapps.assertk:assertk-jvm:0.25")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}