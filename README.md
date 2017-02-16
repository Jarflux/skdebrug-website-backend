# Dropwizard REST back-end for website.

# Start server command
java -jar target/dropwizard-1.24.jar server dropwizard.yml

# Rest API per domain
    GET     /private/clear (be.skdebrug.website.controller.DevController)
    GET     /private/fill (be.skdebrug.website.controller.DevController)

    GET     /email (be.skdebrug.website.controller.EmailController)
    POST    /email (be.skdebrug.website.controller.EmailController)

    GET     /league/ (be.skdebrug.website.controller.LeagueController)

    DELETE  /private/player (be.skdebrug.website.controller.PlayerController)
    DELETE  /private/player/{playerId} (be.skdebrug.website.controller.PlayerController)
    GET     /player (be.skdebrug.website.controller.PlayerController)
    GET     /player/type (be.skdebrug.website.controller.PlayerController)
    GET     /player/{playerId} (be.skdebrug.website.controller.PlayerController)
    POST    /private/player (be.skdebrug.website.controller.PlayerController)
    PUT     /private/player (be.skdebrug.website.controller.PlayerController)

    DELETE  /private/game (be.skdebrug.website.controller.GameController)
    DELETE  /private/game/{gameId} (be.skdebrug.website.controller.GameController)
    GET     /game (be.skdebrug.website.controller.GameController)
    GET     /game/next/{amount}/team/{teamid} (be.skdebrug.website.controller.GameController)
    GET     /game/prev/{amount}/team/{teamid} (be.skdebrug.website.controller.GameController)
    GET     /game/{gameId} (be.skdebrug.website.controller.GameController)
    GET     /private/game (be.skdebrug.website.controller.GameController)
    POST    /private/game (be.skdebrug.website.controller.GameController)
    PUT     /private/game (be.skdebrug.website.controller.GameController)

    DELETE  /private/news (be.skdebrug.website.controller.NewsController)
    DELETE  /private/news/{newsId} (be.skdebrug.website.controller.NewsController)
    GET     /news (be.skdebrug.website.controller.NewsController)
    GET     /news/{newsId} (be.skdebrug.website.controller.NewsController)
    POST    /private/news (be.skdebrug.website.controller.NewsController)
    PUT     /private/news (be.skdebrug.website.controller.NewsController)

    DELETE  /private/team (be.skdebrug.website.controller.TeamController)
    DELETE  /private/team/{teamId} (be.skdebrug.website.controller.TeamController)
    GET     /team (be.skdebrug.website.controller.TeamController)
    GET     /team/{teamId} (be.skdebrug.website.controller.TeamController)
    POST    /private/team (be.skdebrug.website.controller.TeamController)
    PUT     /private/team (be.skdebrug.website.controller.TeamController)

    POST    /reservation (be.skdebrug.website.controller.EmailController)
    POST    /registration (be.skdebrug.website.controller.EmailController)
