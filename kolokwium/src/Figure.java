import java.awt.*;

public class Figure implements Runnable {
    ApplicationPanel ap;

    int x, y, width, height, speed = 2;
    Color color;

    public Figure(int x, int y, int width, int height, Color color, ApplicationPanel ap) {
        this.ap = ap;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void update() {
        while (y + height < ap.getHeight()) {
            if (checkCollision()) {
                break;
            }
            y += speed;
            ap.repaint();

            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public boolean checkCollision() {
        for (Figure other : ap.figures) {
            if (other != this && new Rectangle(x, y + speed, width, height)
                    .intersects(new Rectangle(other.x, other.y, other.width, other.height))) {
                return true;
            }
        }
        return false;
    }


    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fillRect(x, y, width, height);
    }

    @Override
    public void run() {
        update();
    }
}
