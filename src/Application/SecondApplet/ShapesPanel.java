package Application.SecondApplet;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;

class ShapesPanel extends JPanel {

    //private java.util.List shapesList;
    private final HashMap<Shape, Color> shapesMap;
    private final HashMap<String, Color> colorMap;
    private Color figureColor;

    /**
     * Constructs <code>ShapesPanel</code>
     */
    public ShapesPanel() {
        shapesMap = new HashMap<>();

        colorMap = new HashMap<>();
        String[] colorNames = {"black", "blue", "cyan", "darkGray", "gray", "green", "lightGray", "magenta", "orange",
                "pink", "red", "white", "yellow"};
        Color[] colors = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.green, Color.lightGray,
                Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
        for (int i = 0; i < colors.length; i++) {
            colorMap.put(colorNames[i], colors[i]);
        }

    }

    /**
     * Creates a shape
     *
     * @param shapeType
     * @param bounds
     * @return
     */
    private Shape createShape(String shapeType, Rectangle bounds) {
        Shape shape = null;
        switch (shapeType) {
            case "Rectangle":
                shape = new Rectangle2D.Double(bounds.x, bounds.y, bounds.width, bounds.height);
                break;
            case "Oval":
                shape = new Ellipse2D.Double(bounds.x, bounds.y, bounds.width, bounds.height);
                break;
            default:
                System.err.println("Can't define shape at ShapesPanel.createShape()");
        }

        /*
        To use the following shapes, you need to have java shapes library, which can
        be downloaded from <a href="http://wwww.jshapes.com">Java Shapes Library</a>
        */
        /*
        // To create star shape
        Shape shape = new Star( bounds, 50, Star.STAR_8_POINTS );
        // To create triangle shape
        Shape shape = new Triangle( bounds, Triangle.UP );
        // To create diamond shape
        Shape shape = new Diamond( bounds );
        // To create Parallelogram shape
        Shape shape = new Parallelogram( bounds  );
        */

        return shape;
    }

    /**
     * Paints the component
     *
     * @param g
     */
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        Rectangle bounds = new Rectangle(0, 0, getWidth(), getHeight());
        g2.setPaint(Color.white);
        g2.fill(bounds);

        for (Map.Entry<Shape, Color> entry : shapesMap.entrySet()) {
            Shape shape = entry.getKey();
            g2.setPaint(entry.getValue());
            g2.fill(entry.getKey());
            g2.setPaint(Color.black);
            g2.draw(shape);
        }
    }


    public void actionPerformed(String shapeType, int x, int y, int width, int height, String color) {
        if (color == null) {
            figureColor = Color.black;
        } else {
            figureColor = colorMap.get(color);
        }
        Rectangle bounds = new Rectangle(x, y, width, height);
        Shape shape = createShape(shapeType, bounds);
        shapesMap.put(shape, figureColor);
        repaint();
    }

    public void clearScreen() {
        shapesMap.clear();
        repaint();
    }
}
