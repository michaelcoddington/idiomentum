
import org.apache.commons.configuration.BaseConfiguration
import org.apache.tinkerpop.gremlin.orientdb.OrientGraph
import org.apache.tinkerpop.gremlin.process.traversal.P.gt

object Test2 {
}

fun main(args: Array<String>) {
    val config = BaseConfiguration()
    config.setProperty("orient-url","remote:localhost/test-1")
    config.setProperty("orient-user", "root")
    config.setProperty("orient-password", "admin")
    val graph = OrientGraph.open(config)

    println(graph)
    val g = graph.traversal()
    g.V()
        .has("assetType", "Cover")
        .outE("HAS_VERSION")
        .inV()
        .has("assetVersion", gt(1))
        .forEach { println(it) }
    println(g)

    graph.close()
}