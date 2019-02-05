rootProject.name = "Reversi"

include("scope-java")
includeIfExists(projectName = "tp-display-quote-v3-java")

fun includeIfExists(projectName: String) {
    if (file(projectName).exists()) {
        include(projectName)
    }
}
