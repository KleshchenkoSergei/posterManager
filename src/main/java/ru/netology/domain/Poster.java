package ru.netology.domain;

public class Poster {
    private int id;
    private String filmName;
    private String genre;

    public Poster(int id, String filmName, String genre) {
        this.id = id;
        this.filmName = filmName;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getFilmName() {
        return filmName;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
