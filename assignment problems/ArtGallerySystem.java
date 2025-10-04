class ArtWork {
    String title;
    String artist;
    int year;

    ArtWork(String title, String artist, int year) {
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    void displayGeneralInfo() {
        System.out.println(title + " by " + artist + " (" + year + ")");
    }
}

class Painting extends ArtWork {
    String brushTechnique;
    String colorPalette;
    String frameSpec;

    Painting(String title, String artist, int year,
             String brushTechnique, String colorPalette, String frameSpec) {
        super(title, artist, year);
        this.brushTechnique = brushTechnique;
        this.colorPalette = colorPalette;
        this.frameSpec = frameSpec;
    }

    void showPaintingDetails() {
        System.out.println("Brush Technique: " + brushTechnique);
        System.out.println("Color Palette: " + colorPalette);
        System.out.println("Frame Specs: " + frameSpec);
    }
}

class Sculpture extends ArtWork {
    String material;
    String dimensions;
    String lighting;

    Sculpture(String title, String artist, int year,
              String material, String dimensions, String lighting) {
        super(title, artist, year);
        this.material = material;
        this.dimensions = dimensions;
        this.lighting = lighting;
    }

    void showSculptureDetails() {
        System.out.println("Material: " + material);
        System.out.println("Dimensions: " + dimensions);
        System.out.println("Lighting: " + lighting);
    }
}

class DigitalArt extends ArtWork {
    String resolution;
    String fileFormat;
    String interactiveElements;

    DigitalArt(String title, String artist, int year,
               String resolution, String fileFormat, String interactiveElements) {
        super(title, artist, year);
        this.resolution = resolution;
        this.fileFormat = fileFormat;
        this.interactiveElements = interactiveElements;
    }

    void showDigitalArtDetails() {
        System.out.println("Resolution: " + resolution);
        System.out.println("File Format: " + fileFormat);
        System.out.println("Interactive Elements: " + interactiveElements);
    }
}

class Photography extends ArtWork {
    String cameraSettings;
    String editingDetails;
    String printSpecs;

    Photography(String title, String artist, int year,
                String cameraSettings, String editingDetails, String printSpecs) {
        super(title, artist, year);
        this.cameraSettings = cameraSettings;
        this.editingDetails = editingDetails;
        this.printSpecs = printSpecs;
    }

    void showPhotographyDetails() {
        System.out.println("Camera Settings: " + cameraSettings);
        System.out.println("Editing Details: " + editingDetails);
        System.out.println("Print Specs: " + printSpecs);
    }
}

public class ArtGallerySystem {
    public static void main(String[] args) {
        ArtWork[] gallery = {
            new Painting("Sunset", "Meera", 2021, "Impasto", "Warm", "Wooden"),
            new Sculpture("Eagle", "Ajay", 2018, "Bronze", "2x3x1m", "Spotlight"),
            new DigitalArt("Virtual Dreams", "Sara", 2022, "4K", "PNG", "Touch Responsive"),
            new Photography("City Lights", "Dev", 2020, "ISO 800, f/2.8", "Color Boost", "A3 Glossy")
        };

        for (ArtWork art : gallery) {
            art.displayGeneralInfo();
        }
        System.out.println("--- Exhibition Details ---");

        // Downcasting for exhibition-specific details
        ((Painting)gallery[0]).showPaintingDetails();
        ((Sculpture)gallery[1]).showSculptureDetails();
        ((DigitalArt)gallery[2]).showDigitalArtDetails();
        ((Photography)gallery[3]).showPhotographyDetails();
    }
}
