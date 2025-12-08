package utils;

import stream.models.Projector;
import stream.models.Projectors;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class ProjectorFactory {

        private static final Random random = new Random();

        private static final List<Projector> projectorTemplates = Arrays.asList(
                new Projector("Projector A", 2023, 500.0, "Manufacturer X"),
                new Projector("Projector B", 2024, 700.0, "Manufacturer Y"),
                new Projector("Projector C", 2023, 600.0, "Manufacturer X"),
                new Projector("Projector D", 2022, 800.0, "Manufacturer Z"),
                new Projector("Projector E", 2024, 550.0, "Manufacturer Y"),
                new Projector("Projector F", 2023, 650.0, "Manufacturer X"),
                new Projector("Projector G", 2022, 750.0, "Manufacturer Z"),
                new Projector("Projector H", 2024, 520.0, "Manufacturer Y"),
                new Projector("Projector I", 2023, 580.0, "Manufacturer X"),
                new Projector("Projector J", 2022, 720.0, "Manufacturer Z"),
                new Projector("Projector K", 2024, 630.0, "Manufacturer Y"),
                new Projector("Projector L", 2023, 670.0, "Manufacturer X"),
                new Projector("Projector M", 2022, 680.0, "Manufacturer Z"),
                new Projector("Projector N", 2024, 540.0, "Manufacturer Y"),
                new Projector("Projector O", 2023, 590.0, "Manufacturer X"),
                new Projector("Projector P", 2022, 730.0, "Manufacturer Z"),
                new Projector("Projector Q", 2024, 560.0, "Manufacturer Y"),
                new Projector("Projector R", 2023, 640.0, "Manufacturer X"),
                new Projector("Projector S", 2022, 710.0, "Manufacturer Z"),
                new Projector("Projector T", 2024, 510.0, "Manufacturer Y"),
                new Projector("Projector U", 2023, 620.0, "Manufacturer X"),
                new Projector("Projector V", 2022, 740.0, "Manufacturer Z"),
                new Projector("Projector W", 2024, 530.0, "Manufacturer Y"),
                new Projector("Projector X", 2023, 660.0, "Manufacturer X"),
                new Projector("Projector Y", 2022, 690.0, "Manufacturer Z"),
                new Projector("Projector Z", 2024, 570.0, "Manufacturer Y"),
                new Projector("Projector AA", 2023, 610.0, "Manufacturer X"),
                new Projector("Projector BB", 2022, 760.0, "Manufacturer Z"),
                new Projector("Projector CC", 2024, 515.0, "Manufacturer Y"),
                new Projector("Projector DD", 2023, 635.0, "Manufacturer X"),
                new Projector("Projector EE", 2022, 725.0, "Manufacturer Z"),
                new Projector("Projector FF", 2024, 545.0, "Manufacturer Y"),
                new Projector("Projector GG", 2023, 585.0, "Manufacturer X"),
                new Projector("Projector HH", 2022, 715.0, "Manufacturer Z"),
                new Projector("Projector II", 2024, 555.0, "Manufacturer Y"),
                new Projector("Projector JJ", 2023, 625.0, "Manufacturer X"),
                new Projector("Projector KK", 2022, 735.0, "Manufacturer Z"),
                new Projector("Projector LL", 2024, 525.0, "Manufacturer Y"),
                new Projector("Projector MM", 2023, 645.0, "Manufacturer X"),
                new Projector("Projector NN", 2022, 745.0, "Manufacturer Z"),
                new Projector("Projector OO", 2024, 535.0, "Manufacturer Y"),
                new Projector("Projector PP", 2023, 655.0, "Manufacturer X"),
                new Projector("Projector QQ", 2022, 755.0, "Manufacturer Z"),
                new Projector("Projector RR", 2024, 575.0, "Manufacturer Y"),
                new Projector("Projector SS", 2023, 615.0, "Manufacturer X"),
                new Projector("Projector TT", 2022, 765.0, "Manufacturer Z"),
                new Projector("Projector UU", 2024, 505.0, "Manufacturer Y"),
                new Projector("Projector VV", 2023, 665.0, "Manufacturer X"),
                new Projector("Projector WW", 2022, 775.0, "Manufacturer Z"),
                new Projector("Projector XX", 2024, 495.0, "Manufacturer Y")
        );

        /**
         * Generates a list of random projectors without duplicates
         * @param size number of projectors to generate
         * @return list of random projectors
         */
        public static List<Projector> generateProjectors(int size) {
                java.util.Set<Projector> projectorsSet = new java.util.LinkedHashSet<>();
                List<Projector> shuffledTemplates = new java.util.ArrayList<>(projectorTemplates);
                java.util.Collections.shuffle(shuffledTemplates);
                
                // Limit size to available unique projectors
                int actualSize = Math.min(size, projectorTemplates.size());
                
                // Add unique projectors
                for (int i = 0; i < actualSize && i < shuffledTemplates.size(); i++) {
                        projectorsSet.add(shuffledTemplates.get(i));
                }
                
                return new java.util.ArrayList<>(projectorsSet);
        }

        /**
         * Creates a Projectors instance with randomly generated projectors
         * @param size number of projectors to generate
         * @return Projectors instance
         */
        public static Projectors createProjectors(int size) {
                return new Projectors(generateProjectors(size));
        }

        /**
         * Creates a Projectors instance with all available projectors
         * @return Projectors instance
         */
        public static Projectors createProjectors() {
                return new Projectors(new java.util.ArrayList<>(projectorTemplates));
        }

        /**
         * Creates a random projector from the templates
         * @return random projector
         */
        public static Projector createRandomProjector() {
                return projectorTemplates.get(random.nextInt(projectorTemplates.size()));
        }
}
