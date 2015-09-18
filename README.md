# Dropwizard REST back-end for website.

# Start server command
java -jar target/dropwizard-1.0.jar server dropwizard.yml

# Rest API per domain
    GET     /dev/clear                          (be.skdebrug.website.controller.DevController)
    GET     /dev/fill                           (be.skdebrug.website.controller.DevController)
    GET     /league                             (be.skdebrug.website.controller.LeagueController)
    DELETE  /game                               (be.skdebrug.website.controller.GameController)
    DELETE  /game/{gameId}                      (be.skdebrug.website.controller.GameController)
    GET     /game                               (be.skdebrug.website.controller.GameController)
    GET     /game/next/{amount}/team/{teamid}   (be.skdebrug.website.controller.GameController)
    GET     /game/prev/{amount}/team/{teamid}   (be.skdebrug.website.controller.GameController)
    GET     /game/{gameId}                      (be.skdebrug.website.controller.GameController)
    POST    /game                               (be.skdebrug.website.controller.GameController)
    PUT     /game                               (be.skdebrug.website.controller.GameController)
    DELETE  /news                               (be.skdebrug.website.controller.NewsController)
    DELETE  /news/{newsId}                      (be.skdebrug.website.controller.NewsController)
    GET     /news                               (be.skdebrug.website.controller.NewsController)
    GET     /news/{newsId}                      (be.skdebrug.website.controller.NewsController)
    POST    /news                               (be.skdebrug.website.controller.NewsController)
    PUT     /news                               (be.skdebrug.website.controller.NewsController)
    DELETE  /player                             (be.skdebrug.website.controller.PlayerController)
    DELETE  /player/{playerId}                  (be.skdebrug.website.controller.PlayerController)
    GET     /player                             (be.skdebrug.website.controller.PlayerController)
    GET     /player/{playerId}                  (be.skdebrug.website.controller.PlayerController)
    POST    /player                             (be.skdebrug.website.controller.PlayerController)
    PUT     /player                             (be.skdebrug.website.controller.PlayerController)
    DELETE  /team                               (be.skdebrug.website.controller.TeamController)
    DELETE  /team/{teamId}                      (be.skdebrug.website.controller.TeamController)
    GET     /team                               (be.skdebrug.website.controller.TeamController)
    GET     /team/{teamId}                      (be.skdebrug.website.controller.TeamController)
    POST    /team                               (be.skdebrug.website.controller.TeamController)
    PUT     /team                               (be.skdebrug.website.controller.TeamController)


