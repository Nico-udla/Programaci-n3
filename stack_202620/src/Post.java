import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    public Post(String url) {
    }

    private class post{
        private String url;
        private LocalDateTime fecha;

        public post(String url) {
            this.url = url;
            fecha = LocalDateTime.now();
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public LocalDateTime getFecha() {
            return fecha;
        }

        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }
        @Override
        public String toString() {
            return "Url: " + url + ", fecha = " +
                    fecha.format(DateTimeFormatter.ofPattern("dd/mm/yyyy HH:mm:ss"))+"\n";
        }

    }
}
