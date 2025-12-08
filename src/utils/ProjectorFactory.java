package utils;

import stream.models.Projector;
import stream.models.Projectors;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ProjectorFactory {

        private static final Random random = new Random();

        private static final List<Projector> projectorTemplates = Arrays.asList(
                new Projector("Epson EH-TW7000", 2023, 500.0, "Epson"),
                new Projector("BenQ TK700STi", 2024, 700.0, "BenQ"),
                new Projector("Optoma UHD35", 2023, 600.0, "Optoma"),
                new Projector("Sony VPL-FHZ75", 2022, 800.0, "Sony"),
                new Projector("LG CineBeam HU715Q", 2024, 550.0, "LG"),
                new Projector("ViewSonic PX701-4K", 2023, 650.0, "ViewSonic"),
                new Projector("Acer V6820i", 2022, 750.0, "Acer"),
                new Projector("Canon XEED WUX5000", 2024, 520.0, "Canon"),
                new Projector("Panasonic PT-VMZ50", 2023, 580.0, "Panasonic"),
                new Projector("NEC NP-PX1005UL", 2022, 720.0, "NEC"),
                new Projector("Epson PowerLite X41+", 2024, 630.0, "Epson"),
                new Projector("BenQ W2700i", 2023, 670.0, "BenQ"),
                new Projector("Optoma HD146X", 2022, 680.0, "Optoma"),
                new Projector("Sony VPL-FHZ80", 2024, 540.0, "Sony"),
                new Projector("LG CineBeam HU810PW", 2023, 590.0, "LG"),
                new Projector("ViewSonic X10-4K", 2022, 730.0, "ViewSonic"),
                new Projector("Acer H7850", 2024, 560.0, "Acer"),
                new Projector("Canon REALiS WUX450", 2023, 640.0, "Canon"),
                new Projector("Panasonic PT-RZ970", 2022, 710.0, "Panasonic"),
                new Projector("NEC NP-PX803UL", 2024, 510.0, "NEC"),
                new Projector("Epson EF-12", 2023, 620.0, "Epson"),
                new Projector("BenQ X3000i", 2022, 740.0, "BenQ"),
                new Projector("Optoma UHZ50", 2024, 530.0, "Optoma"),
                new Projector("Sony VPL-FHZ90", 2023, 660.0, "Sony"),
                new Projector("LG CineBeam PF1000U", 2022, 690.0, "LG"),
                new Projector("ViewSonic LS830", 2024, 570.0, "ViewSonic"),
                new Projector("Acer V7500", 2023, 610.0, "Acer"),
                new Projector("Canon REALiS WUX6010", 2022, 760.0, "Canon"),
                new Projector("Panasonic PT-RZ12K", 2024, 515.0, "Panasonic"),
                new Projector("NEC NP-PX803UL-B", 2023, 635.0, "NEC"),
                new Projector("Epson Home Cinema 5050UB", 2022, 725.0, "Epson"),
                new Projector("BenQ HT3550", 2024, 545.0, "BenQ"),
                new Projector("Optoma CinemaX P2", 2023, 585.0, "Optoma"),
                new Projector("Sony VPL-FHZ120", 2022, 715.0, "Sony"),
                new Projector("LG CineBeam HU915QE", 2024, 555.0, "LG"),
                new Projector("ViewSonic PJD7828HDL", 2023, 625.0, "ViewSonic"),
                new Projector("Acer H6815BD", 2022, 735.0, "Acer"),
                new Projector("Canon REALiS WUX6010Z", 2024, 525.0, "Canon"),
                new Projector("Panasonic PT-MZ16K", 2023, 645.0, "Panasonic"),
                new Projector("NEC NP-PX803UL-W", 2022, 745.0, "NEC"),
                new Projector("Epson Pro EX9240", 2024, 535.0, "Epson"),
                new Projector("BenQ LK953ST", 2023, 655.0, "BenQ"),
                new Projector("Optoma EH412", 2022, 755.0, "Optoma"),
                new Projector("Sony VPL-FHZ75L", 2024, 575.0, "Sony"),
                new Projector("LG CineBeam HU915QE-B", 2023, 615.0, "LG"),
                new Projector("ViewSonic LS830-B", 2022, 765.0, "ViewSonic"),
                new Projector("Acer V6820i-B", 2024, 505.0, "Acer"),
                new Projector("Canon XEED WUX5000-B", 2023, 665.0, "Canon"),
                new Projector("Panasonic PT-VMZ50-B", 2022, 775.0, "Panasonic"),
                new Projector("NEC NP-PX1005UL-B", 2024, 495.0, "NEC")
        );

        public static List<Projector> generateProjectors(int size) {
                List<Projector> shuffledTemplates = new java.util.ArrayList<>(projectorTemplates);
                java.util.Collections.shuffle(shuffledTemplates);
                
                // Limit size to available unique projectors
                int actualSize = Math.min(size, projectorTemplates.size());
                
                // Add unique projectors using Stream API with LinkedHashSet to preserve order
                return IntStream.range(0, actualSize)
                        .limit(shuffledTemplates.size())
                        .mapToObj(shuffledTemplates::get)
                        .collect(Collectors.toCollection(java.util.LinkedHashSet::new))
                        .stream()
                        .collect(Collectors.toList());
        }

        public static Projectors createProjectors(int size) {
                return new Projectors(generateProjectors(size));
        }

        public static Projectors createProjectors() {
                return new Projectors(new java.util.ArrayList<>(projectorTemplates));
        }

        public static Projector createRandomProjector() {
                return projectorTemplates.get(random.nextInt(projectorTemplates.size()));
        }
}
