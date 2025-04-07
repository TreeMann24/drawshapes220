package drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape {
    private int height;
    private int length;
    
    public Triangle(Point clicked, int height, int length, Color color) {
        super(new Point(clicked.x, clicked.y));
        setBoundingBox(clicked.x - length/2, clicked.x + length/2, clicked.y - height/2, clicked.y + height/2);
        this.color = color;
        this.height = height;
        this.length = length;
    }

    @Override
    public void draw(Graphics g) {
        if (isSelected()) {
            g.setColor(this.color.darker());
        } else {
            g.setColor(getColor());
        }

        // Get the anchor point's x and y coordinates
        int x = (int) getAnchorPoint().getX();
        int y = (int) getAnchorPoint().getY();

        // Define the triangle's vertices based on the anchor point, height, and length
        int[] xPoints = { x, x - length / 2, x + length / 2 };
        int[] yPoints = { y - height / 2, y + height / 2, y + height / 2 };

        // Draw and fill the triangle
        g.fillPolygon(xPoints, yPoints, 3);
    }
    
    public String toString() {
        return String.format("CIRCLE %d %d %d %d %s %s", 
                this.getAnchorPoint().x, 
                this.getAnchorPoint().y,
                this.height,
                this.length,
                colorToString(this.getColor()),
                this.isSelected());
    }

    @Override
    public void setAnchorPoint(Point p) {
        // TODO: move bounding box
        this.anchorPoint = p;
    }
}
