plugins {
    kotlin("multiplatform") version "2.0.20"
    id("com.vanniktech.maven.publish") version "0.30.0"
}

group = "io.github.pehoeji"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js {
        browser()
        nodejs()
    }
    macosX64()
    macosArm64()
    iosX64()
    iosSimulatorArm64()
    iosArm64()
    linuxX64()

    sourceSets {
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    coordinates(
        groupId = "io.github.pehoeji",
        artifactId = "konvert-legacy-poj",
        version = version.toString()
    )

    pom {
        name.set("KonvertLegacyPOJ")
        description.set("Kotlin Multiplatform library for converting legacy POJ (Peh-ōe-jī) encoded text to Unicode")
        url.set("https://github.com/Pehoeji/KonvertLegacyPOJ")

        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/licenses/MIT")
                distribution.set("repo")
            }
        }

        developers {
            developer {
                id.set("pehoeji")
                name.set("Pehoeji")
                url.set("https://github.com/Pehoeji")
            }
        }

        scm {
            url.set("https://github.com/Pehoeji/KonvertLegacyPOJ")
            connection.set("scm:git:git://github.com/Pehoeji/KonvertLegacyPOJ.git")
            developerConnection.set("scm:git:ssh://git@github.com/Pehoeji/KonvertLegacyPOJ.git")
        }
    }
}
