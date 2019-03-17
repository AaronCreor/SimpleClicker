import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GameMain {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    int counter;
    int upgrade;
    public GameMain() {
        prepareGUI();
    }
    public static void main(String[] args){
        GameMain SimpleClicker = new GameMain();
        SimpleClicker.showButton();

    }
    private void prepareGUI(){
        mainFrame = new JFrame("Simple Clicker"); //Sets title of program
        mainFrame.setSize(400,400); //Sets size of window
        mainFrame.setLayout(new GridLayout(3, 1));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); //Gets users screen size
        mainFrame.setLocation(dim.width/2-mainFrame.getSize().width/2, dim.height/2-mainFrame.getSize().height/2); //Makes window appear in center of users screen
        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(350,100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showButton(){
        headerLabel.setText("Simple Clicker");
        JButton clickButton = new JButton("Click"); //Creates click button
        JButton upgradeButton = new JButton("Upgrade"); //Creates click button
        clickButton.setActionCommand("Click"); //Sends the command "Click"
        upgradeButton.setActionCommand("Upgrade"); //Sends the command "Click"
        clickButton.addActionListener(new ButtonClickListener()); //Sets click button to read for clicks
        upgradeButton.addActionListener(new ButtonClickListener()); //Sets click button to read for clicks
        controlPanel.add(clickButton); //Adds the click button
        controlPanel.add(upgradeButton); //Adds the click button
        mainFrame.setVisible(true); //Makes click button visible
    }
    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals( "Click" ))  { //Checks if received command is "Click"
                counter++; //Increments number of clicks
                counter = counter + upgrade;
                String temp; //Used to store # of clicks
                temp = Integer.toString(counter); //Converts number of clicks to string
                statusLabel.setText(temp); //Sets status to # of clicks
            }
            if(command.equals("Upgrade")){
                if(counter > 0) {
                    upgrade++;
                    counter--;
                    String temp; //Used to store # of clicks
                    temp = Integer.toString(counter); //Converts number of clicks to string
                    statusLabel.setText(temp); //Sets status to # of clicks
                }
            }
        }
    }
}

