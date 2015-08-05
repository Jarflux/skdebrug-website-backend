package be.skdebrug.website.controller;

import be.skdebrug.website.core.Game;
import be.skdebrug.website.core.GameType;
import be.skdebrug.website.core.News;
import be.skdebrug.website.core.Team;
import be.skdebrug.website.service.GameService;
import be.skdebrug.website.service.NewsService;
import be.skdebrug.website.service.TeamService;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Developer: Ben Oeyen
 * Date: 23/07/15
 */
@Path("/dev")
@Produces(MediaType.APPLICATION_JSON)
public class DevController {

    private final static Logger LOG = Logger.getLogger(DevController.class);

    @Inject
    private TeamService teamService;
    @Inject
    private GameService gameService;
    @Inject
    private NewsService newsService;

    @GET
    @Timed
    @Path("/fill")
    public void get() {
        LOG.debug("@GET /dev/fill get news with id");
        newsService.deleteAll();
        gameService.deleteAll();
        teamService.deleteAll();
        fillTeams();
        fillNews();
        fillGames();
    }

    private void fillGames() {
        fillGameDay(DateTime.now());
        fillGameDay(DateTime.now().plusWeeks(1));
        fillGameDay(DateTime.now().plusWeeks(2));
        fillGameDay(DateTime.now().plusWeeks(3));
        fillGameDay(DateTime.now().plusWeeks(4));
        fillGameDay(DateTime.now().plusWeeks(5));
        fillGameDay(DateTime.now().plusWeeks(6));
        fillGameDay(DateTime.now().plusWeeks(7));
        fillGameDay(DateTime.now().plusWeeks(8));
    }

    private void fillGameDay(DateTime dateTime) {
        List<Integer> teamNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
        Collections.shuffle(teamNumbers);
        fillGame(dateTime, teamNumbers.get(0), teamNumbers.get(8));
        fillGame(dateTime, teamNumbers.get(1), teamNumbers.get(9));
        fillGame(dateTime, teamNumbers.get(2), teamNumbers.get(10));
        fillGame(dateTime, teamNumbers.get(3), teamNumbers.get(11));
        fillGame(dateTime, teamNumbers.get(4), teamNumbers.get(12));
        fillGame(dateTime, teamNumbers.get(5), teamNumbers.get(13));
        fillGame(dateTime, teamNumbers.get(6), teamNumbers.get(14));
        fillGame(dateTime, teamNumbers.get(7), teamNumbers.get(15));
    }

    private void fillGame(DateTime dateTime, Integer homeTeamId, Integer awayTeamId) {
        Game game = new Game();
        game.setGameType(GameType.LEAGUE);
        game.setDateStart(dateTime);
        game.setHomeTeam(teamService.get(homeTeamId));
        game.setAwayTeam(teamService.get(awayTeamId));
        gameService.create(game);
    }


    private void fillNews() {
        fillNewsItem("Franse Supercup is een prooi voor PSG", "De Franse Supercup gaat voor het derde jaar op een rij naar Paris Saint-Germain. Het sterrenensemble van Laurent Blanc kende geen al te zware avond tegen Olympique Lyon en won gemakkelijk met 2-0. De wedstrijd werd gespeeld in Montreal in Canada.\n" +
                "PSG pakte vorig jaar alle prijzen in Frankrijk en dus waren de hoofdstedelingen ook vanavond torenhoog favoriet.\n" +
                "\n" +
                "\n" +
                "Die favorietenrol maakte het ook direct waar. Na amper een kwartier spelen stond het al 0-2. Aurier opende de score met een knappe kopbal, waarna Cavani (foto) de score verdubbelde van dichtbij.\n" +
                "\n" +
                "Lyon kon daar werkelijk niets tegen inbrengen en onderging het spel. Toen het ook nog eens met tien man kwam te staan na een tweede gele kaart voor Maxime Gonalons, was het kalf helemaal verdronken.\n" +
                "\n" +
                "PSG mag de Franse Supercup voor de vijfde keer in de clubgeschiedenis in de prijzenkast plaatsen. Het is de derde opeenvolgende Supercup voor de vijfvoudige Franse kampioen.");
        fillNewsItem("Origi scoort in laatste oefenmatch Liverpool: \"Klaar voor seizoen\"", "Liverpool heeft zijn laatste oefengalop met succes afgesloten: het won bij de Finse kampioen HJK Helsinki met 0-2. Invaller Origi opende de score 20 minuten voor tijd. Coutinho stelde wat later de zege veilig.\n" +
                "Origi mocht op het uur invallen van coach Rodgers en hij bedankte met een goal 12 minuten later op aangeven van Milner. \"Klaar voor het nieuwe seizoen\", tweette de Rode Duivel.\n" +
                "\n" +
                "En dat begint Liverpool volgende week zondag op het veld van Stoke City.\n" +
                "\n");
        fillNewsItem("De Bruyne en Casteels helden in Duitse Supercup", "Wolfsburg heeft voor het eerst in de clubgeschiedenis de Duitse Supercup gewonnen. De bekerwinnaar versloeg in eigen huis landskampioen Bayern München na strafschoppen. Bij Wolfsburg speelden Kevin De Bruyne en Koen Casteels de hele wedstrijd. De Bruyne was goed voor de assist voor de late 1-1. Casteels stopte in de penaltyreeks de inzet van Xabi Alonso en kroonde zich tot de held van de avond.\n" +
                "Kevin De Bruyne kreeg vlak voor de aftrap zijn trofee voor Speler van het Jaar in de Bundesliga (foto). Dat inspireerde de Rode Duivel echter niet, want het duurde even voor hij zich liet opmerken in de eerste helft.\n" +
                "\n" +
                "\n" +
                "Bij Bayern kwam het gevaar vooral van de nieuwe aanwinst Douglas Costa. De Braziliaan, overgekomen van Sjachtjor Donetsk voor z'on 30 miljoen euro, was een ware gesel voor de Wolfsburg-verdediging.\n" +
                "\n" +
                "Ook Jérôme Boateng zat goed in de wedstrijd. Hij knalde van dichtbij staalhard op de lat. Veel kansen voor de bezoekers, maar geen doelpunten voor de rust.\n" +
                "\n" +
                "Na de koffie dook Douglas Costa, weer hij, meteen goed in de ruimte. Zijn voorzet was hard, maar niet onhoudbaar voor Casteels. Die loste jammerlijk en Robben kon van dichtbij binnenduwen.\n" +
                "\n" +
                "Dost miste nog een dot van een kans voor de thuisploeg en Bayern leek met de zege te gaan lopen. Maar dat was zonder De Bruyne gerekend. Met een precisievoorzet vond hij invaller Nicklas Bendtner en die aarzelde niet van dichtbij: 1-1 en op naar een penaltyreeks.\n" +
                "\n" +
                "Daarin wierp Koen Casteels, de vervanger van de geblesseerde Benaglio, zich op tot de held. Hij stopte de inzet van Xabi Alonso met een voetveeg en rolde zo de rode loper uit voor Wolfsburg richting eerste Supercup in de clubgeschiedenis. De Bruyne zette zijn elfmeter koel om, Bendtner trapte de beslissende binnen.");
    }

    private void fillNewsItem(String title, String content) {
        News news = new News();
        news.setTitle(title);
        news.setContent(content);
        newsService.create(news);
    }

    private void fillTeams() {
        fillTeam("Anderlecht");
        fillTeam("Club Brugge");
        fillTeam("Zulte Waregem");
        fillTeam("Racing Genk");
        fillTeam("AA Gent");
        fillTeam("KV Oostende");
        fillTeam("KV Mechelen");
        fillTeam("Sporting Lokeren");
        fillTeam("Standard");
        fillTeam("Sint-Truiden");
        fillTeam("Westerlo");
        fillTeam("KV Kortrijk");
        fillTeam("Waasland-Beveren");
        fillTeam("OH Leuven");
        fillTeam("Charleroi");
        fillTeam("Moeskroen");
    }

    private void fillTeam(String teamName) {
        Team team = new Team();
        team.setName(teamName);
        teamService.create(team);
    }

    @GET
    @Timed
    @Path("/clear")
    public void deleteAll() {
        LOG.debug("@GET /dev/clear delete all information from the database");
        newsService.deleteAll();
        gameService.deleteAll();
        teamService.deleteAll();
    }
}
