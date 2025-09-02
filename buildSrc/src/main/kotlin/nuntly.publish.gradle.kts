plugins {
    `maven-publish`
    signing
}

configure<PublishingExtension> {
    publications {
        register<MavenPublication>("maven") {
            from(components["java"])

            pom {
                name.set("Nuntly REST API")
                description.set("An OpenAPI 3.1 definition for the Nuntly REST API")
                url.set("http://developers.nuntly.com")

                licenses {
                    license {
                        name.set("Apache-2.0")
                    }
                }

                developers {
                    developer {
                        name.set("Nuntly")
                        email.set("developers@nuntly.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/stainless-sdks/nuntly-java.git")
                    developerConnection.set("scm:git:git://github.com/stainless-sdks/nuntly-java.git")
                    url.set("https://github.com/stainless-sdks/nuntly-java")
                }

                versionMapping {
                    allVariants {
                        fromResolutionResult()
                    }
                }
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("GPG_SIGNING_KEY_ID")?.ifBlank { null }
    val signingKey = System.getenv("GPG_SIGNING_KEY")?.ifBlank { null }
    val signingPassword = System.getenv("GPG_SIGNING_PASSWORD")?.ifBlank { null }
    if (signingKey != null && signingPassword != null) {
        useInMemoryPgpKeys(
            signingKeyId,
            signingKey,
            signingPassword,
        )
        sign(publishing.publications["maven"])
    }
}

tasks.named("publish") {
    dependsOn(":closeAndReleaseSonatypeStagingRepository")
}
