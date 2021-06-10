import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;

// 참고한 사이트 https://www.youtube.com/watch?v=WspD6v6CK4A
public class Mp3Player {
    private Player player;
    private File file;
    private FileInputStream fis;
    private BufferedInputStream bis;

    public Mp3Player(String name) {
        try{
            file = new File(name);
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void play()
    {
        try {
            player.play();
        } catch (JavaLayerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close()
    {
        player.close();
    }
}
