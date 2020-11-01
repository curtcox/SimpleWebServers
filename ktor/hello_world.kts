#!/usr/bin/env kscript

/*Here I am specifying KTor dependency like gradle-style locators */
@file:MavenRepository("bintray-ktor","https://dl.bintray.com/kotlin/ktor")
@file:MavenRepository("kotlinx","https://dl.bintray.com/kotlin/kotlinx")
@file:DependsOnMaven("io.ktor:ktor-server-netty:0.9.4")

import java.util.*
println("Belllloooo!!")
//Rest of the code below
