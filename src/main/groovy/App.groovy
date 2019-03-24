package kitchen.dark.groovy.web

import io.javalin.Javalin

class App {
    static void main(String... args) {
        def app = Javalin.create()
                .disableStartupBanner()
                .contextPath(System.getenv('CONTEXT_ROOT') ?: '/')
                .disableDynamicGzip()
        app.get("/", { ctx -> ctx.json([payload: 'Hello.']) })

        def port = System.getenv('PORT') ?: 8888
        app.start(port as Integer)
    }
}
