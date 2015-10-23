package be.skdebrug.website.controller;

import be.skdebrug.website.core.*;
import be.skdebrug.website.service.GameService;
import be.skdebrug.website.service.NewsService;
import be.skdebrug.website.service.PlayerService;
import be.skdebrug.website.service.TeamService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
@Path("/dev")
@Produces(MediaType.APPLICATION_JSON)
public class DevController {

    private final static Logger LOG = Logger.getLogger(DevController.class);

    @Inject
    protected TeamService teamService;
    @Inject
    protected GameService gameService;
    @Inject
    protected NewsService newsService;
    @Inject
    protected PlayerService playerService;

    @GET
    @Timed
    @Path("/clear")
    public boolean clear() {
        LOG.debug("@GET /dev/clear delete all information from the database");
        newsService.deleteAll();
        gameService.deleteAll();
        teamService.deleteAll();
        playerService.deleteAll();
        return true;
    }

    @GET
    @Timed
    @Path("/fill")
    public boolean fill() {
        LOG.debug("@GET /dev/fill");
        newsService.deleteAll();
        gameService.deleteAll();
        teamService.deleteAll();
        playerService.deleteAll();
        fillNews();
        fillPlayers();
        fillGamesAndTeams();
        return true;
    }

    private void fillPlayers() {
        fillPlayer("Gunther", "Dillen", 1, PlayerType.GOALKEEPER);
        fillPlayer("Frederik", "Verbogen", 2, PlayerType.DEFENDER);
        fillPlayer("Ben", "Oeyen", 3, PlayerType.DEFENDER);
        fillPlayer("Glenn", "Gersis", 4, PlayerType.DEFENDER);
        fillPlayer("Robin", "Van Rompaey", 5,PlayerType.MIDFIELDER);
        fillPlayer("Maarten", "Mennes", 6,PlayerType.DEFENDER);
        fillPlayer("David", "Vanderhaeghen", 7,PlayerType.MIDFIELDER);
        fillPlayer("Arne", "Vergauwen", 8,PlayerType.MIDFIELDER);
        fillPlayer("Stefan", "Lauwers", 9,PlayerType.MIDFIELDER);
        fillPlayer("Stijn", "De Mayer", 10, PlayerType.MIDFIELDER);
        fillPlayer("Mathijs", "Bettens", 11, PlayerType.STRIKER);
        fillPlayer("Steven", "Heirbaut", 12, PlayerType.DEFENDER);
        fillPlayer("Mikka", "Uten", 13, PlayerType.STRIKER);
        fillPlayer("Nick", "Vandeperre", 14, PlayerType.STRIKER);
        fillPlayer("Simon", "Bettens", 16, PlayerType.MIDFIELDER);
        fillPlayer("Thijs", "Dillen", 17, PlayerType.MIDFIELDER);
        fillPlayer("Johan", "Offeciers", 18, PlayerType.DEFENDER);
        fillPlayer("Benjamin", "Berckmoes", 19, PlayerType.MIDFIELDER);
        fillPlayer("Renze", "De Locht", 20, PlayerType.DEFENDER);
    }

    private void fillPlayer(String firstName, String lastName, int number, PlayerType playerType) {
        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName(lastName);
        player.setNumber(number);
        player.setPlayerType(playerType);
        player.setDateOfBirth(DateTime.now());
        playerService.create(player);
    }

    private void fillNews() {
        fillNewsItem("Weekend Extravaganza", "Het is akelig windstil geweest rond de nieuwe editie van het befaamde spelersweekend dat met rasse schreden nadert. Nog één keer voetballen en het is zo ver: vrijdag 30 oktober geven we de aftrap voor de tweede jaargang. Achter de schermen zijn enkele bestuursleden naarstig op zoek geweest naar een geschikte locatie die beantwoordt aan de hoge kwaliteitseisen die onze vereniging stelt. En we menen dat we toch weer een leuke plek op de kop hebben kunnen tikken. Eén nijpende kwestie moet nog opgelost worden, maar het bestuur gaat er van uit dat we ook die horde zullen kunnen nemen. Om het mysterie nog wat aan te dikken: we zullen dit jaar de landsgrenzen verlaten, maar méér willen we voorlopig niet kwijt. Onze cérémonie protocolaire vindt plaats in het weekend van Allerzielen en dat houdt meer dan ooit in 'hoe meer zielen, hoe meer vreugd'.");
        fillNewsItem("Erkenning als Antwerpse sportvereniging", "Eerst en vooral gefeliciteerd met de nieuwe erkenning als Antwerpse sportvereniging die uw vereniging behaalde.\n" +
                "Uw sportvereniging heeft hiermee aangetoond actief te willen werken aan een veilige sportomgeving, zowel voor haar bestuurders, haar vrijwilligers als voor haar leden.\n" +
                " \n" +
                "Tevens bezorgen wij u ook de engagementsverklaring waarmee u kenbaar kan maken waartoe u zich als vereniging engageert inzake veiligheid.\n" +
                "Wij vragen u om de engagementsverklaring op een actieve manier kenbaar te maken onder alle leden van de vereniging, bv door ophanging in het clublokaal, duidelijk zichtbaar op de website, een keer extra aandacht aan besteden in een nieuwsbrief.");
    }

    private void fillNewsItem(String title, String content) {
        News news = new News();
        news.setDate(new DateTime());
        news.setTitle(title);
        news.setContent(content);
        newsService.create(news);
    }


    private Team fillTeam(String teamName) {
        Team team = new Team();
        team.setName(teamName);
        teamService.create(team);
        return teamService.get(teamName);
    }


    private void fillGame(DateTime dateTime, Team homeTeam, Team awayTeam) {
        Game game = new Game();
        game.setGameType(GameType.LEAGUE);
        game.setDate(dateTime);
        game.setHomeTeam(homeTeam);
        game.setAwayTeam(awayTeam);
        gameService.create(game);
    }

    private void fillGamesAndTeams(){
        Team SKDeBrug = fillTeam("SK De Brug");
        Team DeurneseTurners = fillTeam("Deurnese Turners B");
        Team KFCBrabo = fillTeam("KFC Brabo");
        Team Vidam = fillTeam("Vidam");
        Team PSK = fillTeam("P.S.K.");
        Team Amber = fillTeam("Amber E");
        Team Toreke = fillTeam("Toreke");
        Team TCBrabo = fillTeam("TC Brabo");
        Team Houtbeurs = fillTeam("Houtbeurs");
        Team NonkelJan = fillTeam("Nonkel Jan");
        Team Umicore = fillTeam("Umicore");
        Team ACDeHeide = fillTeam("AC De Heide");

        //Speeldag 1
        fillGame(new DateTime(2015,9,19,15,0), DeurneseTurners, KFCBrabo);
        fillGame(new DateTime(2015,9,19,14,30), Vidam, PSK);
        fillGame(new DateTime(2015,9,19,15,30), Amber, Toreke);
        fillGame(new DateTime(2015,9,19,15,0), TCBrabo, Houtbeurs);
        fillGame(new DateTime(2015,9,19,15,0), NonkelJan, Umicore);
        fillGame(new DateTime(2015,9,19,15,0), ACDeHeide, SKDeBrug);

        //Speeldag 2
        fillGame(new DateTime(2015,9,26,15,0), SKDeBrug, DeurneseTurners);
        fillGame(new DateTime(2015,9,26,13,0), PSK, Amber);
        fillGame(new DateTime(2015,9,26,15,0), KFCBrabo, NonkelJan);
        fillGame(new DateTime(2015,9,26,15,30), Houtbeurs, Vidam);
        fillGame(new DateTime(2015,9,26,15,0), Umicore, TCBrabo);
        fillGame(new DateTime(2015,9,26,13,0), Toreke, ACDeHeide);

        //Speeldag 3
        fillGame(new DateTime(2015,10,3,15,0), DeurneseTurners, Umicore);
        fillGame(new DateTime(2015,10,3,15,0), TCBrabo, PSK);
        fillGame(new DateTime(2015,10,3,15,0), NonkelJan, Amber);
        fillGame(new DateTime(2015,10,3,15,0), KFCBrabo, SKDeBrug);
        fillGame(new DateTime(2015,10,3,15,0), ACDeHeide, Houtbeurs);
        fillGame(new DateTime(2015,10,3,14,30), Vidam, Toreke);

        //Speeldag 4
        fillGame(new DateTime(2015,10,10,15,0), ACDeHeide, DeurneseTurners);
        fillGame(new DateTime(2015,10,10,15,0), PSK, NonkelJan);
        fillGame(new DateTime(2015,10,10,15,0), Amber, Vidam);
        fillGame(new DateTime(2015,10,10,15,0), Houtbeurs, KFCBrabo);
        fillGame(new DateTime(2015,10,10,15,0), Toreke, TCBrabo);
        fillGame(new DateTime(2015,10,10,15,0), SKDeBrug, Umicore);

        //Speeldag 5
        fillGame(new DateTime(2015,10,17,15,0), DeurneseTurners, Toreke);
        fillGame(new DateTime(2015,10,17,15,0), Umicore, PSK);
        fillGame(new DateTime(2015,10,17,15,0), KFCBrabo, Amber);
        fillGame(new DateTime(2015,10,17,15,0), NonkelJan, Houtbeurs);
        fillGame(new DateTime(2015,10,17,15,0), TCBrabo, ACDeHeide);
        fillGame(new DateTime(2015,10,17,14,30), Vidam, SKDeBrug);

        //Speeldag 6
        fillGame(new DateTime(2015,10,24,15,30), Houtbeurs, DeurneseTurners);
        fillGame(new DateTime(2015,10,24,13,0), PSK, SKDeBrug);
        fillGame(new DateTime(2015,10,24,15,30), Amber, Umicore);
        fillGame(new DateTime(2015,10,24,14,30), Vidam, TCBrabo);
        fillGame(new DateTime(2015,10,24,15,0), ACDeHeide, NonkelJan);
        fillGame(new DateTime(2015,10,24,13,0), Toreke, KFCBrabo);

        //Speeldag 7
        fillGame(new DateTime(2015,11,7,15,0), DeurneseTurners, PSK);
        fillGame(new DateTime(2015,11,7,15,0), TCBrabo, Amber);
        fillGame(new DateTime(2015,11,7,15,0), KFCBrabo, ACDeHeide);
        fillGame(new DateTime(2015,11,7,15,0), SKDeBrug, Houtbeurs);
        fillGame(new DateTime(2015,11,7,15,0), Umicore, Vidam);
        fillGame(new DateTime(2015,11,7,15,0), NonkelJan, Toreke);

        //Speeldag 8
        fillGame(new DateTime(2015,11,14,15,0), Amber, DeurneseTurners);
        fillGame(new DateTime(2015,11,14,13,0), PSK, Houtbeurs);
        fillGame(new DateTime(2015,11,14,15,0), Umicore, KFCBrabo);
        fillGame(new DateTime(2015,11,14,15,0), TCBrabo, NonkelJan);
        fillGame(new DateTime(2015,11,14,14,30), Vidam, ACDeHeide);
        fillGame(new DateTime(2015,11,14,13,0), Toreke, SKDeBrug);

        //Speeldag 9
        fillGame(new DateTime(2015,11,21,15,0), DeurneseTurners, TCBrabo);
        fillGame(new DateTime(2015,11,21,15,0), KFCBrabo, PSK);
        fillGame(new DateTime(2015,11,21,15,0), SKDeBrug, Amber);
        fillGame(new DateTime(2015,11,21,15,0), Houtbeurs, Toreke);
        fillGame(new DateTime(2015,11,21,15,0), ACDeHeide, Umicore);
        fillGame(new DateTime(2015,11,21,15,0), NonkelJan, Vidam);

        //Speeldag 10
        fillGame(new DateTime(2015,11,28,15,0), NonkelJan, DeurneseTurners);
        fillGame(new DateTime(2015,11,28,13,0), PSK, ACDeHeide);
        fillGame(new DateTime(2015,11,28,15,0), Amber, Houtbeurs);
        fillGame(new DateTime(2015,11,28,14,30), Vidam, KFCBrabo);
        fillGame(new DateTime(2015,11,28,15,0), TCBrabo, SKDeBrug);
        fillGame(new DateTime(2015,11,28,15,0), Umicore, Toreke);

        //Speeldag 11
        fillGame(new DateTime(2015,12,5,15,0), DeurneseTurners, Vidam);
        fillGame(new DateTime(2015,12,5,13,0), Toreke, PSK);
        fillGame(new DateTime(2015,12,5,15,0), ACDeHeide, Amber);
        fillGame(new DateTime(2015,12,5,15,0), KFCBrabo, TCBrabo);
        fillGame(new DateTime(2015,12,5,15,0), Houtbeurs, Umicore);
        fillGame(new DateTime(2015,12,5,15,0), SKDeBrug, NonkelJan);

        //Speeldag 12
        fillGame(new DateTime(2015,12,12,15,0), KFCBrabo, DeurneseTurners);
        fillGame(new DateTime(2015,12,12,13,0), PSK, Vidam);
        fillGame(new DateTime(2015,12,12,13,0), Toreke, Amber);
        fillGame(new DateTime(2015,12,12,15,0), Houtbeurs, TCBrabo);
        fillGame(new DateTime(2015,12,12,15,0), Umicore, NonkelJan);
        fillGame(new DateTime(2015,12,12,15,0), SKDeBrug, ACDeHeide);

        //Speeldag 13
        fillGame(new DateTime(2015,12,19,15,0), DeurneseTurners, SKDeBrug);
        fillGame(new DateTime(2015,12,19,15,0), Amber, PSK);
        fillGame(new DateTime(2015,12,19,15,0), NonkelJan, KFCBrabo);
        fillGame(new DateTime(2015,12,19,14,30), Vidam, Houtbeurs);
        fillGame(new DateTime(2015,12,19,15,0), TCBrabo, Umicore);
        fillGame(new DateTime(2015,12,19,15,0), ACDeHeide, Toreke);

        //Speeldag 14
        fillGame(new DateTime(2015,1,9,15,0), Umicore, DeurneseTurners);
        fillGame(new DateTime(2015,1,9,13,0), PSK, TCBrabo);
        fillGame(new DateTime(2015,1,9,15,0), Amber, NonkelJan);
        fillGame(new DateTime(2015,1,9,15,0), SKDeBrug, KFCBrabo);
        fillGame(new DateTime(2015,1,9,15,0), Houtbeurs, ACDeHeide);
        fillGame(new DateTime(2015,1,9,13,0), Toreke, Vidam);

        //Speeldag 15
        fillGame(new DateTime(2015,1,16,15,0), DeurneseTurners, ACDeHeide);
        fillGame(new DateTime(2015,1,16,15,0), NonkelJan, PSK);
        fillGame(new DateTime(2015,1,16,15,0), Vidam, Amber);
        fillGame(new DateTime(2015,1,16,15,0), KFCBrabo, Houtbeurs);
        fillGame(new DateTime(2015,1,16,15,0), TCBrabo, Toreke);
        fillGame(new DateTime(2015,1,16,15,0), Umicore, SKDeBrug);

        //Speeldag 16
        fillGame(new DateTime(2015,1,23,13,0), Toreke, DeurneseTurners);
        fillGame(new DateTime(2015,1,23,13,0), PSK, Umicore);
        fillGame(new DateTime(2015,1,23,15,30), Amber, KFCBrabo);
        fillGame(new DateTime(2015,1,23,15,30), Houtbeurs, NonkelJan);
        fillGame(new DateTime(2015,1,23,15,0), ACDeHeide, TCBrabo);
        fillGame(new DateTime(2015,1,23,15,0), SKDeBrug, Vidam);

        //Speeldag 17
        fillGame(new DateTime(2015,1,30,15,0), DeurneseTurners, Houtbeurs);
        fillGame(new DateTime(2015,1,30,15,0), SKDeBrug, PSK);
        fillGame(new DateTime(2015,1,30,15,0), Umicore, Amber);
        fillGame(new DateTime(2015,1,30,15,0), TCBrabo, Vidam);
        fillGame(new DateTime(2015,1,30,15,0), NonkelJan, ACDeHeide);
        fillGame(new DateTime(2015,1,30,15,0), KFCBrabo, Toreke);

        //Speeldag 18
        fillGame(new DateTime(2015,2,20,13,0), PSK, DeurneseTurners);
        fillGame(new DateTime(2015,2,20,15,30), Amber, TCBrabo);
        fillGame(new DateTime(2015,2,20,15,0), ACDeHeide, KFCBrabo);
        fillGame(new DateTime(2015,2,20,15,30), Houtbeurs, SKDeBrug);
        fillGame(new DateTime(2015,2,20,14,30), Vidam, Umicore);
        fillGame(new DateTime(2015,2,20,13,0), Toreke, NonkelJan);

        //Speeldag 19
        fillGame(new DateTime(2015,2,27,15,0), DeurneseTurners, Amber);
        fillGame(new DateTime(2015,2,27,15,30), Houtbeurs, PSK);
        fillGame(new DateTime(2015,2,27,15,0), KFCBrabo, Umicore);
        fillGame(new DateTime(2015,2,27,15,0), NonkelJan, TCBrabo);
        fillGame(new DateTime(2015,2,27,15,0), ACDeHeide, Vidam);
        fillGame(new DateTime(2015,2,27,15,0), SKDeBrug, Toreke);

        //Speeldag 20
        fillGame(new DateTime(2015,3,5,15,0), TCBrabo, DeurneseTurners);
        fillGame(new DateTime(2015,3,5,3,0), PSK, KFCBrabo);
        fillGame(new DateTime(2015,3,5,15,0), Amber, SKDeBrug);
        fillGame(new DateTime(2015,3,5,15,0), Toreke, Houtbeurs);
        fillGame(new DateTime(2015,3,5,15,0), Umicore, ACDeHeide);
        fillGame(new DateTime(2015,3,5,15,0), Vidam, NonkelJan);

        //Speeldag 21
        fillGame(new DateTime(2015,3,12,15,0), DeurneseTurners, NonkelJan);
        fillGame(new DateTime(2015,3,12,15,0), ACDeHeide, PSK);
        fillGame(new DateTime(2015,3,12,15,30), Houtbeurs, Amber);
        fillGame(new DateTime(2015,3,12,15,0), KFCBrabo, Vidam);
        fillGame(new DateTime(2015,3,12,15,0), SKDeBrug, TCBrabo);
        fillGame(new DateTime(2015,3,12,13,0), Toreke, Umicore);

        //Speeldag 22
        fillGame(new DateTime(2015,3,19,15,0), Vidam, DeurneseTurners);
        fillGame(new DateTime(2015,3,19,15,0), PSK, Toreke);
        fillGame(new DateTime(2015,3,19,15,0), Amber, ACDeHeide);
        fillGame(new DateTime(2015,3,19,15,0), TCBrabo, KFCBrabo);
        fillGame(new DateTime(2015,3,19,15,0), Umicore, Houtbeurs);
        fillGame(new DateTime(2015,3,19,15,0), NonkelJan, SKDeBrug);
    }
}















































