import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVreader {
    String csvFile = "C:/Users/marti/IdeaProjects/3.Semester/CSVreader/src/moviedata.csv";
    String line = "";
    String splitter = ",";
    List<Movie> movieList = new ArrayList<>();

    public static void main(String[] args) {

        String csvFile = "C:/Users/marti/IdeaProjects/3.Semester/CSVreader/src/moviedata.csv";
        String line = "";
        String splitter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] movie = line.split(splitter);
                System.out.println("Movie titel: "+movie[11]+", Year: "+movie[23]+", IMDB score: "+movie[25]+" , Director name: "+movie[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void searchActor(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int counter = 1;
            movieList.add(new Movie("Titel", "Årstal", "IMDB-score", "Instruktør","Skuespillere"));
            while ((line = br.readLine()) != null) {
                String[] movie = line.split(splitter);
                if (movie[6].contains(name) || movie[10].contains(name) || movie[14].contains(name)) {
                    movieList.add(new Movie(movie[11],movie[23],movie[25],movie[1],(movie[6]+" & "+movie[10]+" & "+movie[14])));
                    System.out.print(counter+" -\u001B[34m Filmtitel: \u001B[0m"+movie[11]+",\u001B[31m Årstal: \u001B[0m"+movie[23]+",\u001B[32m IMDB-score: \u001B[0m"+movie[25]+" ,\u001B[33m Intruktør: \u001B[0m"+movie[1]+" ,\u001B[35m Skuespillere: \u001B[0m"+movie[6]+", "+movie[10]+" & "+movie[14]+".\n");
                    counter++;
                }
            }
            try (FileWriter fileWriter = new FileWriter("actorList.csv")) {
                for (Movie current: movieList) {
                    fileWriter.write(current.getTitel()+";"+current.getYear()+";"+current.getImdb()+";"+current.getDirector()+";"+current.getActors()+"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchIntructor(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            int counter = 1;
            movieList.add(new Movie("Titel", "Årstal", "IMDB-score", "Instruktør","Skuespillere"));
            while ((line = br.readLine()) != null) {
                String[] movie = line.split(splitter);
                if (movie[1].contains(name)) {
                    movieList.add(new Movie(movie[11],movie[23],movie[25],movie[1],(movie[6]+" & "+movie[10]+" & "+movie[14])));
                    System.out.println(counter+" -\u001B[34m Filmtitel: \u001B[0m"+movie[11]+",\u001B[31m Årstal: \u001B[0m"+movie[23]+",\u001B[32m IMDB-score: \u001B[0m"+movie[25]+" ,\u001B[33m Intruktør: \u001B[0m"+movie[1]+" ,\u001B[35m Skuespillere: \u001B[0m"+movie[6]+", "+movie[10]+" & "+movie[14]+".");
                    counter++;
                }
            }
            try (FileWriter fileWriter = new FileWriter("instructorList.csv")) {
                for (Movie current: movieList) {
                    fileWriter.write(current.getTitel()+";"+current.getYear()+";"+current.getImdb()+";"+current.getDirector()+";"+current.getActors()+"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}