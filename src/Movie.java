public class Movie {
    private String titel;
    private String year;
    private String imdb;
    private String director;
    private String actors;

    public Movie() {
    }

    public Movie(String titel, String year, String imdb, String director, String actors) {
        this.titel = titel;
        this.year = year;
        this.imdb = imdb;
        this.director = director;
        this.actors = actors;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return titel+","+year+","+imdb+","+director+","+actors+"\n";
    }
}
