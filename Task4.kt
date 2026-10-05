package edu.iau.cshj.csc402.lab2

fun describeTeam(teamName: String?): String {
    return teamName?.let { "Team: $it (${it.length} characters)" } ?: "Team not registered yet"
}

fun getNickname(): String? = null

fun task4() {
    val nickname: String? = getNickname()
    val fullName = "Abdullah Al-Qahtani"

    println(fullName.length)
    println(nickname?.length)

    println(nickname ?: "no nickname set")

    println(describeTeam("Team Falcon"))
    println(describeTeam(null))

    // println(nickname!!)
}

fun main() {
    task4()
}