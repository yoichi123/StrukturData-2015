/**
 * The VideoGame class represents a VideoGame object. Information about the 
 * VideoGame is stored and can be retrieved. We assume that we only deal 
 * with VideoGames at this stage.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class VideoGame extends Item 
{
    private int numberOfPlayers;
    private String platform;
    
    /**
     * Constructor for objects of class VideoGame
     * @param numOfPlayers The title of this VideoGame.
     * @param platformG The director of this VideoGame.
     * @param time The running time of the main feature.
     */
    public VideoGame(String theTitle, String platformG, int time, int numOfPlayers)
    {
        super(theTitle, time);
        numberOfPlayers = numOfPlayers;
        platform = platformG;
    }

    /**
     * @return The numberOfPlayers for this VideoGame.
     */
    public int getNumberOfPlayers()
    {
        return numberOfPlayers;
    }
    
    /**
     * @return The platform for this VideoGame.
     */
    public String platform()
    {
        return platform;
    }
}
