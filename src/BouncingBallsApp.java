import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BouncingBallsApp extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_SIZE = 20;
    private int delay = 10;  // начальная задержка (скорость анимации)
    private Timer timer;

    private List<Ball> balls = new ArrayList<>();
    private int numBalls = 5; // Количество мячей

    public BouncingBallsApp() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        // Создаем мячи с разными начальными позициями
        for (int i = 0; i < numBalls; i++) {
            balls.add(new Ball(50 + i * 100, 50 + i * 60, 2 + i, 3 + i)); // Разные стартовые позиции
        }

        // Инициализируем таймер для обновления анимации
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBallsPosition();
                repaint();
            }
        });
        timer.start();

        // Создаем кнопки управления скоростью
        JButton increaseSpeedButton = new JButton("+");
        increaseSpeedButton.addActionListener(e -> increaseSpeed());

        JButton decreaseSpeedButton = new JButton("-");
        decreaseSpeedButton.addActionListener(e -> decreaseSpeed());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(decreaseSpeedButton);
        buttonPanel.add(increaseSpeedButton);

        JFrame frame = new JFrame("Bouncing Balls with Slow Motion Effect");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(this, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void updateBallsPosition() {
        for (Ball ball : balls) {
            ball.updatePosition();
        }
    }

    private void increaseSpeed() {
        if (delay > 1) {
            delay -= 2;  // Увеличение скорости (уменьшение задержки)
            timer.setDelay(delay);
        }
    }

    private void decreaseSpeed() {
        delay += 2;  // Замедление (увеличение задержки)
        timer.setDelay(delay);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        for (Ball ball : balls) {
            g.fillOval(ball.x, ball.y, BALL_SIZE, BALL_SIZE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BouncingBallsApp::new);
    }

    // Класс для мяча
    private static class Ball {
        int x, y;
        int dx, dy;

        public Ball(int x, int y, int dx, int dy) {
            this.x = x;
            this.y = y;
            this.dx = dx;
            this.dy = dy;
        }

        public void updatePosition() {
            x += dx;
            y += dy;

            // Проверка столкновений с границами экрана
            if (x <= 0 || x + BALL_SIZE >= WIDTH) {
                dx *= -1;
            }
            if (y <= 0 || y + BALL_SIZE >= HEIGHT) {
                dy *= -1;
            }
        }
    }
}
