class StreamingContent {
    String title;
    String genre;

    StreamingContent(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    void displayInfo() {
        System.out.println("Now Playing: " + title + " [" + genre + "]");
    }
}

class Movie extends StreamingContent {
    String rating;
    int durationMinutes;
    boolean subtitlesAvailable;

    Movie(String title, String genre, String rating, int durationMinutes, boolean subtitlesAvailable) {
        super(title, genre);
        this.rating = rating;
        this.durationMinutes = durationMinutes;
        this.subtitlesAvailable = subtitlesAvailable;
    }

    void showMovieFeatures() {
        System.out.println("Rating: " + rating + ", Duration: " + durationMinutes +
            " min, Subtitles: " + (subtitlesAvailable ? "Available" : "Not available"));
    }
}

class TVSeries extends StreamingContent {
    int seasons;
    int episodes;
    String nextEpisodeSuggestion;

    TVSeries(String title, String genre, int seasons, int episodes, String nextEpisode) {
        super(title, genre);
        this.seasons = seasons;
        this.episodes = episodes;
        this.nextEpisodeSuggestion = nextEpisode;
    }

    void showSeriesDetails() {
        System.out.println("Seasons: " + seasons + ", Episodes: " + episodes);
        System.out.println("Next Up: " + nextEpisodeSuggestion);
    }
}

class Documentary extends StreamingContent {
    String[] eduTags;
    String relatedContent;

    Documentary(String title, String genre, String[] eduTags, String relatedContent) {
        super(title, genre);
        this.eduTags = eduTags;
        this.relatedContent = relatedContent;
    }

    void showDocDetails() {
        System.out.print("Educational Tags: ");
        for (String tag : eduTags) {
            System.out.print(tag + " ");
        }
        System.out.println("\nRelated: " + relatedContent);
    }
}

public class StreamingService {
    public static void main(String[] args) {
        StreamingContent[] watchlist = {
            new Movie("Inception", "Sci-Fi", "PG-13", 148, true),
            new TVSeries("Planet Earth", "Nature", 2, 11, "S2E1: Jungles"),
            new Documentary("The Social Dilemma", "Tech", new String[]{"Ethics", "Internet"}, "The Great Hack")
        };

        for (StreamingContent content : watchlist) {
            content.displayInfo();
        }

        System.out.println("--- Details for current content ---");

        for (StreamingContent content : watchlist) {
            if (content instanceof Movie) {
                ((Movie)content).showMovieFeatures();
            } else if (content instanceof TVSeries) {
                ((TVSeries)content).showSeriesDetails();
            } else if (content instanceof Documentary) {
                ((Documentary)content).showDocDetails();
            }
            System.out.println();
        }
    }
}
