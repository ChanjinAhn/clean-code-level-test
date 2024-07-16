import com.github.gradle.node.npm.task.NpmTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.1.0"

    id("org.jetbrains.kotlin.jvm") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.spring") version "1.6.10"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.6.10"
    id("org.jetbrains.kotlin.kapt") version "1.6.10"

    id("com.github.node-gradle.node") version "4.0.0"

    idea
}

group = "io.olkkani"
//version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spring.io/release")
    }
    maven {
        url = uri("https://repository.jboss.org/maven2")
    }
}
configurations {
    all {
        // was tomcat 제외
        exclude(module = "spring-boot-starter-tomcat")
        // not necessary test lib delete
        exclude(module = "org.hamcrest")
    }
}
allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}
dependencies {
    // kotlin
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect")
//	implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    // common
    implementation("org.apache.commons:commons-text:1.10.0")
    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("commons-io:commons-io:2.11.0")
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.5")
    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    // was
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    // database, jdbc
    runtimeOnly("com.h2database:h2:2.1.214")
    testRuntimeOnly("com.h2database:h2:2.1.214")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // QueryDSL
    implementation("com.querydsl:querydsl-jpa:5.0.0")
    implementation("com.querydsl:querydsl-apt:5.0.0")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("javax.persistence:javax.persistence-api:2.2")
    annotationProcessor(group = "com.querydsl", name = "querydsl-apt", classifier = "jpa")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    // view template
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:3.2.0")
    // test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.ninja-squad:springmockk:4.0.0")

    kapt("org.springframework.boot:spring-boot-configuration-processor")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
    enabled = false
}

// Kotlin QClass Setting
kotlin.sourceSets.main {
    println("kotlin sourceSets builDir:: $buildDir")
    setBuildDir("$buildDir")
}

// legacy Kotlin QClass Setting (deprecated gradle version 7.x)
//sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class){
//	kotlin.srcDir("$buildDir/generated/source/kapt/main")
//}

// querydsl 추가
idea {
    module {
        val kaptMain = file("build/generated/source/kapt/main")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}


// npm 설정
node {
    version.set("18.17.1")
    npmVersion.set("9.6.7")
    download.set(true)
    nodeProjectDir.set(file("${project.projectDir}/src/main/resources/static"))
}

//val installDependencies by tasks.registering(NpmTask::class) {
//	setArgs(listOf("install"))
//	setExecOverrides(closureOf<ExecSpec> {
//		setWorkingDir("${project.projectDir}/front")
//	})
//}
//val buildReactTask by tasks.registering(NpmTask::class) {
//	 Before buildWeb can run, installDependencies must run
//	dependsOn(installDependencies)
//	setArgs(listOf("run", "build"))
//	setExecOverrides(closureOf<ExecSpec> {
//		setWorkingDir("${project.projectDir}/front")
//	})
//}
val copyTask by tasks.registering(Copy::class) {
    from(file("${project.projectDir}/front/build"))
    into(file("${project.buildDir}/resources/main/static"))
}

tasks.bootJar {
    dependsOn(copyTask)
}