class SocialMediaPost {
    String author;
    String content;
    String time;

    SocialMediaPost(String author, String content, String time) {
        this.author = author;
        this.content = content;
        this.time = time;
    }

    void displayPost() {
        System.out.println("Post by " + author);
        System.out.println(content);
        System.out.println("Posted at: " + time);
    }
}

class InstagramPost extends SocialMediaPost {
    String hashtags;
    int likes;

    InstagramPost(String author, String content, String time, String hashtags, int likes) {
        super(author, content, time);
        this.hashtags = hashtags;
        this.likes = likes;
    }

    @Override
    void displayPost() {
        System.out.println("Instagram Post by " + author);
        System.out.println(content + " " + hashtags);
        System.out.println("Likes: " + likes);
        System.out.println("Posted at: " + time);
    }
}

class TwitterPost extends SocialMediaPost {
    int retweets;

    TwitterPost(String author, String content, String time, int retweets) {
        super(author, content, time);
        this.retweets = retweets;
    }

    @Override
    void displayPost() {
        System.out.println("Twitter Post by " + author + " (" + content.length() + " chars)");
        System.out.println(content);
        System.out.println("Retweets: " + retweets);
        System.out.println("Posted at: " + time);
    }
}

class LinkedInPost extends SocialMediaPost {
    int connections;

    LinkedInPost(String author, String content, String time, int connections) {
        super(author, content, time);
        this.connections = connections;
    }

    @Override
    void displayPost() {
        System.out.println("LinkedIn Post by " + author);
        System.out.println("[Professional Format] " + content);
        System.out.println("Connections Engaged: " + connections);
        System.out.println("Posted at: " + time);
    }
}

public class SocialMediaSystem {
    public static void main(String[] args) {
        SocialMediaPost[] posts = {
            new InstagramPost("Amit", "Check out my new artwork!", "18:41", "#Art #Insta", 1200),
            new TwitterPost("Elena", "Java is fun!", "18:45", 320),
            new LinkedInPost("Vikram", "Excited to announce my new role!", "18:47", 210)
        };
        for (SocialMediaPost p : posts) {
            p.displayPost();
            System.out.println("---");
        }
    }
}
