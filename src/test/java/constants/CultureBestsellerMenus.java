package constants;

public enum CultureBestsellerMenus {

    BELLETRISTIK	("Belletristik"),
    SACHBUCH	("Sachbuch"),
    RATGEBER	("Ratgeber"),
    KINDER_JUGEND	("Kinder/ Jugend"),
    DVD	("DVD"),
    HARDCOVER	("Hardcover"),
    PAPERBACK	("Paperback"),
    TASCHENBUCH	("Taschenbuch"),
    HOERBUCH	("Hörbuch"),
    LEBEN_GESUNDHEIT	("Leben & Gesundheit"),
    ESSEN_TRINKEN	("Essen & Trinken"),
    NATUR_GARTEN	("Natur & Garten"),
    HOBBY_KREATIVITAET	("Hobby & Kreativität"),
    KINDERBUCH	("Kinderbuch"),
    JUGENDBUCH	("Jugendbuch"),
    BILDERBUCH	("Bilderbuch"),
    SPIELFILM	("Spielfilm"),
    TV_HOBBY	("TV & Hobby");

    public String title;

    CultureBestsellerMenus(String title) {this.title=title;}

    public String getTitle(){return this.title;}

}
