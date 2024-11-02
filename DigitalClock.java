import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitalClock extends JFrame {

    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;

    public DigitalClock() {
        // Set up the frame
        setTitle("Digital Clock");
        setSize(3000, 1500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set up time format
        timeFormat = new SimpleDateFormat("hh:mm:ss a");

        // Initialize the label to display time
        timeLabel = new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.BOLD, 100));

        // Add the label to the frame
        add(timeLabel, BorderLayout.CENTER);

        // Set up timer to update the clock every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClock();
            }
        });
        timer.start();

        setVisible(true);
    }

    private void updateClock() {
        // Get current time and format it
        String currentTime = timeFormat.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}

