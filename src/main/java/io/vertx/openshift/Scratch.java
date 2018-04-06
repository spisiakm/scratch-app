package io.vertx.openshift;

import io.vertx.core.AbstractVerticle;

import io.vertx.core.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Martin Spisiak (mspisiak@redhat.com) on 05/04/18.
 */
public class Scratch extends AbstractVerticle {

  final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

  @Override
  public void start(Future<Void> fut) {
    logger.error("test");
    vertx
        .createHttpServer()
        .requestHandler(r ->
            r.response().end("Greetings!"))
        .listen(8080, result -> {
          if (result.succeeded()) {
            logger.info("COOL!");
            fut.complete();
          } else {
            fut.fail(result.cause());
          }
        });
  }

}
