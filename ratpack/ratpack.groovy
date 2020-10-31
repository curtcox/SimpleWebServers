@Grapes([
  @Grab('io.ratpack:ratpack-groovy:1.8.0'),
  @Grab('org.slf4j:slf4j-simple:1.7.30')
])
import static ratpack.groovy.Groovy.ratpack

ratpack {
    handlers {
        get {
            render "Hello World!"
        }
        get(":name") {
            render "Hello $pathTokens.name!"
        }
    }
}
