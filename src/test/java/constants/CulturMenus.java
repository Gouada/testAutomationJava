package constants;

public enum CulturMenus {
    KINO("Kino"),
    ALLES("Alles"),
    MUSIK("Musik"),
    TV("TV"),
    LITERATUR("Literatur"),
    BESTSELLER("SPIEGEL-Bestseller"),
    STREAMING("Streaming"),
    KUNST("Kunst");

    public String title;
     CulturMenus(String title)
     {
         this.title = title;
     }

    public String getTitle()
    {
        return this.title;
    }
    }
