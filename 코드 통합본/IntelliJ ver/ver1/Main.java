import javax.swing.JFrame;

public class Main extends JFrame
{
    public static void main( String[] args )
    {
        Frame2 panelFrame = new Frame2();
        panelFrame.setVisible(true);

        Mp3Player test = new Mp3Player("output.mp3");
        test.play();

    } // end main
} // end class PanelDemo


