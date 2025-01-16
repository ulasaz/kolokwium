import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    private final ApplicationPanel ap;
    private Point startPoint;

    public MouseHandler(ApplicationPanel ap) {
        this.ap = ap;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point endPoint = e.getPoint();

        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);

        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);

        Color randomColor = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());

        Figure newFigure = new Figure(x, y, width, height, randomColor, ap);

        ap.addFigure(newFigure);

        new Thread(newFigure).start();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
